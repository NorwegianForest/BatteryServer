package com.business;

/**
 * 用户信息
 * 对应数据库中user表
 * 注释带星号*的表示在数据库中有对应字段
 */

public class User {
    private int id; // 数据库自增id *
    private String phone; // 用户手机号码 *
    private String password; // 用户密码 *
    private double balance; // 余额 *

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
