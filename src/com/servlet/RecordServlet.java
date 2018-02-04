package com.servlet;

import com.business.Database;
import com.business.Record;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "RecordServlet")
public class RecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("id");
        System.out.println("RecordServlet:" + userId + "请求换电记录数据");

        List<Record> recordList = new ArrayList<>();
        Database.loadRecord(userId, recordList);

        String jsonData = new Gson().toJson(recordList);
        out.println(jsonData);
        System.out.println("RecordServlet:" + userId + "请求换电记录数据完成");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
