package com.business;

/**
 * 与数据库中的login_record数据表对应
 * 注释带星号*的表示在数据库中有对应字段
 */

public class LoginRecord {

    private int id; // 数据库自增id *
    private int userId; // 用户id *
    private String phone; // 用户手机号 *
    private int status; // 登录状态 *
    private String date; // 登录时间 *

    public LoginRecord(int id, String phone, int status, String date) {
        this.id = id;
        this.phone = phone;
        this.status = status;
        this.date = date;
    }

    public String getStrStatus() {
        if (status == 1) {
            return "登录成功";
        } else {
            return "登录失败";
        }
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
