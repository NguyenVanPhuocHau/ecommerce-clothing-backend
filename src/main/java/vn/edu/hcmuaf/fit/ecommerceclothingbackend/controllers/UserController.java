package vn.edu.hcmuaf.fit.ecommerceclothingbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.User;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.UserAddress;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.AddNewAddressRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response.MessageResponse;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement.UserServiceImpl;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@PermitAll
@RequestMapping(path = "/api/v1/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    @GetMapping("/hau")
    public String hau(){
        return "hau";
    }
    @GetMapping("/address/{id}")
    public ResponseEntity<?> getAllAddress(@PathVariable int id) {
        return ResponseEntity.ok().body(userService.getAllAddressByUserId(id));
    }

    @PostMapping("/address/add")
    public ResponseEntity<?> saveAddress(@Valid @RequestBody AddNewAddressRequest newAddressRequest) {
        Optional<User> user = userService.getUserById(newAddressRequest.getUserId());
        if(user.isPresent()){
           User u =  user.get();
           UserAddress userAddress = new UserAddress(u,newAddressRequest.getFullName(), newAddressRequest.getPhone(),newAddressRequest.getProvince(),newAddressRequest.getDistrict(),newAddressRequest.getWard(),newAddressRequest.getAddress(),newAddressRequest.isDefault());
            userService.addNewAddress(userAddress);
        }else {
            MessageResponse messageResponse = new MessageResponse(400, "Thêm địa chỉ thất bại!");
            return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
        }
        MessageResponse messageResponse = new MessageResponse(200, "Thêm địa chỉ thành công!");
        return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
    }
    @GetMapping("/addressDefault/{id}")
    public ResponseEntity<?> getAddressDefaultById(@PathVariable int id) {
        return ResponseEntity.ok().body(userService.getDefaultAddress(id));
    }
}
