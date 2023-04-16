package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.models.Product;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.ProductRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService{

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
}
