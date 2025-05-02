package com.example.pojo.entity;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer orderId;
    private String userId; // ✅ 改為 String
    private Date orderDate;
    private Double totalAmount;
    private String status;
    private List<OrderDetail> details;

    public Integer getId() {
        return orderId;
    }

    public void setId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }
}

/*
 * package com.example.pojo.entity;
 * 
 * import java.util.Date; import java.util.List;
 * 
 * public class Order { private Integer orderId; private Integer userId; private
 * Date orderDate; private Double totalAmount; private String status; private
 * List<OrderDetail> details;
 * 
 * // ✅ 統一命名：主鍵方法為 getId / setId public Integer getId() { return orderId; }
 * 
 * public void setId(Integer orderId) { this.orderId = orderId; }
 * 
 * public Integer getUserId() { return userId; }
 * 
 * public void setUserId(Integer userId) { this.userId = userId; }
 * 
 * public Date getOrderDate() { return orderDate; }
 * 
 * public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
 * 
 * public Double getTotalAmount() { return totalAmount; }
 * 
 * public void setTotalAmount(Double totalAmount) { this.totalAmount =
 * totalAmount; }
 * 
 * public String getStatus() { return status; }
 * 
 * public void setStatus(String status) { this.status = status; }
 * 
 * public List<OrderDetail> getDetails() { return details; }
 * 
 * public void setDetails(List<OrderDetail> details) { this.details = details; }
 * }
 */