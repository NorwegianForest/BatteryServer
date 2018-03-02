package com.servlet;

import com.business.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HandleCollectionServlet")
public class HandleCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("user_id");
        String stationId = request.getParameter("station_id");
        String method = request.getParameter("method");

        if (method.equals("set")) {
            Database.setCollection(userId, stationId);
            out.print("收藏成功");
            System.out.println("HandleCollectionServlet:" + userId + "用户请求收藏电站" + stationId);
        } else if (method.equals("cancel")) {
            Database.cancelCollection(userId, stationId);
            out.print("取消收藏成功");
            System.out.println("HandleCollectionServlet:" + userId + "用户请求取消收藏电站" + stationId);
        } else {
            out.print("不明请求");
            System.out.println("HandleCollectionServlet:" + userId + "用户不明请求电站" + stationId);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
