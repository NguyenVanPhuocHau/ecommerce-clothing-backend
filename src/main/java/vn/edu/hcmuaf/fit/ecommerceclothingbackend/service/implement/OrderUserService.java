package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.OrderItem;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.UserOrder;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.OrderRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.IOrderUserService;

import java.util.List;

@Component
public class OrderUserService implements IOrderUserService {
    @Autowired
    OrderRepository orderRepository;


    @Override
    public List<OrderItem> saveOrder(UserOrder userOrder) {
        return orderRepository.save(userOrder).getOrderItems();
    }
}
