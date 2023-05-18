package vn.edu.hcmuaf.fit.ecommerceclothingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.CartItems;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.OrderItem;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.UserOrder;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.SaveOrderRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.CartService;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement.OrderStatusService;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement.OrderUserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    OrderUserService orderUserService;
    @Autowired
    CartService cartService;

    @Autowired
    OrderStatusService orderStatusService;

    @PostMapping("/save")
    public ResponseEntity<?> saveOrder(@RequestBody SaveOrderRequest request) {
        UserOrder newOrder = new UserOrder();
        List<CartItems> listItems = cartService.findAllCartItemsById(request.getUserId());
        List<OrderItem> listOrder = new ArrayList<>();
        for (CartItems item : listItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setPrice(item.getPrice());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setOrder(newOrder);
            orderItem.setProduct(item.getProduct());
            orderItem.setProductColor(item.getProductColor());
            orderItem.setProductSize(item.getProductSize());
            listOrder.add(orderItem);
        }
        newOrder.setOrderItems(listOrder);
        newOrder.setCreateAt(new Date());
        newOrder.setOrderStatus(orderStatusService.getOrderStatusById(1));
        newOrder.setPayment(request.getPayment());
        newOrder.setDiscountPrice(request.getDiscountprice());
        return ResponseEntity.status(HttpStatus.OK).body(newOrder);
    }

    @GetMapping("/hau")
    ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok().body(orderStatusService.getOrderStatusById(1));
    }

}
