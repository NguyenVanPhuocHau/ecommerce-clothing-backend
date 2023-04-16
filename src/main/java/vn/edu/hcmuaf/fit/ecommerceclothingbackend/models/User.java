package vn.edu.hcmuaf.fit.ecommerceclothingbackend.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Component
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserInformation information;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Roles> roles = new HashSet<>();
    private String userName;
    private String password;
    private String email;
    private String status;
    private Calendar createAt;
    @OneToMany(mappedBy = "user")
    private List<UserAddress> userAddress;
    @OneToMany(mappedBy = "user")
    private List<UserOrder> userOrder;


}
