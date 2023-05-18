package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;

import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.OrderItem;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.UserOrder;

import java.util.List;

@Service
public interface IOrderUserService {
    public List<OrderItem> saveOrder(UserOrder userOrder);
}
