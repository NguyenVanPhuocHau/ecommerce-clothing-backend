package vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.Cart;

import java.util.List;
import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart,Integer> {


    @Override
    List<Cart> findAll();

}
