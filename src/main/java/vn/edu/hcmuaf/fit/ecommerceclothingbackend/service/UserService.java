package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;


import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.models.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    void saveUser(User user);
    void deleteUser(int id);

    Optional<User> getUserByEmail(String email);
}
