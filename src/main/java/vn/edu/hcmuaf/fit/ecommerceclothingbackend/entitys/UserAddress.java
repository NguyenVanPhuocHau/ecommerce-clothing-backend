package vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    private String fullName;
    private String phone;
    private String province;
    private String district;
    private String ward;
    private String address;
    private boolean isDefault;

    public UserAddress(User user, String fullName, String phone, String province, String district, String ward, String address, boolean isDefault) {
        this.user = user;
        this.fullName = fullName;
        this.phone = phone;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.isDefault = isDefault;
    }
}
