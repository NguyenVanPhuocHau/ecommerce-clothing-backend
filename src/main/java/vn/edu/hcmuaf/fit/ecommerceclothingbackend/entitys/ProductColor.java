package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String colorCode;
    private  String color;
    @OneToMany(mappedBy = "productColor")
    private List<CartItems> cartItems;
//    @ManyToMany(mappedBy = "categories")
//    private Set<Product> products = new HashSet<>();

    public ProductColor(String colorCode, String color) {
        this.colorCode = colorCode;
        this.color = color;
    }
}
