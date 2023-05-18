package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.OrderItem;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.OrderStatus;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.UserOrder;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.OrderStatusRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.IOrderStatusService;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.IOrderUserService;

import java.util.List;

@Component
public class OrderStatusService implements IOrderStatusService {
    @Autowired
    OrderStatusRepository orderStatusRepository;


    @Override
    public OrderStatus getOrderStatusById(int id) {
        return orderStatusRepository.findById(id).get();
    }
}
