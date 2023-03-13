package vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.models.User;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    @Query("select u from User u join fetch u.roles where u.email=:email")
    User findUserHasVoucher(@Param("email") String email);
    Optional<User> findUserById(int id);
    Boolean existsByEmail(String email);

}
