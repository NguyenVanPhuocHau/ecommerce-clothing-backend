package vn.edu.hcmuaf.fit.ecommerceclothingbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    int quantity;
    String size;
    int productId;
}
