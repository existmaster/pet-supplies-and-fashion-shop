package pet.supplies.and.fashion.shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import pet.supplies.and.fashion.shop.domain.*;
import pet.supplies.and.fashion.shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserLoggedIn extends AbstractEvent {

    public UserLoggedIn(User aggregate) {
        super(aggregate);
    }

    public UserLoggedIn() {
        super();
    }
}
//>>> DDD / Domain Event
