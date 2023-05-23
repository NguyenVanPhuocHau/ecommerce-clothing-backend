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
@JsonIgnoreProperties("order")
public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private UserOrder order;
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "productV_id")
//    private ProductVariants productVariants;
//    private double priceCurrent;
//    private int quantity;

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
    //    @OneToOne(mappedBy = "productVariants", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @JsonIgnoreProperties("productVariants")
//    private CartItems cartItems;
//    @OneToOne(mappedBy = "productVariants", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @JsonIgnoreProperties("productVariants")
//    private OrderItem orderItem;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private UserOrder order;


}
