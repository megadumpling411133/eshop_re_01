package com.example.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.pojo.entity.User;

/**
 * UserDao 實作類別，負責實作 UserDao 介面中的方法。
 * 這裡使用 Hibernate 來查詢使用者資料，並進行操作。
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory; // 注入 SessionFactory 用於 Hibernate 操作

    /**
     * 根據使用者的登入資訊查詢使用者資料。
     * 使用 Hibernate 進行查詢並返回結果。
     * 
     * @param user 包含使用者帳號和密碼的 User 物件
     * @return 如果查詢到資料，回傳對應的 User 物件；若無則回傳 null
     */
    @Override
    public User getLoginUser(User user) {
        // 使用 Hibernate 查詢
        return getUserByHibernate(user);
    }

    /**
     * 新增一個使用者資料。
     * 
     * @param user 要新增的 User 物件，包含使用者的所有資料
     */
    @Override
    public void addUser(User user) {
        // 使用 Hibernate 保存 User 物件
        getSession().save(user);
    }

    /**
     * 使用 Hibernate 查詢資料庫，根據使用者的帳號和密碼來查詢使用者資料。
     * 
     * @param user 包含使用者登入資訊的物件，通常是帳號與密碼
     * @return 如果找到匹配的使用者資料，則回傳 User 物件；否則回傳 null
     */
    private User getUserByHibernate(User user) {
        // 定義 HQL 查詢語句
        String hql = "from User where loginId = :loginId and password = :password";
        // 使用 Hibernate 的 Query 物件來執行 HQL 查詢
        Query<User> query = getSession().createQuery(hql, User.class);
        query.setParameter("loginId", user.getLoginId());
        query.setParameter("password", user.getPassword());
        List<User> userList = query.list();

        // 若查詢結果不為空，返回第一筆資料
        return userList.isEmpty() ? null : userList.get(0);
    }

    /**
     * 獲取當前 Hibernate 的 Session 物件。
     * 
     * @return 當前的 Hibernate Session 物件
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
