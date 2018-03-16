package com.business;

/**
 * 用于在预约中返回预约结果信息
 */

public class AppointmentJson {

    private int appointment_id; // 预约记录id
    private int batteryId; // 预约后，系统为其准备的电池id
    private String date; // 预计可以提供电池的时间

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(int batteryId) {
        this.batteryId = batteryId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
