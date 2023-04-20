package vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JwtResponse {
//  private String token;
//  private int id;
//  private String name;
//  private String phone;
//  private String avatar;
//  private String email;
//  private List<String> roles;

  private String token;
  private String type = "Bearer";
  private int id;
  private int status;
  private String username;
  private String email;
  private List<String> roles;


}