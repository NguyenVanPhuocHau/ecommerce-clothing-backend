package vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request;

import com.example.restful_demo.entity.Voucher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserVoucher {
    int id;
    Set<Voucher> vouchers = new HashSet<>();
}
