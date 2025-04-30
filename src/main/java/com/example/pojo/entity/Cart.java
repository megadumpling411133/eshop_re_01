package com.example.pojo.entity;

import java.util.Date;
import java.util.Set;

public class Cart {
    private Integer cartId;
    private String userId; // ✅ 改為 String
    private Date createTime;
    private Set<CartDetail> details;

    // ✅ 統一命名：主鍵方法為 getId / setId
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
