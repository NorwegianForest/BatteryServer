package com.servlet;

import com.business.Battery;
import com.business.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ElectricityServlet")
public class ElectricityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("user_id");
        System.out.println("Electricity:" + userId + "询问电量");

        if (!userId.equals("-1")) {
            String referenceId = Database.getReferenceId(userId);
            Battery battery = Database.findBattery(Database.VEHICLE_ID, referenceId);

            if (battery.getElectricity() < 20) {
                out.print("电量不足");
                System.out.println("Electricity:" + userId + "电量不足");
            } else {
                out.print("电量充足");
                System.out.println("Electricity:" + userId + "电量充足");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
