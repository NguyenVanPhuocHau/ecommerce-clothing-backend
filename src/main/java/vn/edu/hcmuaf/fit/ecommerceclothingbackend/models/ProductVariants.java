package vn.edu.hcmuaf.fit.ecommerceclothingbackend.models;

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
public class ProductVariants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "size_id")
    private ProductSize productSize;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private ProductColor productColor;
    private int quantity;
    private double price;
    @OneToOne(mappedBy = "productVariants", cascade = CascadeType.ALL)
    private CartItems cartItems;
    @OneToOne(mappedBy = "productVariants", cascade = CascadeType.ALL)
    private OrderItem orderItem;


}
