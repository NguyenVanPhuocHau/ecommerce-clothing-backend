package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_category",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_color",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "color_id")})
    private Set<ProductColor> productColors = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_size",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "size_id")})
    private Set<ProductSize> productSizes = new HashSet<>();
    @OneToMany(mappedBy = "product")
    private List<CartItems> cartItems;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("product")
    private List<ProductImage> productImages = new ArrayList<>();
    private String event;
    private String description;
    private String guide;
    private double price;

    private double discount;
    private int quantity;

    public Product(String productName, String description, String guide, double price, int quantity) {
        this.productName = productName;
        this.description = description;
        this.guide = guide;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String productName, String description, String guide, double price, double discount, int quantity) {
        this.productName = productName;
        this.description = description;
        this.guide = guide;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
    }
}
