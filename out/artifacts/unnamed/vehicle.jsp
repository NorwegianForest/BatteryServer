<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.business.Database" %>
<%@ page import="com.business.Vehicle" %>
<%@ page import="com.business.Battery" %><%--
  Created by IntelliJ IDEA.
  User: szl
  Date: 2018/3/10
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Upload Parameters From Vehicle</title>
</head>
<body>
<%
try {
    String number = request.getParameter("n");
    String longitude = request.getParameter("lo");
    String latitude = request.getParameter("la");
    String speed = request.getParameter("s");
    String direction = request.getParameter("d");
    String temperature = request.getParameter("t");
    String humidity = request.getParameter("h");
    String voltage = request.getParameter("v");
    String current = request.getParameter("c");
    String electricity = request.getParameter("e");

    long currentTime = System.currentTimeMillis();
    Date currentDate = new Date(currentTime); // 当前时间
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    System.out.println(sdf.format(currentDate) + " 硬件 " + number + " 上传数据");
    System.out.println("编号：" + number);
    System.out.println("经度：" + longitude);
    System.out.println("纬度：" + latitude);
    System.out.println("速度：" + speed);
    System.out.println("方向：" + direction);
    System.out.println("温度：" + temperature);
    System.out.println("湿度：" + humidity);
    System.out.println("电压：" + voltage);
    System.out.println("电流：" + current);
    System.out.println("电量：" + electricity);

    // 海里公里换算
    speed = Double.toString(Double.parseDouble(speed) * 1.852);

    longitude = longitude.split("E")[0];
    longitude = Double.toString(Double.parseDouble(longitude) * 0.01);
    int lo = (int) Double.parseDouble(longitude);
    longitude = Double.toString(lo + (Double.parseDouble(longitude) - lo) / 60 * 100);

    latitude = latitude.split("N")[0];
    latitude = Double.toString(Double.parseDouble(latitude) * 0.01);
    int la = (int) Double.parseDouble(latitude);
    latitude = Double.toString(la + (Double.parseDouble(latitude) - la) / 60 * 100);


    String sql = "update vehicle set longitude='" + longitude
            + "', latitude='" + latitude
            + "', direction='" + direction
            + "', speed='" + speed
            + "', temperature='" + temperature
            + "', humidity='" + humidity
            + "', voltage='" + voltage
            + "', current='" + current + "' where number='" + number + "'";
    Database.updateDatabase(sql);

    Vehicle vehicle = Database.findVehicle("number", number);
    assert vehicle != null;
    Battery battery = Database.findBattery(Database.VEHICLE_ID, Integer.toString(vehicle.getId()));
    double ele = Integer.parseInt(electricity);
    assert battery != null;
    battery.setElectricity(ele);
    battery.setResidualCapacity(battery.getActualCapacity() * ele * 0.01);
    sql = "update battery set electricity=" + ele + ", residual_capacity=" + battery.getResidualCapacity()
            + " where id=" + battery.getId();
    Database.updateDatabase(sql);
    response.getWriter().print("success");
    System.out.println(number + " 硬件上传数据完成");
} catch (Exception e) {
    e.printStackTrace();
    response.getWriter().print("error");
    System.out.println("硬件上传数据失败");
}
%>
</body>
</html>
