package com.example.service;

import com.example.pojo.entity.User;

/**
 * UserService 介面，負責定義有關使用者的服務方法
 * 例如：用來獲取登入的使用者資料，新增使用者等操作
 */
public interface UserService {
    
    /**
     * 根據使用者的登入帳號和密碼，查詢並返回登入的使用者資料
     * 
     * @param user  包含使用者登入帳號與密碼的物件
     * @return      如果成功登入，返回對應的使用者資料，否則返回 null
     */
    public User getLoginUser(User user);

    /**
     * 新增一個新的使用者
     * 
     * @param user  要新增的使用者資料
     */
    public void addUser(User user);
}
