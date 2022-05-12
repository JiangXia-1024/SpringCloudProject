package com.jiangxia.demo_restful.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author jiangxia
 * @since 2022-05-11 10:53:47
 */
public class User implements Serializable {
    private static final long serialVersionUID = -42340482799303572L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String username;


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

