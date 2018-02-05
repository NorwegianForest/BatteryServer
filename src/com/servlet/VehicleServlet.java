package com.servlet;

import com.business.Database;
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

@WebServlet(name = "VehicleServlet")
public class VehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String vehicleId = request.getParameter("vehicle_id");
        System.out.println("VehicleServlet:" + vehicleId + "请求该车辆数据");

        Vehicle vehicle = Database.findVehicle(vehicleId);

        if (vehicle == null) {
            out.print("无结果");
            System.out.println("VehicleServlet:" + vehicleId + "请求该车辆数据无结果");
        } else {
            String jsonData = new Gson().toJson(vehicle);
            out.print(jsonData);
            System.out.println("VehicleServlet:" + vehicleId + "请求该车辆数据响应完成");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
