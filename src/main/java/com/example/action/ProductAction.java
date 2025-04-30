package com.example.action;

import com.example.pojo.entity.Product;
import com.example.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ProductAction extends ActionSupport implements SessionAware {
    
    @Autowired
    private ProductService productService;
    
    private Map<String, Object> session;
    private List<Product> products;
    private int currentPage = 1;
    private int pageSize = 10;
    private int totalPages;
    
    @Override
    public String execute() {
        products = productService.getProducts(currentPage, pageSize);
        totalPages = productService.getTotalPages(pageSize);
        return SUCCESS;
    }
    
    // Getters and Setters
    public List<Product> getProducts() {
        return products;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public int getTotalPages() {
        return totalPages;
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}

