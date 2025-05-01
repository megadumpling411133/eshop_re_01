package com.example.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.constant.ConstantName;
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
    private String prodId;

    // ✅ 改為 Map 才能被 json result 正確解析
    private Map<String, Object> jsonResult = new HashMap<>();

    public Map<String, Object> getJsonResult() {
        return jsonResult;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    // ✅ AJAX 專用方法
    public String addToCart() {
    	long prodIdConvert = Long.parseLong(prodId);
        String loginId = session.get(ConstantName.SESSION_USER)==null?null:(String)session.get(ConstantName.SESSION_USER);
        if (prodId == null || loginId == null) {
            jsonResult.put("success", "加入購物車成功");
            jsonResult.put("message", "未登入或商品ID無效");
            return "json";
        }

        Product product = productService.getProductById(prodIdConvert);
        if (product == null) {
            jsonResult.put("success", false);
            jsonResult.put("message", "找不到商品");
            return "json";
        }

        cartService.addProductToCart(loginId, prodIdConvert, product.getPrice());
        jsonResult.put("success", true);
        jsonResult.put("message", "成功加入購物車");
        
        System.out.println("【DEBUG】prodId = " + prodId);
        System.out.println("【DEBUG】user = " + session.get("user"));
        
        return "json";
    }
}
