package com.business;

import java.sql.Timestamp;

/**
 * 换电记录
 * 与数据库中的record数据表对应
 * 注释带星号*的表示在数据库中有对应字段
 */
public class Record {
    private int id; // 数据库自增id *
    private int userId; // 执行换电的用户id *
    private int stationId; // 提供换电的电站id *
    private double money; // 费用 *
    private int oldBatteryId; // 旧电池id *
    private int newBatteryId; // 新电池id *
    private Timestamp date; // 完成时间 *

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getOldBatteryId() {
        return oldBatteryId;
    }

    public void setOldBatteryId(int oldBatteryId) {
        this.oldBatteryId = oldBatteryId;
    }

    public int getNewBatteryId() {
        return newBatteryId;
    }

    public void setNewBatteryId(int newBatteryId) {
        this.newBatteryId = newBatteryId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
