package com.servlet;

import com.business.Database;
import com.google.gson.Gson;

import com.business.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应APP登录请求
 * 参数为phone,password
 * 返回User对象
 */

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        System.out.println("LoginServlet:" + phone + "请求登录");

        User user = Database.checkUser(phone, password);
        if (user == null) {
            response.getWriter().print("illegal");
            System.out.println("LoginServlet:" + phone + "登录失败");
        } else {
            System.out.println("LoginServlet:" + user.getPhone() + "登录成功");
            String jsonData = new Gson().toJson(user);
            response.getWriter().print(jsonData);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
