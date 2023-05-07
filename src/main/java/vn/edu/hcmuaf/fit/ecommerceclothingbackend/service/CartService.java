package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;

import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.CartItems;

import java.util.List;
import java.util.Optional;

public interface CartService {
    public void addProduct(int idProduct, int idUser, int idColor, int idSize, int quantity);

    public void removeFromCart(int id);

    public void saveCartItems(CartItems cartItems);
    public void removeProduct(int idProduct, int idUser, int idColor, int idSize);

    public List<CartItems> findAllCartItemsById(int idUser);

    public Optional<CartItems> findCartItemById(int id);

    public Optional<CartItems> findByCart_idAndProduct_idAndSize_IdAndColor_id(int cartId, int productId, int sizeId, int colorId);
}
