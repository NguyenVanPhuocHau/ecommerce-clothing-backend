package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

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
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cart cart;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Roles> roles = new HashSet<>();
    private String username;
    private String password;
    private String email;
    private String status;
    private Calendar createAt;
    @OneToMany(mappedBy = "user")
    private List<UserAddress> userAddress;
    @OneToMany(mappedBy = "user")
    private List<UserOrder> userOrder;



}
