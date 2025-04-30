package com.example.dao;

import com.example.pojo.entity.User;

public interface UserDao {
    
    /**
     * 根據使用者的帳號和密碼，查詢使用者資料。
     * 
     * @param user 包含使用者登入資訊的物件，通常是帳號與密碼
     * @return 如果找到匹配的使用者資料，則回傳 User 物件；否則回傳 null
     */
    public User getLoginUser(User user);

    /**
     * 新增一個使用者資料到資料庫。
     * 
     * @param user 要新增的 User 物件，包含使用者的所有資料
     * @return 無回傳值，成功則資料會被儲存至資料庫
     */
    public void addUser(User user);
}
