package com.example.action;

import com.example.constant.ConstantName;
import com.example.pojo.entity.User;
import com.example.service.CartService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CartClearAction extends ActionSupport implements SessionAware {

    @Autowired
    private CartService cartService;

    private Map<String, Object> session;

    @Override
    public String execute() {
        // 取得 session 中登入使用者
        User user = (User) session.get(ConstantName.SESSION_USER);
        if (user != null) {
            cartService.clearCart(user.getId()); // ✅ 呼叫清空邏輯
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
