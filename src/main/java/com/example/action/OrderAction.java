package com.example.action;

import com.example.constant.ConstantName;
import com.example.pojo.entity.User;
import com.example.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class OrderAction extends ActionSupport implements SessionAware {

    @Autowired
    private OrderService orderService;

    private Map<String, Object> session;

    @Override
    public String execute() {
    	System.out.println("✅ 進入 OrderAction，session user = " + session.get(ConstantName.SESSION_USER));
        User user = (User) session.get(ConstantName.SESSION_USER);
        if (user == null) {
            addActionMessage("請先登入再結帳");
            return ERROR;
        }

        try {
            // ✅ 將結帳邏輯委派給 Service，保持 Action 簡潔
            orderService.checkout(user.getId());
            return SUCCESS;
        } catch (RuntimeException e) {
            // ✅ 捕捉 Service 層拋出的錯誤（例如購物車為空）
			/* addActionMessage(e.getMessage()); */
        	e.printStackTrace(); // 🔥 加這行：印出錯誤堆疊
            System.out.println("❌ 結帳失敗：" + e.getMessage()); // 🔥 顯示錯誤原因
            addActionMessage(e.getMessage());
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}


/*
 * package com.example.action;
 * 
 * import com.example.constant.ConstantName; import com.example.pojo.entity.*;
 * import com.example.service.CartService; import
 * com.example.service.OrderService; import
 * com.opensymphony.xwork2.ActionSupport; import
 * org.apache.struts2.interceptor.SessionAware; import
 * org.springframework.beans.factory.annotation.Autowired;
 * 
 * import java.util.*;
 * 
 * public class OrderAction extends ActionSupport implements SessionAware {
 * 
 * @Autowired private OrderService orderService;
 * 
 * @Autowired private CartService cartService;
 * 
 * private Map<String, Object> session;
 * 
 * @Override public String execute() { User user = (User)
 * session.get(ConstantName.SESSION_USER); if (user == null) return ERROR;
 * 
 * // 取得購物車資料 Cart cart = cartService.getCartWithDetails(user.getId()); if (cart
 * == null || cart.getDetails() == null || cart.getDetails().isEmpty()) {
 * addActionMessage("購物車為空，無法結帳"); return ERROR; }
 * 
 * // 建立訂單 Order order = new Order(); order.setUserId(user.getId()); // ✅
 * user.getId() 是 String order.setOrderDate(new Date());
 * 
 * double total = 0; List<OrderDetail> orderDetails = new ArrayList<>(); for
 * (CartDetail cd : cart.getDetails()) { OrderDetail od = new OrderDetail();
 * od.setProductId((int) cd.getProductId()); od.setQuantity(cd.getQuantity());
 * od.setUnitPrice(cd.getUnitPrice()); od.setOrder(order); // 設定回去，讓 Hibernate
 * 能建立關聯 total += cd.getQuantity() * cd.getUnitPrice(); orderDetails.add(od); }
 * 
 * order.setTotalAmount(total); order.setStatus("已下單");
 * order.setDetails(orderDetails);
 * 
 * // 儲存訂單與明細 orderService.createOrder(order);
 * 
 * // 清空購物車 cartService.clearCart(user.getId());
 * 
 * return SUCCESS; }
 * 
 * @Override public void setSession(Map<String, Object> session) { this.session
 * = session; } }
 */