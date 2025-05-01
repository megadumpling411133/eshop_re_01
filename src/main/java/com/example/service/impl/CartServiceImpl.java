package com.example.service.impl;

import com.example.dao.CartDao;
import com.example.pojo.entity.Cart;
import com.example.pojo.entity.CartDetail;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    // ✅ 加入購物車（資料庫）
    @Override
    public void addProductToCart(String userId, long productId, BigDecimal unitPrice) {
        Cart cart = cartDao.getCartByUserId(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
            cart.setCreateTime(new Date());
            cartDao.saveCart(cart);
        }

        CartDetail detail = cartDao.getCartDetail(cart.getId(), productId);
        if (detail != null) {
            detail.setQuantity(detail.getQuantity() + 1);
            cartDao.updateCartDetail(detail);
        } else {
            CartDetail newDetail = new CartDetail();
            newDetail.setCart(cart);
            newDetail.setProductId(productId);
            newDetail.setQuantity(1);
            newDetail.setUnitPrice(unitPrice.doubleValue());
            cartDao.saveCartDetail(newDetail);
        }
    }

    // ✅ 查詢購物車與明細（顯示用）
    @Override
    public Cart getCartWithDetails(String userId) {
        return cartDao.getCartByUserId(userId);
    }
}
