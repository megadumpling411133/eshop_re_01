package com.example.service.impl;

import com.example.dao.OrderDao;
import com.example.pojo.entity.*;
import com.example.service.CartService;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartService cartService;

    @Override
    public void createOrder(Order order) {
        System.out.println("【DEBUG】createOrder 呼叫：orderId = " + order.getId());
        orderDao.saveOrder(order); // cascade 自動存 detail
    }

    @Override
    public void checkout(String userId) {
        System.out.println("【DEBUG】checkout 開始，userId = " + userId);

        // ✅ 1. 查詢購物車
        Cart cart = cartService.getCartWithDetails(userId);
        if (cart == null || cart.getDetails() == null || cart.getDetails().isEmpty()) {
            System.out.println("【DEBUG】購物車為空");
            throw new RuntimeException("購物車為空，無法結帳");
        }

        // ✅ 2. 建立 Order 物件
        Order order = new Order();
        order.setUserId(userId); // ✅ 正確：userId 本來就是 String
        order.setOrderDate(new Date());
        order.setStatus("處理中");

        // ✅ 3. 轉換 CartDetail 為 OrderDetail
        double total = 0.0;
		/* List<OrderDetail> orderDetails = new ArrayList<>(); */
        Set<OrderDetail> orderDetails = new HashSet<>();

        for (CartDetail item : cart.getDetails()) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order); // 建立關聯
            detail.setProductId((int) item.getProductId()); // 注意轉型
            detail.setQuantity(item.getQuantity());
            detail.setUnitPrice(item.getUnitPrice());

            total += item.getQuantity() * item.getUnitPrice();
            orderDetails.add(detail);
        }

        // ✅ 4. 設定總金額與明細
        System.out.println("【DEBUG】訂單明細數量: " + orderDetails.size());
        order.setTotalAmount(total);
        order.setDetails(orderDetails);

        // ✅ 5. 儲存 Order（cascade 儲存明細）
        orderDao.saveOrder(order);
        System.out.println("【DEBUG】即將儲存訂單...");

        // ✅ 6. 清空購物車
        cartService.clearCart(userId);
        System.out.println("【DEBUG】購物車已清空");
    }
}
