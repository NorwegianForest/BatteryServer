<%@ page import="com.business.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: szl
  Date: 2018/3/13
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Change Battery Complete</title>
</head>
<body>
<%
    try {
      String number = request.getParameter("n");

      long currentTime = System.currentTimeMillis();
      Date currentDate = new Date(currentTime); // 当前时间
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

      System.out.println(sdf.format(currentDate) + " 硬件 " + number + " 换电完成");

      Vehicle vehicle = Database.findVehicle("number", number);

      Appointment appointment = Database.findAppointment(Database.VEHICLE_ID, Integer.toString(vehicle.getId()));
      Battery oldBattery = Database.findBattery(Database.VEHICLE_ID, Integer.toString(vehicle.getId()));
      int money = 50; // 预设费用为50

      // 预约完成
      String sql = "update appointment set complete=1 where id=" + appointment.getId();
      Database.updateDatabase(sql);

      // 添加换电记录
      sql = "insert into record(user_id,vehicle_id,station_id,money,old_battery_id,new_battery_id,date)values('"
              + appointment.getUserId() + "','"
              + vehicle.getId() + "','"
              + appointment.getStationId() + "','"
              + money + "','"
              + oldBattery.getId() + "','"
              + appointment.getNewBatteryId() + "','"
              + sdf.format(currentDate) + "')";
      Database.updateDatabase(sql);

      // 更新电池位置
      sql = "update battery set vehicle_id=" + vehicle.getId() + ", station_id=-1 where id=" + appointment.getNewBatteryId();
      Database.updateDatabase(sql);
      sql = "update battery set vehicle_id=-1, station_id=" + appointment.getStationId() + " where id=" + oldBattery.getId();
      Database.updateDatabase(sql);

      response.getWriter().print("success");
      System.out.println(number + " 换电数据保存成功");
    } catch (Exception e) {
      e.printStackTrace();
      response.getWriter().print("error");
      System.out.println("换电数据保存失败");
    }
%>
</body>
</html>
