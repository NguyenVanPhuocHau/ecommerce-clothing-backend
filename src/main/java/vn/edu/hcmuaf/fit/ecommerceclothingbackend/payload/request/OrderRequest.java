package vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request;

//import com.example.restful_demo.model.dto.OrderDetailDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
//    Set<OrderDetailDto> orderDetails = new HashSet<>();
    int voucherId;
    int userId;
    double totalPrice;
    String address;
    String phoneNum;
    String name;


}
