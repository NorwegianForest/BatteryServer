<%@ page import="java.util.Base64" %>
<%@ page import="com.business.Battery" %>
<%@ page import="com.business.Database" %>
<%@ page import="java.util.List" %>
<%@ page import="com.business.Appointment" %><%--
  Created by IntelliJ IDEA.
  User: szl
  Date: 2018/3/10
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>寻电后台管理 | 电池列表</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

  <!-- Add to homescreen for Chrome on Android -->
  <meta name="mobile-web-app-capable" content="yes">

  <!-- Add to homescreen for Safari on iOS -->
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-title" content="Material Design Lite">

  <!-- Tile icon for Win8 (144x144 + tile color) -->
  <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
  <meta name="msapplication-TileColor" content="#3372DF">

  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
  <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
    <div class="mdl-layout__header-row">
      <span class="mdl-layout-title">电池列表</span>
      <div class="mdl-layout-spacer"></div>
      <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
        <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
          <i class="material-icons">search</i>
        </label>
        <div class="mdl-textfield__expandable-holder">
          <input class="mdl-textfield__input" type="text" id="search">
          <label class="mdl-textfield__label" for="search">Enter your query...</label>
        </div>
      </div>
      <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
        <i class="material-icons">more_vert</i>
      </button>
      <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
        <li class="mdl-menu__item">About</li>
        <li class="mdl-menu__item">Contact</li>
        <li class="mdl-menu__item">Legal information</li>
      </ul>
    </div>
  </header>
  <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
    <header class="demo-drawer-header">
      <img src="images/user.jpg" class="demo-avatar">
      <div class="demo-avatar-dropdown">
        <span>Admin</span>
        <div class="mdl-layout-spacer"></div>
        <button id="accbtn" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
          <i class="material-icons" role="presentation">arrow_drop_down</i>
          <span class="visuallyhidden">Accounts</span>
        </button>
        <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="accbtn">
          <li class="mdl-menu__item"><i class="material-icons">add</i>Add another account...</li>
        </ul>
      </div>
    </header>
    <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
      <a class="mdl-navigation__link" href="login_record.jsp">
        <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">account_box</i>登录记录
      </a>
      <a class="mdl-navigation__link" href="appointment.jsp">
        <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">bookmark</i>预约记录
      </a>
      <a class="mdl-navigation__link" href="record.jsp">
        <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">assignment</i>换电记录
      </a>
      <a class="mdl-navigation__link" href="station.jsp">
        <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">ev_station</i>电站列表
      </a>
      <a class="mdl-navigation__link" href="battery.jsp">
        <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">battery_charging_full</i>电池列表
      </a>
      <a class="mdl-navigation__link" href="vehicle.jsp">
        <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">directions_car</i>车辆列表
      </a>
      <div class="mdl-layout-spacer"></div>
      <a class="mdl-navigation__link" href=""><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">help_outline</i><span class="visuallyhidden">Help</span></a>
    </nav>
  </div>
  <main class="mdl-layout__content mdl-color--grey-100" style="overflow-x: scroll;">

    <div style="margin: 20px;">
      <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        <thead>
          <tr>
            <th class="mdl-data-table__cell--non-numeric">序号</th>
            <th class="mdl-data-table__cell--non-numeric">编号</th>
            <th class="mdl-data-table__cell--non-numeric">电池型号</th>
            <th class="mdl-data-table__cell--non-numeric">所在车辆编号</th>
            <th>所在电站名称</th>
            <th class="mdl-data-table__cell--non-numeric">电量(%)</th>
            <th class="mdl-data-table__cell--non-numeric">额定容量(kW/h)</th>
            <th class="mdl-data-table__cell--non-numeric">实际容量(kW/h)</th>
            <th class="mdl-data-table__cell--non-numeric">剩余容量(kW/h)</th>
            <th class="mdl-data-table__cell--non-numeric">预约情况</th>
            <th class="mdl-data-table__cell--non-numeric">预约用户</th>
            <th class="mdl-data-table__cell--non-numeric">预约车辆车牌号</th>
            <th class="mdl-data-table__cell--non-numeric">预约车辆编号</th>
            <th class="mdl-data-table__cell--non-numeric">投入使用日期</th>
          </tr>
        </thead>

        <%int orderNumber = 1;%>
        <%List<Battery> batteryList = Database.getAllBattery();%>
        <tbody>
        <%for (Battery battery : batteryList) {%>
        <tr>
          <td><%=orderNumber++%></td>
          <td><a href="battery_details.jsp?battery_id=<%=battery.getId()%>"><%=battery.getNumber()%></a></td>
          <td><%=battery.getModel()%></td>
          <td><%=battery.getVehicleNumber()%></td>
          <%if (battery.getStationId() == -1) {%>
          <td><%=battery.getStationName()%></td>
          <%} else {%>
          <td><a href="station_details.jsp?station_id=<%=battery.getStationId()%>">
            <%=battery.getStationName()%>
          </a></td>
          <%}%>
          <td><%=battery.getElectricity()%></td>
          <td><%=battery.getRatedCapacity()%></td>
          <td><%=battery.getActualCapacity()%></td>
          <td><%=battery.getResidualCapacity()%></td>
          <%Appointment appointment = Database.findAppointment(Database.NEW_BATTERY_ID, Integer.toString(battery.getId()));%>
          <%if (appointment == null) {%>
          <td>无预约</td>
          <td>/</td>
          <td>/</td>
          <td>/</td>
          <%} else {%>
          <td>已预约</td>
          <td><%=appointment.getUserPhone()%></td>
          <td><%=appointment.getVehiclePlate()%></td>
          <td><%=appointment.getVehicleNumber()%></td>
          <%}%>
          <td><%=battery.getDate()%></td>
        </tr>
        <%}%>
        </tbody>
      </table>
    </div>

  </main>
</div>

<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>

