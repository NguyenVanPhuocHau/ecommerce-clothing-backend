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
    private int ID;
    @ManyToOne
    @JoinColumn(name = "product_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "size_ID")
    private ProductSize productSize;
    @ManyToOne
    @JoinColumn(name = "color_ID")
    private ProductColor productColor;
    private int colorID;
    private int quantity;
    private double price;


}
