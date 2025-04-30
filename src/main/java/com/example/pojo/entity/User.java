package com.example.pojo.entity;

import java.util.Date;

/**
 * 使用者實體類別，用來封裝使用者資料。
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

    // 統一命名：主鍵欄位為 id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
