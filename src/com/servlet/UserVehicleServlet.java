package com.servlet;

import com.business.Database;
import com.business.UserVehicle;
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

@WebServlet(name = "UserVehicleServlet")
public class UserVehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("user_id");
        System.out.println("UserVehicleServlet:" + userId + "请求车辆id");

        List<UserVehicle> uvList = new ArrayList<>();
        Database.loadUVList(userId, uvList);

        if (uvList.isEmpty()) {
            out.print("无结果");
            System.out.println("UserVehicleServlet:" + userId + "请求车辆id无结果");
        } else {
            String jsonData = new Gson().toJson(uvList);
            out.print(jsonData);
            System.out.println("UserVehicleServlet:" + userId + "请求车辆id响应完成");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
