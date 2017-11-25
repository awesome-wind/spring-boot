package com.spring.mybatisxml.entity;

import com.spring.mybatisxml.enums.AuthorityEnum;

import java.io.Serializable;

public class User implements Serializable {

    private int id;

    private String userName;

    private AuthorityEnum authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AuthorityEnum getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityEnum authority) {
        this.authority = authority;
    }
}
