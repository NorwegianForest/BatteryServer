package com.business;

/**
 * 电站信息
 * 对应数据库中的station数据表
 * 注释带星号*的表示在数据库中有对应字段
 */
public class Station {
    private int id; // 数据库自增id *
    private String name; // 电站名称 *
    private String address; // 电站具体地址 *
    private double longitude; // 经度 *
    private double latitude; // 纬度 *
    private double distance; // 距离某辆车的距离
    private double queueTime; // 预约后所需要的排队时间
    private boolean isAppointment; // 是否已经被预约，针对于确知用户id的情况
    private boolean isCollection; // 是否已经收藏，针对于确知用户id的情况

    public Station() {
    }

    public Station(int id, String name, String address, double longitude, double latitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Station(int id, String address, double longitude, double latitude) {
        this.id = id;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(double queueTime) {
        this.queueTime = queueTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAppointment() {
        return isAppointment;
    }

    public void setAppointment(boolean appointment) {
        isAppointment = appointment;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public void setCollection(boolean collection) {
        isCollection = collection;
    }
}
