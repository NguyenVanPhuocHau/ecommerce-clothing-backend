package vn.edu.hcmuaf.fit.ecommerceclothingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.AddCartRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.LoginRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response.MessageResponse;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.CartItemsRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.CartService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody AddCartRequest request) {
        cartService.addProduct(request.getIdProduct(),request.getIdUser(),request.getIdColor(),request.getIdSize(),request.getQuantity());
        MessageResponse messageResponse = new MessageResponse(200, "Đã thêm sản phẩm+"+request.getIdProduct()+"!");
        return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
    }

    @GetMapping("/cartItems/{id}")
    public ResponseEntity<?>  getCartItems(@PathVariable int id) {
        System.out.println("in");
        return ResponseEntity.ok().body(cartService.findAllCartItemsById(id));
    }


}
