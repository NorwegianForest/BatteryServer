package com.servlet;

import com.google.gson.Gson;

import com.business.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应APP登录请求
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        System.out.println("LoginServlet:" + phone + "请求登录");
        User user = new User(phone, password);
        if (user.check()) {
            System.out.println("LoginServlet:" + user.getPhone() + "登录成功");
            String jsonData = new Gson().toJson(user);
            out.println(jsonData);
        } else {
            out.print("illegal");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
