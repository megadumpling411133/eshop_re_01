package com.example.dao;

import com.example.pojo.entity.Cart;
import com.example.pojo.entity.CartDetail;

public interface CartDao {
	Cart getCartByUserId(String userId);

    void saveCart(Cart cart);
    void saveCartDetail(CartDetail detail);
    CartDetail getCartDetail(Integer cartId, long productId);
    void updateCartDetail(CartDetail detail);
}
