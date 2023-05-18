package vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddNewAddressRequest {
    private int userId;
    private String fullName;
    private String phone;
    private String province;
    private String district;
    private String ward;
    private String address;
    private boolean isDefault;

}
