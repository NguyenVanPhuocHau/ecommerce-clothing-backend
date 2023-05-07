package vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.User;

import java.util.List;
import java.util.Optional;

//@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByEmail(String email);


    Optional<User> findByEmail(String email);


//    @Query("select u from User u join fetch u.roles where u.email=:email")
//    User findUserHasVoucher(@Param("email") String email);

    @Override
    Optional<User> findById(Integer integer);

    @Override
    List<User> findAll();

    Boolean existsByEmail(String email);

    User findByUsername(String username);


}
