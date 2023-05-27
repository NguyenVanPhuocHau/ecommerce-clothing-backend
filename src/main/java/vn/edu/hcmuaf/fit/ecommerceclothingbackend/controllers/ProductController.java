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
                                 @RequestParam(value = "arrSize", required = false) int[] arrSize,
                                 @RequestParam(value = "arrColor", required = false) int[] arrColor,
                                 @RequestParam(value = "priceRange", required = false) double[] priceRange,
                                 @RequestParam(value = "sortBy", required = false) String sortBy,
                                 @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir) {
        System.out.println(sortBy);
        System.out.println(sortDir);
        System.out.println(priceRange[0] + " " + priceRange[1]);
        return productService.getProductPage(page,limit,arrSize,arrColor,priceRange,sortBy,sortDir);
    }


}
