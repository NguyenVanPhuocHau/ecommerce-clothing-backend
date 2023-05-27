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

//    @GetMapping("/arrsizes")
//    ResponseEntity<?> getAllProductInArr( @RequestParam(value = "arrSize", required = false) int[] arrSize,
//                                          @RequestParam(value = "arrColor", required = false) int[] arrColor,
//                                          @RequestParam(value = "priceRan", required = false) int[] priceRan) {
//        return ResponseEntity.ok().body(productService.getProductInArrSizeAndInArrColorAndBetweenPrice(arrSize,arrColor,priceRan[0],priceRan[1]));
//    }

    @GetMapping("/page")
    Page<Product> getProductPage(@RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "limit", defaultValue = "4") int limit,
                                 @RequestParam(value = "arrSize", required = false) int[] arrSize,
                                 @RequestParam(value = "arrColor", required = false) int[] arrColor,
                                 @RequestParam(value = "priceRange", required = false) double[] priceRange,
                                 @RequestParam(value = "sortBy", required = false) String sortBy,
                                 @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir) {
//        if(arrSize.length == 0 && arrColor.length == 0) return  productService.getProductInArrSizeAndInArrColorAndBetweenPrice(arrSize,arrColor,priceRange)
        System.out.println(sortBy);
        System.out.println(sortDir);
        System.out.println(priceRange[0] + " " + priceRange[1]);
        return productService.getProductPage(page,limit,arrSize,arrColor,priceRange,sortBy,sortDir);
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
