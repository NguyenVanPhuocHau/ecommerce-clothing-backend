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
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartItemID;
    private Long cartID;
    private Long productVID;
    private double price;
    private int quantity;


}
