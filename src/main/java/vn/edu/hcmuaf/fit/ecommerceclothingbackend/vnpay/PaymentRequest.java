package vn.edu.hcmuaf.fit.ecommerceclothingbackend.vnpay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    public Long vnp_Ammount;
}
