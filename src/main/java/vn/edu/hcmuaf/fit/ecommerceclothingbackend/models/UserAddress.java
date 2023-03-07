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
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userAddressID;
    private Long userID;
    private String commune;
    private String district;
    private String province;
    private String address;
    private String note;
    private boolean isDefault;

}
