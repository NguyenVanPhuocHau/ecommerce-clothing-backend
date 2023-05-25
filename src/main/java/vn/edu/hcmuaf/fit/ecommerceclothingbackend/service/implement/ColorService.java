package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.ProductColor;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.ColorRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.IColorService;

import java.util.List;

@Component
public class ColorService implements IColorService {
    @Autowired
    ColorRepository colorRepository;
    @Override
    public List<ProductColor> getAllProductColor() {
        return colorRepository.findAll();
    }
}
