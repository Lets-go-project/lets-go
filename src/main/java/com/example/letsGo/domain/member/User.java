package com.example.letsGo.domain.member;

import java.util.Date;

public class User {
    private int userId;
    private String id;
    private String password;
    private String name;
    private String gender;
    private String email;
    private Date birth;
    private String address;
    private boolean isSalesManager;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSalesManager() {
        return isSalesManager;
    }

    public void setSalesManager(boolean salesManager) {
        isSalesManager = salesManager;
    }
}
