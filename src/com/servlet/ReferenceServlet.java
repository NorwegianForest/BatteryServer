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

@WebServlet(name = "ReferenceServlet")
public class ReferenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("user_id");
        System.out.println("ReferenceServlet:" + userId + "请求参考车辆");

        String vehicleId = Database.getReferenceId(userId);
        Vehicle vehicle = Database.findVehicle(vehicleId);

        String jsonData = new Gson().toJson(vehicle);
        out.print(jsonData);

        System.out.println("ReferenceServlet:" + userId + "请求参考车辆响应完成");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
