package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.pojo.entity.User;
import com.example.service.UserService;

/**
 * UserService 的實作類別，處理與使用者相關的業務邏輯。
 * 這個類別實作了 UserService 介面，並使用 UserDao 來進行資料庫操作。
 * 註解：@Service 標註此類別為 Spring 的服務層 Bean。
 */
@Service
public class UserServiceImpl implements UserService {

    // 自動注入 UserDao，負責執行實際的資料庫操作
    @Autowired
    private UserDao userDao;

    /**
     * 根據使用者的登入帳號與密碼，查詢使用者是否存在。
     * 
     * @param user 包含登入帳號與密碼的 User 物件
     * @return     如果使用者存在，返回對應的 User 物件，否則返回 null
     */
    @Override
    public User getLoginUser(User user) {
        // 呼叫 UserDao 來查詢登入的使用者
        return userDao.getLoginUser(user);
    }

    /**
     * 新增一個新的使用者到資料庫中。
     * 
     * @param user 要新增的 User 物件
     */
    @Override
    public void addUser(User user) {
        // 呼叫 UserDao 來新增使用者
        userDao.addUser(user);
    }

}
