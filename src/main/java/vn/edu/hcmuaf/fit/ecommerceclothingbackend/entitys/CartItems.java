package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    private double price;
    private int quantity;
    @OneToOne
    @MapsId
    @JoinColumn(name = "productV_id")
    private ProductVariants productVariants;


}
