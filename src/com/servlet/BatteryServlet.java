package com.servlet;

import com.business.Battery;
import com.business.Database;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BatteryServlet")
public class BatteryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String vehicleId = request.getParameter("id");
        System.out.println("BatteryServlet:" + vehicleId + "请求电池数据");
        Battery battery = Database.findBattery(Database.VEHICLEID, vehicleId);

        String jsonData = new Gson().toJson(battery);
        out.println(jsonData);
        System.out.println("BatteryServlet:" + vehicleId + "请求电池数据响应完成");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
