package com.example.interceptor;

import java.util.Map;

import com.example.constant.ConstantName;
import com.example.pojo.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 驗證攔截器，用來檢查使用者是否已登入。
 * 若使用者已登入，則允許繼續執行後續的 Action，否則跳轉至登入頁面。
 */
public class AuthenticationInterceptor implements Interceptor {

    private static final long serialVersionUID = 1L;

    /**
     * 初始化方法，這裡無需額外處理。
     */
    @Override
    public void init() {
        // 可以在這裡初始化相關的資源，如果需要的話。
    }

    /**
     * 銷毀方法，這裡無需額外處理。
     */
    @Override
    public void destroy() {
        // 可以在這裡釋放相關資源，如果需要的話。
    }

    /**
     * 攔截請求並判斷使用者是否登入。
     * 若已登入，繼續執行後續的 Action，若未登入則返回 "login" 導向登入頁面。
     * 
     * @param invocation 包含當前 Action 的調用資訊
     * @return 若已登入則執行後續 Action，若未登入則返回 "login"
     * @throws Exception 若發生例外，則會向上拋出
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // 檢查使用者是否登入，若已登入，則繼續執行後續 Action，若未登入，則返回登入頁面
        User user = getLoggedInUser();
        
        if (user != null && user.getLoginId() != null && !user.getLoginId().isEmpty()) {
            // 已登入，繼續執行
            return invocation.invoke();
        }
        
        // 未登入，跳轉至登入頁面
        return "login";
    }

    /**
     * 從 Session 中取得目前登入的使用者。
     * 
     * @return 若使用者已登入，返回 User 物件，若未登入則返回 null
     */
    private User getLoggedInUser() {
        // 取得當前 ActionContext 和 Session
        ActionContext ctx = ActionContext.getContext();
        Map<String, ?> session = ctx.getSession();
        
        // 從 Session 中取得使用者物件
        return (User) session.get(ConstantName.SESSION_USER);
    }
}
