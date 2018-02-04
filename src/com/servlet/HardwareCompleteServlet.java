package com.servlet;

import com.business.Appointment;
import com.business.Constants;
import com.business.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "HardwareCompleteServlet")
public class HardwareCompleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String vehicleId = request.getParameter("vehicle_id");
        System.out.println("HardwareCompleteServlet:" + vehicleId + "表示已完成换电");

        Appointment appointment = Database.findAppointment(Database.VEHICLEID, vehicleId);
        String newBatteryId = Integer.toString(appointment.getNewBatteryId());
        String userId = Integer.toString(appointment.getUserId());
        String stationId = Integer.toString(appointment.getStationId());
        String oldBatteryId = Integer.toString(Database.findBattery(Database.VEHICLEID, vehicleId).getId());

        Database.updateBattery(oldBatteryId, "-1", stationId);
        Database.updateBattery(newBatteryId, vehicleId, "-1");
        Database.completeAppointment(vehicleId);

        long currentTime = System.currentTimeMillis();
        Date currentDate = new Date(currentTime); // 当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        double money = 50.0; // 假设费用为50
        Database.insertRecord(userId, vehicleId, stationId, money, oldBatteryId, newBatteryId, sdf.format(currentDate));

        System.out.println("HardwareCompleteServlet:" + vehicleId + "确实已完成换电");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
