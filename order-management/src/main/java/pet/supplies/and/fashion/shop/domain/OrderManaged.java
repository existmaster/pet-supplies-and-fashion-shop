package pet.supplies.and.fashion.shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import pet.supplies.and.fashion.shop.domain.*;
import pet.supplies.and.fashion.shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderManaged extends AbstractEvent {

    public OrderManaged(Order aggregate) {
        super(aggregate);
    }

    public OrderManaged() {
        super();
    }
}
//>>> DDD / Domain Event
