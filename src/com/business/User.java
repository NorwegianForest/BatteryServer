package com.business;

import javax.xml.crypto.Data;

/**
 * 对应数据库中user表
 */

public class User {
    private int id;
    private String phone;
    private String password;
    private double balance;

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    /**
     * 检查数据库中是否有此账户
     * @return 有则返回true，无则返回false
     */
    public boolean check() {
        return Database.checkUser(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
