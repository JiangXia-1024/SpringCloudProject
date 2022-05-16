package com.jiangxia.entity;

import java.io.Serializable;

/**
 * @author jiangxia
 * @date 2022年05月06日 16:13
 * desc:user 实体类
 */
public class User implements Serializable {
    private Integer id;
    private String email;
    private String password;
    private String username;

    public User() {
    }

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
