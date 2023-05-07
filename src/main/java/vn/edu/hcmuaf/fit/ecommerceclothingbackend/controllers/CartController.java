package vn.edu.hcmuaf.fit.ecommerceclothingbackend.controllers;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.CartItems;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.AddCartRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.LoginRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.RemoveCartItemRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.UpdateQuantityCartItemRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response.MessageResponse;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.CartItemsRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.CartService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody AddCartRequest request) {

        Optional<CartItems> cartItems = cartService.findByCart_idAndProduct_idAndSize_IdAndColor_id(request.getIdUser(),request.getIdProduct(),request.getIdSize(),request.getIdColor());
        if (cartItems.isPresent()) {

            CartItems item = cartItems.get();
            item.setQuantity(item.getQuantity()+1);
            cartService.saveCartItems(item);
        } else {
            cartService.addProduct(request.getIdProduct(),request.getIdUser(),request.getIdColor(),request.getIdSize(),request.getQuantity());
        }
        MessageResponse messageResponse = new MessageResponse(200, "Đã thêm sản phẩm+"+request.getIdProduct()+"!");
        return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
    }

    @GetMapping("/cartItems/{id}")
    public ResponseEntity<?>  getCartItems(@PathVariable int id) {
        System.out.println("in");
        return ResponseEntity.ok().body(cartService.findAllCartItemsById(id));
    }

    @GetMapping("/cartItems")
    public ResponseEntity<?>  getCartItemsByCartIdByProductIdBySizeIdByColorId(@RequestParam int cartId,@RequestParam int productId,@RequestParam int sizeId,@RequestParam int colorId) {
        return ResponseEntity.ok().body(cartService.findByCart_idAndProduct_idAndSize_IdAndColor_id(cartId,productId,sizeId,colorId));
    }

    @PostMapping("/remove")
    public ResponseEntity<?>  removeCartItem(@Valid @RequestBody RemoveCartItemRequest request) {
        cartService.removeFromCart(request.getCartItemId());
        MessageResponse messageResponse = new MessageResponse(200, "xóa thành công!");
        return ResponseEntity.ok().body(messageResponse);
    }

    @PostMapping("/cartItems/updateNum")
    public ResponseEntity<?>  updateNumOfItem(@Valid @RequestBody UpdateQuantityCartItemRequest request) {
        Optional<CartItems> cartItems = cartService.findCartItemById(request.getCartItemId());
        if (cartItems.isPresent()) {

            CartItems item = cartItems.get();
            item.setQuantity(item.getQuantity()+request.getNum());
            cartService.saveCartItems(item);
        } else {
            MessageResponse messageResponse = new MessageResponse(400, "Không tìm thấy cart item!");
            return ResponseEntity.ok().body(messageResponse);
        }
        MessageResponse messageResponse = new MessageResponse(200, "update thành công!");
        return ResponseEntity.ok().body(messageResponse);
    }




}
