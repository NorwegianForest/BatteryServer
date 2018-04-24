package com.servlet;

import com.business.Appointment;
import com.business.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CompleteServlet")
public class CompleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("id");
        System.out.println("CompleteServlet:" + userId + "询问预约是否完成");

        if (!userId.equals("-1")) {
            Appointment appointment = Database.findFromAllAppointment(Database.USER_ID, userId);

            if (appointment == null) {
                out.print("无预约");
                System.out.println("CompleteServlet:" + userId + "无预约");
            } else {
                if (appointment.getComplete() == 0) {
                    out.print("未完成");
                    System.out.println("CompleteServlet:" + userId + "预约未完成");
                } else if (appointment.getComplete() == 1) {
                    out.print("已完成");
                    String sql = "update appointment set ask=1 where id=" + appointment.getId();
                    Database.updateDatabase(sql);
                    System.out.println("CompleteServlet:" + userId + "预约已完成");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
