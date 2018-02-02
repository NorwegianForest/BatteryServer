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
import java.util.List;

@WebServlet(name = "StationServlet")
public class StationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("id");
        List<Vehicle> vehicleList = new ArrayList<>();
        try {
            Database.loadVehicle(userId, vehicleList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Vehicle vehicle = vehicleList.get(0);

        List<Station> stationList = new ArrayList<>();
        Database.loadStation(stationList);
        for (Station station : stationList) {
            station.setDistance(getDistance(vehicle, station));
            station.setQueueTime(10);
        }
        String jsonData = new Gson().toJson(stationList);
        out.println(jsonData);

        Station station = stationList.get(0);
        System.out.println(getDistance(vehicle.getLatitude(), vehicle.getLongitude(), station.getLatitude(), station.getLongitude())); }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private double getDistance(Vehicle vehicle, Station station) {
        return getDistance(vehicle.getLatitude(), vehicle.getLongitude(), station.getLatitude()
            , station.getLongitude());
    }

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
//        String distanceStr = distance + "";
//        distanceStr = distanceStr.
//                substring(0, distanceStr.indexOf("."));
//
//        return distanceStr;
    }

    private double rad(double d) {
        return d * Math.PI / 180.0;
    }
}
