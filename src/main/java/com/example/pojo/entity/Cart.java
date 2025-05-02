package com.example.pojo.entity;

import java.util.Date;
import java.util.Set;

/**
 * Cart 實體類：對應購物車主表，含 userId 與明細集。
 * 注意：本類未使用任何註解，完全配合 Hibernate XML 映射檔（Cart.hbm.xml）
 */
public class Cart {

    private Integer cartId;          // 主鍵：cart_id
    private String userId;           // 使用者 ID（對應 user.id）
    private Date createTime;         // 建立時間
    private Set<CartDetail> details; // 購物車明細（1 對 多）

    // ✅ 主鍵方法：Hibernate 會使用 getId()/setId()
    public Integer getId() {
        return cartId;
    }

    public void setId(Integer cartId) {
        this.cartId = cartId;
    }

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
