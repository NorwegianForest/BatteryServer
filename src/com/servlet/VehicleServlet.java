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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VehicleServlet")
public class VehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String userId = request.getParameter("id");
        List<Vehicle> vehicleList = new ArrayList<>();
        try {
            Database.loadVehicle(userId, vehicleList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String jsonData = new Gson().toJson(vehicleList);
        out.println(jsonData);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
