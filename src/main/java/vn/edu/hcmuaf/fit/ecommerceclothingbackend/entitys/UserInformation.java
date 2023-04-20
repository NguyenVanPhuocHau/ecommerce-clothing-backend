package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String gender;
    private Calendar birthday;
    private String avatar;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;


}
