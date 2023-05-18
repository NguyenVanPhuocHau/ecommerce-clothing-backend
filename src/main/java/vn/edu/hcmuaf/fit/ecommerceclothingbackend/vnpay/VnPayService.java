package vn.edu.hcmuaf.fit.ecommerceclothingbackend.vnpay;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VnPayService {
    public String payWithVNPAY(PaymentRequest paymentRequest, HttpServletRequest request) throws UnsupportedEncodingException {
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());

        cld.add(Calendar.MINUTE,15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        String vnp_IpAddr = Config.getRandomNumber(8);
        Map<String,String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version",VnPayConstant.vnp_Version);
        vnp_Params.put("vnp_Command",VnPayConstant.vnp_Command);
        vnp_Params.put("vnp_TmnCode",VnPayConstant.vnp_TmnCode);
        vnp_Params.put("vnp_Amount",String.valueOf(paymentRequest.vnp_Ammount*100));
        vnp_Params.put("vnp_BankCode", VnPayConstant.vnp_BankCode);
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        vnp_Params.put("vnp_CurrCode",VnPayConstant.vnp_CurrCode);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        vnp_Params.put("vnp_Locale",VnPayConstant.vnp_Locale);
        vnp_Params.put("vnp_OrderInfo",VnPayConstant.vnp_OrderInfo +vnp_IpAddr);
        vnp_Params.put("vnp_OrderType",VnPayConstant.vnp_OrderType);
        vnp_Params.put("vnp_ReturnUrl", VnPayConstant.vnp_ReturnUrl);
        vnp_Params.put("vnp_TxnRef", Config.getRandomNumber(8));
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldList = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldList);

        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();

        Iterator itr =  fieldList.iterator();
        while (itr.hasNext()){
            String fieldName = (String) itr.next();
            String fieldValue = vnp_Params.get(fieldName);
            if(fieldValue!=null && (fieldValue.length()>0)){
                hashData.append(fieldName);
                hashData.append("=");
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));

                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append("=");
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));

                if(itr.hasNext()){
                    query.append("&");
                    hashData.append("&");
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(VnPayConstant.vnp_HashSecret,hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VnPayConstant.vnp_Url + "?" + queryUrl;
        return paymentUrl;
    }

}
