package pet.supplies.and.fashion.shop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import pet.supplies.and.fashion.shop.ProductManagementApplication;
import pet.supplies.and.fashion.shop.domain.ProductDetailsViewed;
import pet.supplies.and.fashion.shop.domain.ProductRegistered;
import pet.supplies.and.fashion.shop.domain.ProductSearched;

@Entity
@Table(name = "Product_table")
@Data
//<<< DDD / Aggregate Root
public class Product {

    @Id
    private String id;

    private String name;

    private Money price;

    private String description;

    @PostPersist
    public void onPostPersist() {
        ProductRegistered productRegistered = new ProductRegistered(this);
        productRegistered.publishAfterCommit();

        ProductSearched productSearched = new ProductSearched(this);
        productSearched.publishAfterCommit();

        ProductDetailsViewed productDetailsViewed = new ProductDetailsViewed(
            this
        );
        productDetailsViewed.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ProductRepository repository() {
        ProductRepository productRepository = ProductManagementApplication.applicationContext.getBean(
            ProductRepository.class
        );
        return productRepository;
    }
}
//>>> DDD / Aggregate Root
