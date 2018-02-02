package com.business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库相关操作
 */

public class Database {

    /**
     * 获取数据库连接，数据库名、用户名、密码，详见Constants类
     * 需要mysql相关jar包支持，详见Constants类
     * @return 连接对象Connection，若连接失败，返回null
     */
    public static Connection getConnection() {
        String DB = "jdbc:mysql://localhost:3306/" + Constants.DBNAME + "?user=" + Constants.DBUSER + "&password=" + Constants.DBPASSWORD;
        Connection connection;
        try {
            Class.forName(Constants.CLASSFORNAME);
            connection = DriverManager.getConnection(DB);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据手机号和密码验证登录
     * @param user 用户对象，只有手机和密码两项属性
     * @return 登录成功返回true，登录失败返回false
     */
    public static boolean checkUser(User user) {
        String sql = "select * from user where phone='" + user.getPhone() + "' and password='" + user.getPassword() + "'";
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setBalance(resultSet.getDouble("balance"));
                resultSet.close();
                connection.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询数据库中的所有电站，并创建对象
     * @param stationList Station对象列表
     */
    public static void loadStation(List<Station> stationList) {
        String sql = "select * from station";
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Station station = new Station(resultSet.getInt("id"),
                        resultSet.getString("address"),
                        resultSet.getDouble("longitude"),
                        resultSet.getDouble("latitude"));
                stationList.add(station);
            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    /**
     * 根据用户id搜索该用户的所有汽车
     * @param userId 用户id
     * @param vehicleList 汽车列表
     * @throws SQLException
     */
    public static void loadVehicle(String userId, List<Vehicle> vehicleList) throws SQLException {
        String sql = "select * from user_vehicle where user_id=" + userId;
        List<Integer> vehicleIdList = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            vehicleIdList.add(new Integer(resultSet.getInt("vehicle_id")));
        }
        resultSet.close();
        connection.close();

        for (Integer integer : vehicleIdList) {
            sql = "select * from vehicle where id='" + integer.toString() + "'";
            Connection connection1 = getConnection();
            Statement statement1 = connection1.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(sql);
            while (resultSet1.next()) {
                vehicleList.add(new Vehicle(resultSet1.getInt("id"),
                        resultSet1.getString("number"),
                        resultSet1.getString("brand"),
                        resultSet1.getString("model"),
                        resultSet1.getString("plate"),
                        resultSet1.getInt("user_id"),
                        resultSet1.getDouble("longitude"),
                        resultSet1.getDouble("latitude")));
            }
            resultSet1.close();
            connection1.close();
        }
    }
}
