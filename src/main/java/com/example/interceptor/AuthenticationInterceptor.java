package com.example.interceptor;

import java.util.Map;

import com.example.constant.ConstantName;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 驗證攔截器，用來檢查使用者是否已登入。
 * 若使用者已登入，則允許繼續執行後續的 Action，否則跳轉至登入頁面。
 */
public class AuthenticationInterceptor implements Interceptor {

    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        // 無需額外初始化
    }

    @Override
    public void destroy() {
        // 無需額外釋放
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // 從 session 中取得使用者物件
        Map<String, Object> session = ActionContext.getContext().getSession();
        Object userObj = session.get(ConstantName.SESSION_USER);

        if (userObj instanceof com.example.pojo.entity.User) {
            return invocation.invoke(); // ✅ 已登入
        }

        // ❌ 未登入
        return "login";
    }
} 
