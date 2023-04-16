package vn.edu.hcmuaf.fit.ecommerceclothingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.models.Product;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.models.ProductImage;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response.ResponseObject;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.ProductRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

//    @GetMapping("/{id}")
//    ResponseEntity<ResponseObject> findById(@PathVariable int id) {
//        Optional<Product> foundProduct = repository.findById(id);
//        return foundProduct.isPresent() ?
//                ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query product successfull", foundProduct))
//                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "Cannot find product with id = " + id, ""));
//
////        return repository.findById(id).orElseThrow(()->new RuntimeException("Cannot find product with id = " + id));
//    }

//    @PostMapping("/insertProduct")
//    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
//        List<Product> foundProducts = repository.findByProductName(newProduct.getProductName().trim());
//        if (foundProducts.size() > 0) {
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("failed", "product name already taken", ""));
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Insert Product successfully", repository.save(newProduct)));
//    }

//    @PutMapping("/{id}")
//    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
//        Product updateProduct = repository.findById(id).map(product -> {
//            product.setProductName(newProduct.getProductName());
//            ;
//            product.setPrice(newProduct.getPrice());
//            ;
//            product.setDate(newProduct.getDate());
//            product.setUrl(newProduct.getUrl());
//            return repository.save(product);
//        }).orElseGet(() -> {
//            newProduct.setId(id);
//            return repository.save(newProduct);
//        });
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Update Product successfully", updateProduct));
//    }

//    @DeleteMapping("/{id}")
//    ResponseEntity<ResponseObject> deleteProduct(@PathVariable int id){
//        boolean exists = repository.existsById(id);
//    if(!exists){
//        repository.deleteById(id);
//        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","Delete product successfully",""));
//    }
//    return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed","Cannot find product to detele",""));
//    }


}
