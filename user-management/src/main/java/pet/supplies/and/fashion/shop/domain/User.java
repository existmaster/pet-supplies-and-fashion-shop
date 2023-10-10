package pet.supplies.and.fashion.shop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import pet.supplies.and.fashion.shop.UserManagementApplication;
import pet.supplies.and.fashion.shop.domain.UserLoggedIn;
import pet.supplies.and.fashion.shop.domain.UserLoggedOut;
import pet.supplies.and.fashion.shop.domain.UserSignedUp;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    private String id;

    private Password password;

    private String name;

    private Email email;

    @PostPersist
    public void onPostPersist() {
        UserSignedUp userSignedUp = new UserSignedUp(this);
        userSignedUp.publishAfterCommit();

        UserLoggedIn userLoggedIn = new UserLoggedIn(this);
        userLoggedIn.publishAfterCommit();

        UserLoggedOut userLoggedOut = new UserLoggedOut(this);
        userLoggedOut.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static UserRepository repository() {
        UserRepository userRepository = UserManagementApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }
}
//>>> DDD / Aggregate Root
