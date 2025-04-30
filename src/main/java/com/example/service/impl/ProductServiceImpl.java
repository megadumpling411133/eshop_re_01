package com.example.service.impl;

import com.example.dao.ProductDao;
import com.example.pojo.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // 確保類級別有@Transactional註解
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts(int page, int pageSize) {
        return productDao.findAllProducts(page, pageSize);
    }

    @Override
    public int getTotalPages(int pageSize) {
        int total = productDao.getTotalProducts();
        return (int) Math.ceil((double) total / pageSize);
    }
    
    @Override
    public Product getProductById(Integer id) {
        return productDao.getProductById(id);
    }
}