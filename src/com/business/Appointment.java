package com.business;

/**
 * 预约信息
 * 与数据库中的appointment数据表对应
 * 注释带星号*的表示在数据库中有对应字段
 */
public class Appointment {
    private int id; // 数据库自增id *
    private int userId; // 预约用户id *
    private int vehicleId; // 将要被换电的车辆id *
    private int stationId; // 预约电站id *
    private int newBatteryId; // 新电池id *
    private int time; // 排队需要的时间 *
    private String date; // 预约时间 *
    private int complete; // 是否完成状态 *
    private Double distance; // 预约的电站与车辆的距离

    public Appointment() {
    }

    public Appointment(int id, int userId, int vehicleId, int stationId, int newBatteryId, int time, String date, int complete) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.stationId = stationId;
        this.newBatteryId = newBatteryId;
        this.time = time;
        this.date = date;
        this.complete = complete;
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

    public String getNewBatteryNumber() {
        return Database.findBattery(Database.ID, Integer.toString(newBatteryId)).getNumber();
    }

    public String getStrComplete() {
        switch (complete) {
            case 1: return "已完成";
            case 0: return "未完成";
            case -1: return "已取消";
            default: return "Unknow";
        }
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

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
