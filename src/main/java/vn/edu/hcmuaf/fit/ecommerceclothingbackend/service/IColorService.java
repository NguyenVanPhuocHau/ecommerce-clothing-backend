package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;

import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.ProductColor;

import java.util.List;

@Service
public interface IColorService {
    public List<ProductColor> getAllProductColor();
}
