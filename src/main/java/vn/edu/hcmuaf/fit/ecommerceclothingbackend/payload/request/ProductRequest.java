package vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request;

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
public class ProductRequest {
    int id;
    String name;
    String description;
    double price;
    int categoryId;
    Set<String> images = new HashSet<>();
}
