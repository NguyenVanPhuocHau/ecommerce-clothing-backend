package vn.edu.hcmuaf.fit.ecommerceclothingbackend.model.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@ToString
public class ProductDto {
    int id;
    String name;
    String description;
    double price;
    int categoryId;
    Set<String> images = new HashSet<>();
}
