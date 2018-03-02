package com.servlet;

import com.business.Appointment;
import com.business.Database;
import com.business.Station;
import com.business.Vehicle;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("user_id");
        System.out.println("AppointmentServlet:" + userId + "请求预约数据");
        List<Appointment> appointmentList = new ArrayList<>();
        Database.loadAppointment(userId, appointmentList);
        for (Appointment appointment : appointmentList) {
            Station station = Database.findStation(Integer.toString(appointment.getStationId()));
            Vehicle vehicle = Database.findVehicle(Integer.toString(appointment.getVehicleId()));
            appointment.setDistance(StationServlet.getDistance(vehicle, station));
        }

        String jsonData = new Gson().toJson(appointmentList);
        out.println(jsonData);
        System.out.println("AppointmentServlet:" + userId + "请求预约数据响应完成");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
