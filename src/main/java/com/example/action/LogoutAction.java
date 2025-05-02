package com.example.action;

import com.example.constant.ConstantName;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LogoutAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    @Override
    public String execute() {
        // ✅ 清除登入資訊
        session.remove(ConstantName.SESSION_USER);
        session.clear(); // 可選：清除所有 session 資料

        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
