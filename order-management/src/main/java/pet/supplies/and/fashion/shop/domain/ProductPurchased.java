package pet.supplies.and.fashion.shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import pet.supplies.and.fashion.shop.domain.*;
import pet.supplies.and.fashion.shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductPurchased extends AbstractEvent {

    public ProductPurchased(Order aggregate) {
        super(aggregate);
    }

    public ProductPurchased() {
        super();
    }
}
//>>> DDD / Domain Event
