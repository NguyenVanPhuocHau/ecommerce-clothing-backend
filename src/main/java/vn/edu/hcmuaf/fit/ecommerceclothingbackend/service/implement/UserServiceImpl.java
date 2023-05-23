package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.User;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.UserAddress;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.UserAddressRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.UserRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveUser(User user) {

        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<UserAddress> getAllAddressByUserId(int id) {
        return userAddressRepository.findByUser_id(id);
    }

    @Override
    public void addNewAddress(UserAddress userAddress) {
        userAddressRepository.save(userAddress);
    }

    @Override
    public Optional<UserAddress> getDefaultAddressByUserId(int id) {
        return userAddressRepository.findByUser_idAndIsDefault(id,true);
    }

    @Override
    public Optional<UserAddress> getAddressById(int id) {
        return userAddressRepository.findById(id);
    }
}
