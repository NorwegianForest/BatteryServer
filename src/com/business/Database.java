package com.business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库相关操作
 */

public class Database {

    public static final String USERID = "user_id";
    public static final String VEHICLEID = "vehicle_id";
    public static final String ID = "id";

    /**
     * 获取数据库连接，数据库名、用户名、密码，详见Constants类
     * 需要mysql相关jar包支持，详见Constants类
     * @return 连接对象Connection，若连接失败，返回null
     */
    public static Connection getConnection() {
        String DB = "jdbc:mysql://localhost:3306/" + Constants.DBNAME + "?user=" + Constants.DBUSER + "&password=" +
                Constants.DBPASSWORD;
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
                statement.close();
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
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getDouble("longitude"),
                        resultSet.getDouble("latitude"));
                stationList.add(station);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    /**
     * 根据车辆id在数据库battery数据表中查找对应的电池数据
     * @param column 要查找的字段名，详见此类静态常量属性
     * @param value 要查找的值
     * @return 查找到的电池对象
     */
    public static Battery findBattery(String column, String value) {
        String sql = "select * from battery where " + column + "=" + value;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Battery battery = new Battery();
            battery.setId(resultSet.getInt("id"));
            battery.setNumber(resultSet.getString("number"));
            battery.setModel(resultSet.getString("model"));
            battery.setVehicleId(resultSet.getInt("vehicle_id"));
            battery.setStationId(resultSet.getInt("station_id"));
            battery.setElectricity(resultSet.getDouble("electricity"));
            battery.setRatedCapacity(resultSet.getDouble("rated_capacity"));
            battery.setActualCapacity(resultSet.getDouble("actual_capacity"));
            battery.setResidualCapacity(resultSet.getDouble("residual_capacity"));
            battery.setDate(resultSet.getString("date"));
            resultSet.close();
            statement.close();
            connection.close();
            return battery;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查找未完成预约
     * @param column 查找的字段
     * @param value 查找的值
     * @return 预约对象
     */
    public static Appointment findAppointment(String column, String value) {
        String sql = "select * from appointment where complete=0 and " + column + "=" + value;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Appointment appointment = new Appointment();
            appointment.setId(resultSet.getInt("id"));
            appointment.setUserId(resultSet.getInt("user_id"));
            appointment.setVehicleId(resultSet.getInt("vehicle_id"));
            appointment.setStationId(resultSet.getInt("station_id"));
            appointment.setNewBatteryId(resultSet.getInt("new_battery_id"));
            appointment.setDate(resultSet.getString("date"));
            appointment.setComplete(resultSet.getInt("complete"));
            resultSet.close();
            statement.close();
            connection.close();
            return appointment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加载用户所有换电记录
     * @param userId 用户id
     * @param recordList 保存换电记录的列表
     */
    public static void loadRecord(String userId, List<Record> recordList) {
        String sql = "select * from record where user_id=" + userId;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Record record = new Record(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("vehicle_id"),
                        resultSet.getInt("station_id"),
                        resultSet.getDouble("money"),
                        resultSet.getInt("old_battery_id"),
                        resultSet.getInt("new_battery_id"),
                        resultSet.getString("date")
                );
                recordList.add(record);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过station的id查找对应的station对象
     * @param stationId station数据表中的id
     * @return Station对象
     */
    public static Station findStation(String stationId) {
        String sql = "select * from station where id=" + stationId;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Station station = new Station();
            station.setId(resultSet.getInt("id"));
            station.setName(resultSet.getString("name"));
            station.setAddress(resultSet.getString("address"));
            station.setLongitude(resultSet.getDouble("longitude"));
            station.setLatitude(resultSet.getDouble("latitude"));
            resultSet.close();
            statement.close();
            connection.close();
            return station;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询用户的所有预约信息
     * @param userId 用户id
     * @param appointmentList 保存预约信息的列表
     */
    public static void loadAppointment(String userId, List<Appointment> appointmentList) {
        String sql = "select * from appointment where user_id=" + userId;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(resultSet.getInt("id"));
                appointment.setUserId(resultSet.getInt("user_id"));
                appointment.setVehicleId(resultSet.getInt("vehicle_id"));
                appointment.setStationId(resultSet.getInt("station_id"));
                appointment.setNewBatteryId(resultSet.getInt("new_battery_id"));
                appointment.setDate(resultSet.getString("date"));
                appointmentList.add(appointment);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过vehicle的id查询Vehicle对象
     * @param vehicleId 在vehicle数据表中对应的id
     * @return Vehicle对象
     */
    public static Vehicle findVehicle(String vehicleId) {
        String sql = "select * from vehicle where id=" + vehicleId;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Vehicle vehicle = new Vehicle();
            vehicle.setId(resultSet.getInt("id"));
            vehicle.setNumber(resultSet.getString("number"));
            vehicle.setBrand(resultSet.getString("brand"));
            vehicle.setModel(resultSet.getString("model"));
            vehicle.setPlate(resultSet.getString("plate"));
            vehicle.setUserId(resultSet.getInt("user_id"));
            vehicle.setLongitude(resultSet.getDouble("longitude"));
            vehicle.setLatitude(resultSet.getDouble("latitude"));
            vehicle.setDate(resultSet.getString("date"));
            resultSet.close();
            statement.close();
            connection.close();
            return vehicle;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据用户id，在数据库user_station表中查找所有收藏电站数据
     * @param userId 用户id
     * @param stationList 保存收藏电站数据的列表
     */
    public static void loadCollection(String userId, List<Station> stationList) {
        String sql = "select * from user_station where user_id=" + userId;
        Connection connection = getConnection();
        List<Integer> idList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                idList.add(resultSet.getInt("station_id"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Integer integer : idList) {
            stationList.add(findStation(integer.toString()));
        }
    }

    /**
     * 判断用户或车辆是否有未完成的预约
     * @param column 字段名，user_id或vehicle_id
     * @param value 要查找的值
     * @return 若有未完成的预约则返回true，反之false
     */
    public static boolean hasAppointment(String column, String value) {
        String sql = "select * from appointment where complete=0 and " + column + "=" + value;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                resultSet.close();
                statement.close();
                connection.close();
                return true;
            } else {
                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 为预约的用户查找电站中是否有符合要求的电池
     * @param stationId 电站id
     * @return 电池id，若未匹配到符合要求的电池则返回-1
     */
    public static int matchBattery(String stationId) {
        int batteryId = -1;
        String sql = "select * from battery where station_id=" + stationId + " order by electricity desc";
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                batteryId = resultSet.getInt("id");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return batteryId;
    }

    /**
     * 执行一次sql更新语句
     * @param sql 要执行的语句
     */
    public static void updateDatabase(String sql) {
        Connection con = getConnection();
        try {
            Statement state = con.createStatement();
            state.executeUpdate(sql);
            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向appointment数据表插入预约信息
     * @param userId 用户id
     * @param vehicleId 车辆id
     * @param stationId 电站id
     * @param batteryId 电池id
     * @param date 预约时间
     */
    public static void insertAppointment(String userId, String vehicleId, String stationId, String batteryId,
                                         String date) {
        String sql = "insert into appointment(user_id,vehicle_id,station_id,new_battery_id,date,complete)values("
                + userId + "," + vehicleId + "," + stationId + "," + batteryId + ",'" + date + "',0)";
        updateDatabase(sql);
    }

    /**
     * 电池位置发生变化：从车辆里换下到电站、从电站换上车辆时，更新电池记录
     * @param batteryId 电池id
     * @param vehicleId 车辆id
     * @param stationId 电站id
     */
    public static void updateBattery(String batteryId, String vehicleId, String stationId) {
        String sql = "update battery set vehicle_id=" + vehicleId + ",station_id=" + stationId + " where id="
                + batteryId;
        updateDatabase(sql);
    }

    /**
     * 由硬件设备post预约完成信息，预约完成后，将预约状态更新为已完成
     * @param vehicle_id 车辆id
     */
    public static void completeAppointment(String vehicle_id) {
        String sql = "update appointment set complete=1 where complete=0 and vehicle_id=" + vehicle_id;
        updateDatabase(sql);
    }

    /**
     * 预约完成后，新增换电记录
     * @param userId 用户id
     * @param vehicleId 车辆id
     * @param stationId 电站id
     * @param money 费用
     * @param oldBatteryId 旧电池id
     * @param newBatteryId 新电池id
     * @param date 日期
     */
    public static void insertRecord(String userId, String vehicleId, String stationId, double money, String oldBatteryId,
                                    String newBatteryId, String date) {
        String sql = "insert into record(user_id,vehicle_id,station_id,money,old_battery_id,new_battery_id,date)values" +
                "(" + userId + "," + vehicleId + "," + stationId + ",'" + Double.toString(money) + "'," + oldBatteryId +
                "," + newBatteryId + ",'" + date + "')";
        updateDatabase(sql);
    }

    /**
     * 根据用户id，查询与用户有关的所有车辆id
     * @param userId 用户id
     * @param uvList 返回在user_vehicle数据表中的查找结果
     */
    public static void loadUVList(String userId, List<UserVehicle> uvList) {
        String sql = "select * from user_vehicle where user_id=" + userId;
        Connection connection = getConnection();
        try {
            Statement statement = connection != null ? connection.createStatement() : null;
            ResultSet resultSet = statement != null ? statement.executeQuery(sql) : null;
            while (resultSet.next()) {
                UserVehicle uv = new UserVehicle();
                uv.setId(resultSet.getInt("id"));
                uv.setUserId(resultSet.getInt("user_id"));
                uv.setVehicleId(resultSet.getInt("vehicle_id"));
                uv.setAdmin(resultSet.getInt("admin"));
                uvList.add(uv);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
