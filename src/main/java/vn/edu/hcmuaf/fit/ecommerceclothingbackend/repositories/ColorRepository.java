package vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.ProductColor;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.ProductSize;

public interface ColorRepository extends JpaRepository<ProductColor,Integer> {
    void  save(ProductSize productSize);

    ProductColor findByColorCode(String code);
}
