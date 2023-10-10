package pet.supplies.and.fashion.shop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import pet.supplies.and.fashion.shop.OrderManagementApplication;
import pet.supplies.and.fashion.shop.domain.ProductPurchased;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    private String id;

    private String productId;

    private Integer quantity;

    private Address shippingAddress;

    private String paymentMethod;

    @PostPersist
    public void onPostPersist() {
        ProductPurchased productPurchased = new ProductPurchased(this);
        productPurchased.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderManagementApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void manageOrders() {
        //implement business logic here:

        OrderManaged orderManaged = new OrderManaged(this);
        orderManaged.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
