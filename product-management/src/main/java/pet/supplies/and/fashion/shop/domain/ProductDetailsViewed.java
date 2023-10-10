package pet.supplies.and.fashion.shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import pet.supplies.and.fashion.shop.domain.*;
import pet.supplies.and.fashion.shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductDetailsViewed extends AbstractEvent {

    public ProductDetailsViewed(Product aggregate) {
        super(aggregate);
    }

    public ProductDetailsViewed() {
        super();
    }
}
//>>> DDD / Domain Event
