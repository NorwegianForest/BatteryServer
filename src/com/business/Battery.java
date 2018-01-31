package com.business;

import java.sql.Timestamp;

public class Battery {
    private int id;
    private String number;
    private String model;
    private int vehicleId;
    private int stationId;
    private double electricity;
    private double ratedCapacity;
    private double actualCapacity;
    private double residualCapacity;
    private Timestamp date;
}
