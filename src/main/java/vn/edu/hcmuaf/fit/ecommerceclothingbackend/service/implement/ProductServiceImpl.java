package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.Product;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.exception.ServerError;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.ProductRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.ProductRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.ProductService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProductWoman(int page, int numberOfProduct, String gender, int sort) {
        return null;
    }

    @Override
    public List<Product> getAllProductWomanByCategory(int page, int numberOfProduct, String gender, int categoryId) {
        return null;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public int countNumberOfProduct(String gender, int categoryId) {
        return 0;
    }

    @Override
    public void addProduct(ProductRequest productRequest) {

    }

    @Override
    public List<Product> searchProduct(int page, int numOfProduct, String search) {
        return null;
    }

    @Override
    public List<Product> filterProduct(String gender, int categoryId, int page, int numOfProduct, int sort, int min, int max) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getProductPage(int page, int limit, int[] arrSize, int[] arrColor, double[] priceRange, String sortBy,String sortDir) {
        try {
            Pageable pagination;
            if (!sortBy.equals("")){
                Sort.Direction direction = Sort.Direction.fromString(sortDir);
                 pagination = PageRequest.of(page, limit, direction,sortBy);
            }
            else {
                 pagination = PageRequest.of(page, limit);
            }
//            Page<Product> productPage;
            if(arrSize.length == 0 && arrColor.length == 0) return  productRepository.findByPriceBetween(priceRange[0],priceRange[1],pagination);
            if(arrColor.length == 0) return  productRepository.findByProductSizes_IdInAndPriceBetween(arrSize,priceRange[0],priceRange[1],pagination);
            if(arrSize.length == 0) return  productRepository.findByProductColors_IdInAndPriceBetween(arrColor,priceRange[0],priceRange[1],pagination);
//            productPage = productRepository.findAll(pagination);


            return productRepository.findByProductSizes_IdInAndProductColors_IdInAndPriceBetween(arrSize,arrColor,priceRange[0],priceRange[1],pagination);
        } catch (Exception e) {
            throw new ServerError(e.getMessage());
        }
//        return null;
    }

//    @Override
//    public List<Product> getProductInArrSizeAndInArrColorAndBetweenPrice(int[] arr,int[] arr1, double min, double max) {
//        return productRepository.findByProductSizes_IdInAndProductColors_IdInAndPriceBetween(arr,arr1,min,max);
//    }
//
//    @Override
//    public List<Product> getProductInArrSizeAndBetweenPrice(int[] arr, double min, double max) {
//        return productRepository.findByProductSizes_IdInAndPriceBetween(arr,min,max);
//    }
//
//    @Override
//    public List<Product> getProductInArrColorAndBetweenPrice(int[] arr, double min, double max) {
//        return productRepository.findProductColors_IdInAndPriceBetween(arr, min, max);
//    }
}
