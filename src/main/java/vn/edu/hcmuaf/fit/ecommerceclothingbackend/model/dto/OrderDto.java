package vn.edu.hcmuaf.fit.ecommerceclothingbackend.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    int id;
    Calendar createDate;
//    Set<OrderDetailResponse> orderDetails = new HashSet<>();
    double discountVoucher;
    String address;
    String phoneNum;
    String name;
    double totalBill;
}
