package com.business;

/**
 * 汽车(即硬件设备)信息
 * 对应数据库中的vehicle数据表
 * 注释带星号*的表示在数据库中有对应字段
 */
public class Vehicle {
    private int id; // 数据库自增id *
    private String number; // 硬件设备唯一标识编号 *
    private String brand; // 汽车品牌 *
    private String model; // 汽车型号 *
    private String plate; // 车牌号码 *
    private int userId; // 管理员用户id *
    private double longitude; // 经度 *
    private double latitude; // 纬度 *
    private String date; // 硬件设备投入使用的日期 *

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
