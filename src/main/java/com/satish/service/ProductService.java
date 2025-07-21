package com.satish.service;

import java.util.List;

import com.satish.response.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.satish.entity.Product;
import com.satish.repository.ProductRepository;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> getAllProductsWithoutPagination(){
        return productRepository.findAll();
    }

    public ProductResponse getProductsWithPagination(int pageNo, int pageSize, String sortBy, String sortDir){
        log.info("INFO - pageNo: {}, pageSize: {}, sortBy: {}, sortDir: {}", pageNo, pageSize, sortBy, sortDir);
        log.error("ERROR - pageNo: {}, pageSize: {}, sortBy: {}, sortDir: {}", pageNo, pageSize, sortBy, sortDir);
        log.warn("WARN - pageNo: {}, pageSize: {}, sortBy: {}, sortDir: {}", pageNo, pageSize, sortBy, sortDir);
        log.debug("DEBUG -pageNo: {}, pageSize: {}, sortBy: {}, sortDir: {}", pageNo, pageSize, sortBy, sortDir);
//        Sort sort = sortDir.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending() :
//                Sort.by(sortBy).descending();
        Sort sort = Sort.by(Sort.Order.asc("price"), Sort.Order.desc("category"));

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> page = productRepository.findAll(pageable);

        ProductResponse productResponse = new ProductResponse();
        productResponse.setProducts(page.getContent());
        productResponse.setPageNo(page.getNumber());
        productResponse.setPagesize(page.getSize());
        productResponse.setTotalElements(page.getTotalElements());
        productResponse.setTotalPage(page.getTotalPages());
        productResponse.setLast(page.isLast());
        productResponse.setFirst(page.isFirst());
        productResponse.setNextPage(page.getNumber() + 1L);
        productResponse.setPreviousPage(page.getNumber() - 1L);
        productResponse.setSorted(page.getSort().isSorted());
        productResponse.setSortBy(page.getSort().toString());
        return productResponse;
    }
}
