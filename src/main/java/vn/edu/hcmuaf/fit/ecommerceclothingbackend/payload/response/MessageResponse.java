package vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MessageResponse {
  @JsonProperty("status")
  private int status;

  @JsonProperty("msg")
  private String msg;

  public MessageResponse(int status, String msg) {
    this.status = status;
    this.msg = msg;
  }

}