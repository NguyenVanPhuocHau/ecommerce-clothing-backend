package vn.edu.hcmuaf.fit.ecommerceclothingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.Product;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.ProductService;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement.ColorService;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.service.implement.SizeService;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@PermitAll
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ColorService colorService;

    @Autowired
    private SizeService sizeService;

    @GetMapping("/all")
    ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/colors")
    ResponseEntity<?> getAllProductColor() {
        return ResponseEntity.ok().body(colorService.getAllProductColor());
    }
    @GetMapping("/sizes")
    ResponseEntity<?> getAllProductSize() {
        return ResponseEntity.ok().body(sizeService.getAllProductSize());
    }

    @GetMapping("/page")
    Page<Product> getProductPage(@RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "limit", defaultValue = "4") int limit,
                                 @RequestParam(value = "arrSize", required = false) String[] arrSize,
                                 @RequestParam(value = "arrColor", required = false) String[] arrColor,
                                 @RequestParam(value = "priceRange", required = false) String[] priceRange) {
        return productService.getProductPage(page,limit,arrSize,arrColor,priceRange);
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
