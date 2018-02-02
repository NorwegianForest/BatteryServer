package com.business;

import java.sql.Timestamp;

public class Vehicle {
    private int id;
    private String number;
    private String brand;
    private String model;
    private String plate;
    private int userId;
    private double longitude;
    private double latitude;
    private Timestamp date;

    public Vehicle(int id, String number, String brand, String model, String plate, int userId, double longitude, double latitude) {
        this.id = id;
        this.number = number;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.userId = userId;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
