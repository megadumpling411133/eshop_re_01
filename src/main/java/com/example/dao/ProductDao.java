package com.example.dao;

import com.example.pojo.entity.Product;
import java.util.List;

public interface ProductDao {
    List<Product> findAllProducts(int page, int pageSize);
    int getTotalProducts();
}