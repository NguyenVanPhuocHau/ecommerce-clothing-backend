package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
//    private double price;
//    private int quantity;
//    @ManyToOne
//    @Id
//    @JoinColumn(name = "productV_id")
//    private ProductVariants productVariants;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @ManyToOne
    @JoinColumn(name = "product_id")
//    @JsonIgnoreProperties("cartItems")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "size_id")
//    @JsonIgnoreProperties("cartItems")
    private ProductSize productSize;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private ProductColor productColor;
    private int quantity;
    private double price;
    //    @OneToOne(mappedBy = "productVariants", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @JsonIgnoreProperties("productVariants")
//    private CartItems cartItems;
//    @OneToOne(mappedBy = "productVariants", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @JsonIgnoreProperties("productVariants")
//    private OrderItem orderItem;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnoreProperties("cartItems")
    private Cart cart;
}
