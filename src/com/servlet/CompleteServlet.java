package com.servlet;

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
        System.out.println("CompleteServlet:" + userId + "询问预约是否已完成");

        if (Database.hasAppointment(Database.USERID, userId)) {
            out.print("未完成");
            System.out.println("CompleteServlet:" + userId + "预约未完成");
        } else {
            out.print("已完成");
            System.out.println("CompleteServlet:" + userId + "预约已完成");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
