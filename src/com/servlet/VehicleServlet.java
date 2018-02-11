package com.servlet;

import com.business.Database;
import com.business.Vehicle;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应获取车辆数据
 * 参数vehicle_id
 * 返回车辆对象
 */

@WebServlet(name = "VehicleServlet")
public class VehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String vehicleId = request.getParameter("vehicle_id");
        System.out.println("VehicleServlet:" + vehicleId + "请求该车辆数据");

        Vehicle vehicle = Database.findVehicle(vehicleId);

        if (vehicle == null) {
            response.getWriter().print("无结果");
            System.out.println("VehicleServlet:" + vehicleId + "请求该车辆数据无结果");
        } else {
            String jsonData = new Gson().toJson(vehicle);
            response.getWriter().print(jsonData);
            System.out.println("VehicleServlet:" + vehicleId + "请求该车辆数据响应完成");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
