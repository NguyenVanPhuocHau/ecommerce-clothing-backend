package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String size;
//    @OneToMany(mappedBy = "productSize")
////    @JsonIgnoreProperties("productSize")
//    private List<CartItems> cartItems;
//    @ManyToMany(mappedBy = "categories")
//    private Set<Product> products = new HashSet<>();

    public ProductSize(String size) {
        this.size = size;
    }

}
