package com.example.pojo.entity;

public class CartDetail {
    private Integer detailId;
    private Cart cart;
    private long productId;
    private Integer quantity;
    private Double unitPrice;

    // ✅ 統一命名：主鍵方法為 getId / setId
    public Integer getId() {
        return detailId;
    }

    public void setId(Integer detailId) {
        this.detailId = detailId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

//    public Integer getProductId() {
//        return (int) productId;
//    }
//
//    public void setProductId(long productId) {
//        this.productId = (int) productId;
//    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
    
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
