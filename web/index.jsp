<%--
  Created by IntelliJ IDEA.
  User: szl
  Date: 2018/1/31
  Time: 11:27
  主页用于测试servlet
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Battery Server</title>
  </head>
  <body>
    <div align="center"><h2>测试Servlet</h2></div>
    <p>测试用户登录LoginServlet类</p>
    <form method="post" action="/login">
      phone:<input type="text" name="phone">
      password:<input type="text" name="password"><input type="submit">
    </form>
    <br>
    <p>测试获取附近电站StationServlet类</p>
    <form method="post" action="/station">
      user id:<input type="text" name="user_id">
      vehicle id:<input type="text" name="vehicle_id"><input type="submit">
    </form>
    <br>
    <p>测试获取车辆数据VehicleServlet类</p>
    <form method="post" action="/vehicle">
      vehicle id:<input type="text" name="vehicle_id" id=""><input type="submit">
    </form>
    <br>
    <p>测试硬件向服务器发送换电完成数据</p>
    <form name="complete" method="post" action="/hardware_complete">
      vehicle id:<input type="text" name="vehicle_id"><input type="submit">
    </form>
  </body>
</html>
