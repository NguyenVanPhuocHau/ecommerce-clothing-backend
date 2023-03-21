package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;

import vn.edu.hcmuaf.fit.ecommerceclothingbackend.models.Product;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.ProductRequest;

import java.util.List;

public class ProductServiceImpl implements  ProductService{
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
}
