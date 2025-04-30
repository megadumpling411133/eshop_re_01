package com.example.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.pojo.entity.Product;
import com.example.pojo.entity.User;
import com.example.service.CartService;
import com.example.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    private Map<String, Object> session;
    private Integer prod_id;

    @Override
    public String execute() throws Exception {
        // ✅ 檢查輸入與登入狀態
        User user = (User) session.get("user");
        if (prod_id == null || user == null) {
            return ERROR;
        }

        // ✅ 取得商品資訊
        Product product = productService.getProductById(prod_id);
        if (product == null) {
            return ERROR;
        }

        // ✅ 統一使用 getId() 存入 cart / cart_detail
        cartService.addProductToCart(user.getId(), product.getId(), product.getPrice());

        return SUCCESS;
    }

    // Getter/Setter
    public Integer getProd_id() {
        return prod_id;
    }

    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
