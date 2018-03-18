<%@ page import="com.business.Battery" %>
<%@ page import="com.business.Database" %>
<%@ page import="com.business.Vehicle" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--
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
StringBuilder log = new StringBuilder();
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
    log.append(sdf.format(currentDate)).append(" 硬件 ").append(number).append(" 上传数据\r\n")
    .append("编号：").append(number)
    .append("\r\n经度：").append(longitude)
    .append("\r\n纬度：").append(latitude)
    .append("\r\n速度：").append(speed)
    .append("\r\n方向：").append(direction)
    .append("\r\n温度：").append(temperature)
    .append("\r\n湿度：").append(humidity)
    .append("\r\n电压：").append(voltage)
    .append("\r\n电流：").append(current)
    .append("\r\n电量：").append(electricity);

    if (Double.parseDouble(voltage) == 0.0) {
        log.append("\r\n无效数据，不存入数据库");
    } else {

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
        log.append("\r\n").append(number).append(" 硬件上传数据完成");
    }
} catch (Exception e) {
    e.printStackTrace();
    response.getWriter().print("error");
    System.out.println("硬件上传数据失败");
    log.append("\r\n硬件上传数据失败\r\n").append(e.toString()).append("\r\n\r\n\r\n");
}

try {
    File file = new File("C:\\Users\\Administrator\\Desktop\\log.txt");
    FileWriter fw = new FileWriter(file, true);
    PrintWriter pw = new PrintWriter(fw);
    pw.println(log.toString());
    pw.flush();
    fw.flush();
    pw.close();
    fw.close();
} catch (Exception e) {
    e.printStackTrace();
    System.out.println("写入Log文件失败");
}
%>
</body>
</html>
