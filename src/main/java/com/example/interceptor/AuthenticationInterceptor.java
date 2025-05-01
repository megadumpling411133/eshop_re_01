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
        // ✅ 使用字串 userId 判斷登入狀態
        String userId = getLoggedInUserId();

        if (userId != null && !userId.isEmpty()) {
            // 已登入，繼續執行
            return invocation.invoke();
        }

        // 未登入，跳轉至登入頁面
        return "login";
    }

    /**
     * 從 Session 中取得目前登入的使用者 ID（字串）。
     * 
     * @return 若使用者已登入，返回 userId 字串，否則返回 null
     */
    private String getLoggedInUserId() {
        ActionContext ctx = ActionContext.getContext();
        Map<String, ?> session = ctx.getSession();

        Object value = session.get(ConstantName.SESSION_USER);
        if (value instanceof String) {
            return (String) value;
        }
        return null;
    }
}
