<%--
  Created by IntelliJ IDEA.
  User: szl
  Date: 2018/3/10
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  String longitude = request.getParameter("longitude");
  String latitude = request.getParameter("latitude");
  String direction = request.getParameter("direction");
  String temperature = request.getParameter("temperature");
  String humidity = request.getParameter("humidity");
  String voltage = request.getParameter("voltage");
  String current = request.getParameter("current");
  String electricity = request.getParameter("electricity");

  System.out.println("硬件上传数据");
  System.out.println("经度：" + longitude);
  System.out.println("纬度：" + latitude);
  System.out.println("方向：" + direction);
  System.out.println("温度：" + temperature);
  System.out.println("湿度：" + humidity);
  System.out.println("电压：" + voltage);
  System.out.println("电流：" + current);
  System.out.println("电量：" + electricity);
  System.out.println("硬件上传数据完成");
%>
</body>
</html>
