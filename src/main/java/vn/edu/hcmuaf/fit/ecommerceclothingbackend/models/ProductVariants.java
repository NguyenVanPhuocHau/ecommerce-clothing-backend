package vn.edu.hcmuaf.fit.ecommerceclothingbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductVariants {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productVID;
    private Long productID;
    private Long sizeID;
    private Long colorID;
    private int quantity;
    private double price;


}
