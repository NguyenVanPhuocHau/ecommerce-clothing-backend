package vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response;


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
public class OrderDetailResponse {
    int id;
    int quantity;
    String size;
//    ProductDto product;
}
