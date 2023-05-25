package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.ProductSize;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.SizeRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.ISizeService;

import java.util.List;

@Component
public class SizeService implements ISizeService {
    @Autowired
    SizeRepository sizeRepository;
    @Override
    public List<ProductSize> getAllProductSize() {
        return sizeRepository.findAll();
    }
}
