package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private String productMaterial;
    @ManyToOne(fetch = FetchType.LAZY)
    Category category;
    @OneToMany(mappedBy = "product")
    private List<ProductVariants> productVariants;
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;


}
