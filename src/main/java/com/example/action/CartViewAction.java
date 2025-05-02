package com.example.action;

import com.example.constant.ConstantName;
import com.example.pojo.entity.Cart;
import com.example.pojo.entity.User;
import com.example.service.CartService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CartViewAction extends ActionSupport implements SessionAware {

    @Autowired
    private CartService cartService;

    private Map<String, Object> session;
    private Cart cart;

    @Override
    public String execute() {
        // ✅ 取得完整 User 實體
        User user = (User) session.get(ConstantName.SESSION_USER);
        if (user == null) return ERROR;

        // ✅ 從 service 查詢購物車（含明細）
        cart = cartService.getCartWithDetails(user.getId());

        // ✅ DEBUG 印出
        System.out.println("CartViewAction: execute()");
        System.out.println("【DEBUG】user id: " + user.getId());
        System.out.println("【DEBUG】cart: " + cart);
        System.out.println("【DEBUG】details: " + (cart != null ? cart.getDetails() : "null"));
        System.out.println("【DEBUG】details size: " + (cart != null && cart.getDetails() != null ? cart.getDetails().size() : "null"));

        return SUCCESS;
    }

    // ✅ 給 JSP 使用的 getter
    public Cart getCart() {
        return cart;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
