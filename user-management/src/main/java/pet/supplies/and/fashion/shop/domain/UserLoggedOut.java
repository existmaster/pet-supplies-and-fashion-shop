package pet.supplies.and.fashion.shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import pet.supplies.and.fashion.shop.domain.*;
import pet.supplies.and.fashion.shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserLoggedOut extends AbstractEvent {

    public UserLoggedOut(User aggregate) {
        super(aggregate);
    }

    public UserLoggedOut() {
        super();
    }
}
//>>> DDD / Domain Event
