package vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.Cart;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.CartItems;

import java.util.List;
import java.util.Optional;

public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {
    List<CartItems> findByCart_id(int userId);

    Optional<CartItems> findByCart_idAndProduct_idAndProductSize_idAndProductColor_id(int cartId,int productId, int sizeId, int colorId);

    void deleteById(int id);


}
