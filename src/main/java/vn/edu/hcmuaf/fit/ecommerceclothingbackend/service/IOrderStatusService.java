package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;

import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.OrderStatus;

@Service
public interface IOrderStatusService {
    public OrderStatus getOrderStatusById(int id);
}
