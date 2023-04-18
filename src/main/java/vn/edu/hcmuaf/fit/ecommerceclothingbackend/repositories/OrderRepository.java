package vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.UserOrder;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<UserOrder,Long> {

    @Override
    Optional<UserOrder> findById(Long aLong);

    @Override
    List<UserOrder> findAllById(Iterable<Long> longs);


}
