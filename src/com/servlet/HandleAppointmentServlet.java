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
        String vehicleId = Database.getReferenceId(userId);
        String batteryModel = Database.findBattery(Database.VEHICLE_ID, vehicleId).getModel();
        String stationId = request.getParameter("station_id");
        System.out.println("HandleAppointmentServlet:" + userId + "的" + vehicleId + "请求预约" + stationId);

        if (!Database.hasAppointment(Database.USER_ID, userId) && !Database.hasAppointment(Database.VEHICLE_ID, vehicleId)) {
            AppointmentJson a = new AppointmentJson();
            a.setBatteryId(Database.matchBattery(stationId, batteryModel));
            if (a.getBatteryId() == -1) {
                out.print("预约失败");
                System.out.println("HandleAppointmentServlet:" + userId + "的" + vehicleId + "请求预约" + stationId + "失败，无合适电池");
            } else {
                int time = Database.getAppointmentCount(Integer.toString(Database.findStation(stationId).getId())) * 2;
                long currentTime = System.currentTimeMillis();
                Date currentDate = new Date(currentTime); // 当前时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                a.setDate(sdf.format(currentDate));
                // 插入预约数据到数据库
                Database.insertAppointment(userId, vehicleId, stationId, Integer.toString(a.getBatteryId()),
                        Integer.toString(time), sdf.format(currentDate));

                a.setAppointment_id(Database.findAppointment(Database.USER_ID, userId).getId());

                String jsonData = new Gson().toJson(a);
                out.print(jsonData);
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
