package com.satish.controller;

import java.util.List;

import com.satish.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.satish.entity.Product;
import com.satish.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController { // http://localhost:8080/products/without-pagination

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public List<Product> saveAllProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("without-pagination")
    public List<Product> getProductsWithoutPagination(){
        return productService.getAllProductsWithoutPagination();
    }
    @GetMapping("/with-pagination")
    public ProductResponse getProductsWithPagination(@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
                                                     @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize,
                                                     @RequestParam(name = "sortBy", required = false, defaultValue = "price") String sortBy,
                                                     @RequestParam(name = "sortDir", required = false, defaultValue = "ASC") String sortDir){
        return productService.getProductsWithPagination(pageNo, pageSize, sortBy, sortDir);
    }

}
