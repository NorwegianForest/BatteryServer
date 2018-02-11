package com.servlet;

import com.business.Database;
import com.business.Station;
import com.business.Vehicle;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 响应APP获取附近电站的请求
 * 参数为user_id,vehicle_id
 * 返回附近电站对象列表
 */

@WebServlet(name = "StationServlet")
public class StationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("user_id");
        String vehicleId = request.getParameter("vehicle_id");
        System.out.println("StationServlet:" + userId + "请求电站数据，参考车辆id:" + vehicleId);

        Vehicle vehicle = Database.findVehicle(vehicleId); // 默认取用户的第一辆车来计算距离
        List<Station> stationList = new ArrayList<>();
        Database.loadStation(stationList);

        for (Station station : stationList) {
            if (vehicle != null) {
                station.setDistance(getDistance(vehicle, station)); // 计算车辆与电站的距离
            } else {
                station.setDistance(0.0);
            }
            station.setQueueTime(10); // 预设排队时间为10min
        }

        stationList.sort((s1, s2) -> (int) (s1.getDistance() - s2.getDistance())); // 根据距离对车站列表进行排序

        String jsonData = new Gson().toJson(stationList);
        response.getWriter().print(jsonData);
        System.out.println("StationServlet:" + userId + "请求电站数据响应完成");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    /**
     * 计算车辆和电站之间的距离
     * @param vehicle 车辆对象
     * @param station 电站对象
     * @return 距离，单位km
     */
    public static double getDistance(Vehicle vehicle, Station station) {
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
    private static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double difference = radLat1 - radLat2;
        double mDifference = rad(lng1) - rad(lng2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mDifference / 2), 2)));
        distance = distance * 6378.137;
        distance = Math.round(distance * 10000d) / 10000d;
        return distance;
    }

    /**
     * 计算弧度
     * @param d 角度数
     * @return 弧度数
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }
}
