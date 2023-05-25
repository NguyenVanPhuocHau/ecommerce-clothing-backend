package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;

import org.hibernate.engine.jdbc.Size;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.ProductSize;

import java.util.List;

@Service
public interface ISizeService {
    List<ProductSize> getAllProductSize();
}
