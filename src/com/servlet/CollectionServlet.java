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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CollectionServlet")
public class CollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("user_id");
        String vehicleId = Database.getReferenceId(userId);
        System.out.println("StationServlet" + userId + "请求收藏电站数据，参考车辆id:" + vehicleId);
        List<Station> stationList = new ArrayList<>();
        Database.loadCollection(userId, stationList);

        Vehicle vehicle = Database.findVehicle(vehicleId); // 默认取用户的第一辆车来计算距离
        for (Station station : stationList) {
            station.setDistance(StationServlet.getDistance(vehicle, station)); // 计算车辆与电站的距离
            station.setQueueTime(Database.getAppointmentCount(Integer.toString(station.getId())) * 2); // 排队时间
        }

        String jsonData = new Gson().toJson(stationList);
        out.println(jsonData);
        System.out.println("StationServlet" + userId + "请求收藏电站数据响应完成");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
