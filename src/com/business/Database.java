package com.business;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 数据库相关操作
 */

public class Database {

    private static final String FOR_NAME = "com.mysql.jdbc.Driver";
    private static final String DATABASE = "battery";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static final String USER_ID = "user_id";
    public static final String VEHICLE_ID = "vehicle_id";
    public static final String ID = "id";
    public static final String NEW_BATTERY_ID = "new_battery_id";

    /**
     * 获取数据库连接，数据库名、用户名、密码
     * 需要mysql相关jar包支持
     * @return 连接对象Connection，若连接失败，返回null
     */
    private static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/" + DATABASE + "?user=" + USER + "&password=" +
                PASSWORD;
        Connection connection;
        try {
            Class.forName(FOR_NAME);
            connection = DriverManager.getConnection(url);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据手机号和密码验证登录
     * @param phone 手机号
     * @param password 密码
     * @return 登录成功返回User对象，登录失败返回null
     */
    public static User checkUser(String phone, String password) {
        String sql = "select * from user where phone='" + phone + "' and password='" + password + "'";
        Connection connection = getConnection();
        User user = null;
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("phone"),
                        resultSet.getString("password"),
                        resultSet.getDouble("balance"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 查询数据库中的所有电站，并创建对象
     * @param stationList Station对象列表
     */
    public static void loadStation(List<Station> stationList) {
        String sql = "select * from station";
        Connection connection = getConnection();
        try {
            assert connection != null;
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
            assert connection != null;
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
            assert connection != null;
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
        String sql = "select * from record where user_id=" + userId + " order by date desc";
        Connection connection = getConnection();
        try {
            assert connection != null;
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
     * 通过id查找对应的station对象
     * @param stationId station数据表中的id
     * @return Station对象
     */
    public static Station findStation(String stationId) {
        String sql = "select * from station where id=" + stationId;
        Connection connection = getConnection();
        try {
            assert connection != null;
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
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(resultSet.getInt("id"));
                appointment.setUserId(resultSet.getInt("user_id"));
                appointment.setVehicleId(resultSet.getInt("vehicle_id"));
                appointment.setStationId(resultSet.getInt("station_id"));
                appointment.setNewBatteryId(resultSet.getInt("new_battery_id"));
                appointment.setTime(resultSet.getInt("time"));
                appointment.setDate(resultSet.getString("date"));
                appointment.setComplete(resultSet.getInt("complete"));
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
     * 通过id查询Vehicle对象
     * @param vehicleId 在vehicle数据表中对应的id
     * @return Vehicle对象
     */
    public static Vehicle findVehicle(String vehicleId) {
        String sql = "select * from vehicle where id=" + vehicleId;
        Connection connection = getConnection();
        try {
            assert connection != null;
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
            assert connection != null;
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
            assert connection != null;
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
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (!hasAppointment(NEW_BATTERY_ID, resultSet.getString("id"))) {
                    batteryId = resultSet.getInt("id");
                    break;
                }
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
    private static void updateDatabase(String sql) {
        Connection con = getConnection();
        try {
            assert con != null;
            Statement state;
            state = con.createStatement();
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
                                         String time, String date) {
        String sql = "insert into appointment(user_id,vehicle_id,station_id,new_battery_id,time,date,complete)values("
                + userId + "," + vehicleId + "," + stationId + "," + batteryId + "," + time + ",'" + date + "',0)";
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
     * @param vehicleId 车辆id
     */
    public static void completeAppointment(String vehicleId) {
        String sql = "update appointment set complete=1 where complete=0 and vehicle_id=" + vehicleId;
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
            while (Objects.requireNonNull(resultSet).next()) {
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

    public static String getReferenceId(String userId) {
        String vehicleId = null;
        String sql = "select * from user where id=" + userId;
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            vehicleId = rs.getString("vehicle_id");
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  vehicleId;
    }

    public static int getAppointmentCount(String stationId) {
        int count = -1;
        String sql = "select count(*) from appointment where station_id=" + stationId + " and complete=0";
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("count(*)");
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static boolean isAppointment(String userId, String stationId) {
        boolean isAppointment = false;
        String sql = "select * from appointment where user_id=" + userId + " and station_id=" + stationId + " and complete=0";
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                isAppointment = true;
            }
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAppointment;
    }

    public static void cancelAppointment(String userId) {
        String sql = "update appointment set complete='-1' where user_id=" + userId + " and complete=0";
        updateDatabase(sql);
    }

    public static boolean isCollection(String userId, String stationId) {
        boolean isCollection = false;
        String sql = "select * from user_station where user_id=" + userId + " and station_id=" + stationId;
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                isCollection = true;
            }
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCollection;
    }

    public static void setCollection(String userId, String stationId) {
        String sql = "insert into user_station(user_id,station_id)values(" + userId + "," + stationId + ")";
        updateDatabase(sql);
    }

    public static void cancelCollection(String userId, String stationId) {
        String sql = "delete from user_station where user_id=" + userId + " and station_id=" + stationId;
        updateDatabase(sql);
    }

    public static void loginRecord(String phone, int status) {
        long currentTime = System.currentTimeMillis();
        Date currentDate = new Date(currentTime); // 当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "insert into login_record(phone,status,date)values('" + phone + "','" + status + "','" +
                sdf.format(currentDate) + "')";
        updateDatabase(sql);
    }

    public static List<LoginRecord> getAllLoginRecord() {
        List<LoginRecord> recordList = new ArrayList<>();
        String sql = "select * from login_record ORDER BY id DESC ";
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                recordList.add(new LoginRecord(rs.getInt("id"),
                        rs.getString("phone"),
                        rs.getInt("status"),
                        rs.getString("date")));
            }
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recordList;
    }

    public static List<Record> getAllRecord() {
        List<Record> recordList = new ArrayList<>();
        String sql = "select * from record order by id desc";
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                recordList.add(new Record(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("station_id"),
                        rs.getDouble("money"),
                        rs.getInt("old_battery_id"),
                        rs.getInt("new_battery_id"),
                        rs.getString("date")));
            }
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    public static User findUser(String userId) {
        User user = null;
        String sql = "select * from user where id=" + userId;
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            user = new User(rs.getInt("id"),
                    rs.getString("phone"),
                    rs.getString("password"),
                    rs.getDouble("balance"));
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static List<Battery> getAllBattery() {
        List<Battery> batteryList = new ArrayList<>();
        String sql = "select * from battery";
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                batteryList.add(new Battery(rs.getInt("id"),
                        rs.getString("number"),
                        rs.getString("model"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("station_id"),
                        rs.getDouble("electricity"),
                        rs.getDouble("rated_capacity"),
                        rs.getDouble("actual_capacity"),
                        rs.getDouble("residual_capacity"),
                        rs.getString("date")));
            }
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batteryList;
    }

    public static List<Appointment> getAllAppointment() {
        List<Appointment> appointmentList = new ArrayList<>();
        String sql = "select * from appointment order by date desc";
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                appointmentList.add(new Appointment(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("station_id"),
                        rs.getInt("new_battery_id"),
                        rs.getInt("time"),
                        rs.getString("date"),
                        rs.getInt("complete")));
            }
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentList;
    }

    public static int getCount(String sql) {
        int count = -1;
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            count = rs.getInt("count(*)");
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getBatteryAmount(String stationId) {
        String sql = "select count(*) from battery where station_id=" + stationId;
        return getCount(sql);
    }

    public static int getAppointmentBatteryAmount(String stationId) {
        String sql = "select count(*) from appointment where complete=0 and station_id=" + stationId;
        return getCount(sql);
    }
}
