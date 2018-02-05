package com.servlet;

import com.business.Database;
import com.business.Station;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StationByIdServlet")
public class StationByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String stationId = request.getParameter("station_id");
        System.out.println("StationByIdServlet:请求" + stationId + "号电站数据");
        Station station = Database.findStation(stationId);

        if (station == null) {
            out.print("无结果");
            System.out.println("StationByIdServlet:请求" + stationId + "号电站数据无结果");
        } else {
            String jsonData = new Gson().toJson(station);
            out.print(jsonData);
            System.out.println("StationByIdServlet:请求" + stationId + "号电站数据响应完成");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
