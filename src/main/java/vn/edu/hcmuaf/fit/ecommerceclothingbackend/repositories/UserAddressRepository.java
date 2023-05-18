package vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.UserAddress;

import java.util.List;
import java.util.Optional;

public interface UserAddressRepository extends JpaRepository<UserAddress,Integer> {
    List<UserAddress> findByUser_id(int userId);
    Optional<UserAddress> findByUser_idAndIsDefault(int userId, boolean isDefault);
}
