package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.Cart;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.CartItems;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.Product;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.CartService;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemsRepository cartItemsRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    SizeRepository sizeRepository;
    @Override
    public void addProduct(int idProduct, int idUser, int idColor, int idSize, int quantity) {
        CartItems item = new CartItems();
        Product product = productRepository.getById(idProduct);
        item.setCart(cartRepository.getById(idUser));
        item.setProduct(product);
        item.setProductColor(colorRepository.findById(idColor).get());
        item.setProductSize(sizeRepository.findById(idSize).get());
        item.setQuantity(quantity);
        item.setPrice(product.getPrice());
        cartItemsRepository.save(item);
        Cart cart = cartRepository.getById(idUser);
        double totalPrice = product.getPrice() * quantity;
        cart.setTotalPrice(cart.getTotalPrice()+totalPrice);
        cartRepository.save(cart);

    }

    @Override
    public void removeFromCart(int id) {
        cartItemsRepository.deleteById(id);
    }

    @Override
    public void saveCartItems(CartItems cartItems) {
        cartItemsRepository.save(cartItems);
        Cart cart = cartItems.getCart();
        Product product = cartItems.getProduct();
        cart.setTotalPrice(cart.getTotalPrice()+product.getPrice());
        cartRepository.save(cart);
    }

    @Override
    public void removeProduct(int idProduct, int idUser, int idColor, int idSize) {

    }

    @Override
    public List<CartItems> findAllCartItemsById(int idUser) {
        return cartItemsRepository.findByCart_id(idUser);
    }

    @Override
    public Optional<CartItems> findCartItemById(int id) {
        return cartItemsRepository.findById(id);
    }

    @Override
    public Optional<CartItems> findByCart_idAndProduct_idAndSize_IdAndColor_id(int cartId, int productId, int sizeId, int colorId) {
        return cartItemsRepository.findByCart_idAndProduct_idAndProductSize_idAndProductColor_id(cartId,productId,sizeId,colorId);
    }

    @Override
    public void removeCartItemsById(int id) {
        cartItemsRepository.deleteById(id);
    }
}
