package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private double totalAmount;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus orderStatus;
    private Date createAt;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    private String payment;
    private double discountPrice;



}
