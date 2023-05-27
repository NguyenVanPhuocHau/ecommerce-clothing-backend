package vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductName(String productName);



    @Override
    Optional<Product> findById(Integer integer);

    @Override
    List<Product> findAllById(Iterable<Integer> integers);

    @Override
    List<Product> findAll();

    Page<Product> findByProductSizes_IdInAndProductColors_IdInAndPriceBetween(int[] ids, int[] idc, double min, double max, Pageable pageable);
//
    Page<Product> findByProductColors_IdInAndPriceBetween(int[] idc,double min,double max,Pageable pageable);
    Page<Product> findByProductSizes_IdInAndPriceBetween(int[] ids,double min,double max,Pageable pageable);

    Page<Product> findByPriceBetween(double min,double max,Pageable pageable);


}
