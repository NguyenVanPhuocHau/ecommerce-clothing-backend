package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;


import vn.edu.hcmuaf.fit.ecommerceclothingbackend.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    void saveUser(User user);
    void deleteUser(int id);
}
