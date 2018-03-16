package com.servlet;

import com.business.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangeReferenceServlet")
public class ChangeReferenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("user_id");
        String vehicleId = request.getParameter("vehicle_id");
        System.out.println("ChangeReferenceServlet:" + userId + "请求更改参考车辆为" + vehicleId);

        String sql = "update user set vehicle_id=" + vehicleId + " where id=" + userId;
        Database.updateDatabase(sql);
        out.print("更改完成");
        System.out.println("ChangeReferenceServlet:" + userId + "请求更改参考车辆为" + vehicleId + "响应完成");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
