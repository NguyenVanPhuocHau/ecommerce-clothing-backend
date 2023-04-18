package vn.edu.hcmuaf.fit.ecommerceclothingbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private int id;

    private String name;

    private String email;

    private String phone;

    private String avatar;

    private int userParent;

    private String userStatus;


}