package com.servlet;

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

@WebServlet(name = "StationToUserServlet")
public class StationToUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("user_id");
        String stationId = request.getParameter("station_id");
        System.out.println("StationToUserServlet:" + userId + "用户请求与" + stationId + "的电站的相关数据");

        Vehicle vehicle = Database.findVehicle(Database.getReferenceId(userId));
        Station station = Database.findStation(stationId);

        station.setDistance(StationServlet.getDistance(vehicle, station)); // 计算车辆与电站的距离
        station.setQueueTime(Database.getAppointmentCount(Integer.toString(station.getId())) * 2); // 排队时间
        station.setAppointment(Database.isAppointment(userId, stationId));
        station.setCollection(Database.isCollection(userId, stationId));

        String jsonData = new Gson().toJson(station);
        out.print(jsonData);
        System.out.println("StationToUserServlet:" + userId + "用户请求与" + stationId + "的电站的相关数据响应完成");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
