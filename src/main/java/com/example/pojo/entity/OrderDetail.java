package com.example.pojo.entity;

public class OrderDetail {
    private Integer detailId;
    private Order order;         // many-to-one
    private Integer productId;
    private Integer quantity;
    private Double unitPrice;

    // ✅ 統一命名：主鍵方法為 getId / setId
    public Integer getId() {
        return detailId;
    }

    public void setId(Integer detailId) {
        this.detailId = detailId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
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
