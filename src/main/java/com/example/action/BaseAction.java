package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * BaseAction 是所有 Struts2 Action 類別的基底類別，提供基本的 HttpServletRequest 和 HttpSession 訪問方法。
 * 子類別可以繼承此類別來簡化其實作，並方便地存取請求與 session 資料。
 */
public class BaseAction extends ActionSupport implements ModelDriven<Object> {

    private static final long serialVersionUID = 1L;

    // 儲存 HttpServletRequest 和 HttpSession 的引用，避免多次從 ServletActionContext 獲取
    private HttpServletRequest request;
    private HttpSession session;

    /**
     * 實作 ModelDriven 介面的 getModel 方法，這裡返回 null，表示不使用模型驅動
     * @return null
     */
    @Override
    public Object getModel() {
        return null;
    }

    /**
     * 獲取 HttpServletRequest 物件，若未初始化則從 ServletActionContext 取得
     * @return HttpServletRequest 物件
     */
    public HttpServletRequest getRequest() {
        if (request == null) {
            request = ServletActionContext.getRequest();
        }
        return request;
    }

    /**
     * 獲取 HttpSession 物件，若未初始化則從 ServletActionContext 取得
     * @return HttpSession 物件
     */
    public HttpSession getSession() {
        if (session == null) {
            session = getRequest().getSession();
        }
        return session;
    }

}
