package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties("userOrder")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    @OneToMany(mappedBy = "orderStatus")
    private List<UserOrder> userOrder;

    public OrderStatus(String status) {
        this.status = status;
    }
}
