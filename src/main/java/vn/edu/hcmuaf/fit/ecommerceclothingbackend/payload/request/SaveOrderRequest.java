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
public class SaveOrderRequest {
    private int userId;
    private double totalAmount;
    private String payment;
    private double discountPrice;
    private int addressId;
}
