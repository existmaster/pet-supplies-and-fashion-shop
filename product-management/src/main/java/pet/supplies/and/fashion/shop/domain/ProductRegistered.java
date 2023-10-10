package pet.supplies.and.fashion.shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import pet.supplies.and.fashion.shop.domain.*;
import pet.supplies.and.fashion.shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductRegistered extends AbstractEvent {

    public ProductRegistered(Product aggregate) {
        super(aggregate);
    }

    public ProductRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
