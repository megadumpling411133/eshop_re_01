package com.example.pojo.entity;

import java.util.Date;

/**
 * 使用者實體類別，用來封裝使用者資料。
 * 若透過 JPA 注解方式來配置，則無需再額外配置 hbm.xml 文件。
 */
public class User {

    // 使用者的唯一識別碼
    private String id;

    // 使用者名稱
    private String name;

    // 使用者登入帳號
    private String loginId;

    // 使用者密碼
    private String password;

    // 使用者電話號碼
    private String tel;

    // 使用者註冊日期
    private Date createDate;

    // 取得使用者的 ID
    public String getId() {
        return id;
    }

    // 設定使用者的 ID
    public void setId(String id) {
        this.id = id;
    }

    // 取得使用者名稱
    public String getName() {
        return name;
    }

    // 設定使用者名稱
    public void setName(String name) {
        this.name = name;
    }

    // 取得使用者的登入帳號
    public String getLoginId() {
        return loginId;
    }

    // 設定使用者的登入帳號
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    // 取得使用者的密碼
    public String getPassword() {
        return password;
    }

    // 設定使用者的密碼
    public void setPassword(String password) {
        this.password = password;
    }

    // 取得使用者的電話號碼
    public String getTel() {
        return tel;
    }

    // 設定使用者的電話號碼
    public void setTel(String tel) {
        this.tel = tel;
    }

    // 取得使用者的註冊日期
    public Date getCreateDate() {
        return createDate;
    }

    // 設定使用者的註冊日期
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
}
