package com.example.service;

import com.example.pojo.entity.Cart;

import java.math.BigDecimal;

public interface CartService {

    /**
     * 加入商品到購物車。若購物車不存在會建立，若明細已存在則數量加一。
     *
     * @param userId 使用者 ID（String 型別）
     * @param productId 商品 ID
     * @param unitPrice 當下商品價格（BigDecimal）
     */
    void addProductToCart(String userId, long productId, BigDecimal unitPrice);

    /**
     * 取得目前使用者的購物車資料（包含所有明細）
     *
     * @param userId 使用者 ID（String 型別）
     * @return 對應 Cart 實體，包含 Set<CartDetail>
     */
    Cart getCartWithDetails(String userId);
}
