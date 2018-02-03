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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "StationServlet")
public class StationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("id");
        System.out.println("StationServlet" + userId + "请求电站数据");

        List<Vehicle> vehicleList = new ArrayList<>();
        try {
            Database.loadVehicle(userId, vehicleList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Vehicle vehicle = vehicleList.get(0); // 默认取用户的第一辆车来计算距离
        List<Station> stationList = new ArrayList<>();
        Database.loadStation(stationList);
        for (Station station : stationList) {
            station.setDistance(getDistance(vehicle, station)); // 计算车辆与电站的距离
            station.setQueueTime(10); // 预设排队时间为10min
        }

        Collections.sort(stationList, new Comparator<Station>() { // 根据距离对车站列表进行排序
            @Override
            public int compare(Station s1, Station s2) {
                int dis = (int) (s1.getDistance() - s2.getDistance());
                return dis;
            }
        });

        String jsonData = new Gson().toJson(stationList);
        out.println(jsonData);
        System.out.println("StationServlet" + userId + "请求电站数据响应完成");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * 计算车辆和电站之间的距离
     * @param vehicle 车辆对象
     * @param station 电站对象
     * @return 距离，单位km
     */
    private double getDistance(Vehicle vehicle, Station station) {
        return getDistance(vehicle.getLatitude(), vehicle.getLongitude(), station.getLatitude()
            , station.getLongitude());
    }

    /**
     * 通过两个经纬度测算距离
     * @param lat1 甲的纬度
     * @param lng1 甲的经度
     * @param lat2 乙的纬度
     * @param lng2 乙的经度
     * @return 距离，单位为km
     */
    public double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double difference = radLat1 - radLat2;
        double mdifference = rad(lng1) - rad(lng2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mdifference / 2), 2)));
        distance = distance * 6378.137;
        distance = Math.round(distance * 10000d) / 10000d;
        return distance;
    }

    /**
     * 计算弧度
     * @param d 角度数
     * @return 弧度数
     */
    private double rad(double d) {
        return d * Math.PI / 180.0;
    }
}
