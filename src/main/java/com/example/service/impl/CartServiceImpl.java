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

    // ✅ 加入商品到購物車
    @Override
    public void addProductToCart(String userId, long productId, BigDecimal unitPrice) {
        Cart cart = cartDao.getCartByUserId(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId); // 這裡 userId 為 user.id
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

    // ✅ 查詢購物車（含明細）
    @Override
    public Cart getCartWithDetails(String userId) {
        return getCartByUserId(userId);
    }

    // ✅ DAO 採用 fetch join 查詢
    @Override
    public Cart getCartByUserId(String userId) {
        return cartDao.getCartByUserId(userId);
    }

    // ✅ 僅刪除主表，讓 Hibernate cascade 刪除明細
    @Override
    public void clearCart(String userId) {
        Cart cart = cartDao.getCartByUserId(userId);
        if (cart != null) {
            cartDao.deleteCart(cart); // ❗這行會自動 cascade 刪除明細
        }
    }
}
