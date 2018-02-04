package com.servlet;

import com.business.AppointmentJson;
import com.business.Database;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "HandleAppointmentServlet")
public class HandleAppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("user_id");
        String vehicleId = request.getParameter("vehicle_id");
        String stationId = request.getParameter("station_id");
        System.out.println("HandleAppointmentServlet:" + userId + "的" + vehicleId + "请求预约" + stationId);

        if (!Database.hasAppointment(Database.USERID, userId) && !Database.hasAppointment(Database.VEHICLEID, vehicleId)) {
            AppointmentJson a = new AppointmentJson();
            a.setBatteryId(Database.matchBattery(stationId));
            if (a.getBatteryId() == -1) {
                out.print("预约失败");
                System.out.println("HandleAppointmentServlet:" + userId + "的" + vehicleId + "请求预约" + stationId + "失败");
            } else {
                double queueTime = 10.0; // 排队时间，单位min
                long currentTime = System.currentTimeMillis();
                long appointmentTime = (long) (currentTime + queueTime * 60 * 1000);
                Date currentDate = new Date(currentTime); // 当前时间
                Date appointmentDate = new Date(appointmentTime); // 预计可以获得电池的时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                a.setDate(sdf.format(appointmentDate));
                // 插入预约数据到数据库
                Database.insertAppointment(userId, vehicleId, stationId, Integer.toString(a.getBatteryId()),
                        sdf.format(currentDate));

                String jsonData = new Gson().toJson(a);
                out.println(jsonData);
                System.out.println("HandleAppointmentServlet:" + userId + "的" + vehicleId + "请求预约" + stationId + "成功");
            }
        } else {
            out.print("预约失败");
            System.out.println("HandleAppointmentServlet:" + userId + "的" + vehicleId + "请求预约" + stationId + "失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
