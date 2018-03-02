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
import java.util.ArrayList;
import java.util.List;

import static com.servlet.StationServlet.getDistance;

@WebServlet(name = "RecommendServlet")
public class RecommendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("user_id");
        System.out.println("RecommendServlet:" + userId + "请求推荐电站数据");

        Vehicle vehicle = Database.findVehicle(Database.getReferenceId(userId)); // 用户默认参考车辆来计算距离
        List<Station> allStationList = new ArrayList<>();
        Database.loadStation(allStationList);

        for (Station station : allStationList) {
            if (vehicle != null) {
                station.setDistance(getDistance(vehicle, station)); // 计算车辆与电站的距离
            } else {
                station.setDistance(0.0);
            }
            station.setQueueTime(Database.getAppointmentCount(Integer.toString(station.getId())) * 2); // 排队时间
        }

        List<Station> recommendList = new ArrayList<>();
        allStationList.sort((s1, s2) -> (int) (s1.getDistance() - s2.getDistance())); // 根据距离对车站列表进行排序
        recommendList.add(allStationList.get(0));
        allStationList.sort((s1, s2) -> (int) (s1.getQueueTime() - s2.getQueueTime())); //根据排队时间
        recommendList.add(allStationList.get(0));

        String jsonData = new Gson().toJson(recommendList);
        response.getWriter().print(jsonData);
        System.out.println("RecommendServlet:" + userId + "请求推荐电站数据响应完成");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
