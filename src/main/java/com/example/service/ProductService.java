package com.example.service;

import com.example.pojo.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getProducts(int page, int pageSize);
    int getTotalPages(int pageSize);
    
    Product getProductById(Integer id);
}