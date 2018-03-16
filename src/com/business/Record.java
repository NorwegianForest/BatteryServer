package com.business;

import org.omg.PortableInterceptor.INACTIVE;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 换电记录
 * 与数据库中的record数据表对应
 * 注释带星号*的表示在数据库中有对应字段
 */
public class Record {
    private int id; // 数据库自增id *
    private int userId; // 执行换电的用户id *
    private int vehicleId; // 被换电的车辆id *
    private int stationId; // 提供换电的电站id *
    private double money; // 费用 *
    private int oldBatteryId; // 旧电池id *
    private int newBatteryId; // 新电池id *
    private String date; // 完成时间 *

    public Record(int id, int userId, int stationId, double money, int oldBatteryId, int newBatteryId, String date) {
        this.id = id;
        this.userId = userId;
        this.stationId = stationId;
        this.money = money;
        this.oldBatteryId = oldBatteryId;
        this.newBatteryId = newBatteryId;
        this.date = date;
    }

    public Record(int id, int userId, int vehicleId, int stationId, double money, int oldBatteryId, int newBatteryId, String date) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.stationId = stationId;
        this.money = money;
        this.oldBatteryId = oldBatteryId;
        this.newBatteryId = newBatteryId;
        this.date = date;
    }

    public String getUserPhone() {
        return Database.findUser(Integer.toString(userId)).getPhone();
    }

    public String getVehicleNumber() {
        return Database.findVehicle(Integer.toString(vehicleId)).getNumber();
    }

    public String getVehiclePlate() {
        return Database.findVehicle(Integer.toString(vehicleId)).getPlate();
    }

    public String getStationName() {
        return Database.findStation(Integer.toString(stationId)).getName();
    }

    public String getOldBatteryNumber() {
        return Database.findBattery(Database.ID, Integer.toString(oldBatteryId)).getNumber();
    }

    public String getNewBatteryNumber() {
        return Database.findBattery(Database.ID, Integer.toString(newBatteryId)).getNumber();
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}
