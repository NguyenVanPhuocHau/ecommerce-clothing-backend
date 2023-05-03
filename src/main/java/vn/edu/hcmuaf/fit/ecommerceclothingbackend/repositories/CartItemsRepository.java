package vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.CartItems;

import java.util.List;

public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {
    List<CartItems> findByCart_id(int userId);
}
