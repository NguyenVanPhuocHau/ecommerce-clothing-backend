package vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
  private String token;
  private int id;
  private String name;
  private String phone;
  private String avatar;
  private String email;
  private List<String> roles;

}