package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;


import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.models.Product;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.ProductRequest;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ProductService {
    public List<Product> getAllProductWoman(int page, int numberOfProduct,String gender, int sort);
    public List<Product> getAllProductWomanByCategory(int page, int numberOfProduct, String gender, int categoryId);;
    public Product getProductById(int id);
    public int countNumberOfProduct(String gender,int categoryId);
    public void addProduct(ProductRequest productRequest);
    public List<Product> searchProduct(int page,int numOfProduct,String search);
    public List<Product> filterProduct(String gender, int categoryId,int page, int numOfProduct,int sort, int min, int max);
    public void deleteProduct(int id);

    public List<Product> getAllProduct();
}
