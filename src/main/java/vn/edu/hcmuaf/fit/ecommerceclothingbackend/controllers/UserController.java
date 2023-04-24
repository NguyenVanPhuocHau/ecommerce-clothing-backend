package vn.edu.hcmuaf.fit.ecommerceclothingbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.User;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.UserServiceImpl;

import javax.annotation.security.PermitAll;
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
}
