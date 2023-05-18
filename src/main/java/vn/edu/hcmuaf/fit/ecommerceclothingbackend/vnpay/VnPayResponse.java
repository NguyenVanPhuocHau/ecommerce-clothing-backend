package vn.edu.hcmuaf.fit.ecommerceclothingbackend.vnpay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VnPayResponse {
    String status;
    String message;
    String url;
}
