package vn.edu.hcmuaf.fit.ecommerceclothingbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String gender;
    private Date birthday;
    private String avatar;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
