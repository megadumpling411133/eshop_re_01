package com.example.service;

import com.example.pojo.entity.Order;

public interface OrderService {
    void createOrder(Order order);

    /**
     * 使用者結帳，會自動從購物車轉成訂單並清空購物車
     */
    void checkout(String userId);
}
