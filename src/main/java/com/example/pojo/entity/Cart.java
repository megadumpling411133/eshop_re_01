package com.example.pojo.entity;

import java.util.Date;
import java.util.Set;

/**
 * Cart 實體類：對應購物車主表，含 userId 與明細集。
 */
public class Cart {

    private Integer cartId;          // 主鍵：cart_id
    private String userId;           // 使用者 ID（關鍵：此為 User.id，型別為 String）
    private Date createTime;         // 建立時間
    private Set<CartDetail> details; // 購物車明細（1對多）

    // ✅ 統一主鍵命名：getId()/setId()（供 Hibernate 使用）
    public Integer getId() {
        return cartId;
    }

    public void setId(Integer cartId) {
        this.cartId = cartId;
    }

    // ✅ User 主鍵 id 對應此 userId 欄位（作為關聯查詢條件）
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Set<CartDetail> getDetails() {
        return details;
    }

    public void setDetails(Set<CartDetail> details) {
        this.details = details;
    }
}
