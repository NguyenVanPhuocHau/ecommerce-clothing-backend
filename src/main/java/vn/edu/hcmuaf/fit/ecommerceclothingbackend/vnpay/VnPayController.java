package vn.edu.hcmuaf.fit.ecommerceclothingbackend.vnpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/v1/payment")
public class VnPayController {
    @Autowired
    VnPayService vnPayService;
    @PostMapping("/vnpay")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest paymentRequest , HttpServletRequest request) throws IOException {
        String url = "";
        try {
             url = vnPayService.payWithVNPAY(paymentRequest, request);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        VnPayResponse result = new VnPayResponse();
        result.setStatus("200");
        result.setMessage("success");
        result.setUrl(url);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/hau")
    public String getHau(){
        return  "hau";
    }


}
