<%@ page import="com.business.Database" %>
<%@ page import="com.business.Record" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: szl
  Date: 2018/3/16
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>寻电后台管理 | 电池详情</title>
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
      <span class="mdl-layout-title">电池详情</span>
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

    <%String batteryId = request.getParameter("battery_id");%>

    <div style="margin: 20px">

      <div style="text-align: center; padding: 10px;">换上记录</div>

      <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="margin: auto;">
        <thead>
        <tr>
          <th class="mdl-data-table__cell--non-numeric">序号</th>
          <th class="mdl-data-table__cell--non-numeric">用户</th>
          <th class="mdl-data-table__cell--non-numeric">电站名称(From)</th>
          <th class="mdl-data-table__cell--non-numeric">车辆车牌号(To)</th>
          <th class="mdl-data-table__cell--non-numeric">车辆编号(To)</th>
          <th class="mdl-data-table__cell--non-numeric">完成日期</th>
        </tr>
        </thead>
        <tbody>
        <%int orderNumber = 1;%>
        <%List<Record> recordList = Database.getBatteryAllRecord(Database.NEW_BATTERY_ID, batteryId);%>
        <%for (Record record : recordList) {%>
        <tr>
          <td><%=orderNumber++%></td>
          <td><%=record.getUserPhone()%></td>
          <td><%=record.getStationName()%></td>
          <td><%=record.getVehiclePlate()%></td>
          <td><%=record.getVehicleNumber()%></td>
          <td><%=record.getDate()%></td>
        </tr>
        <%}%>
        </tbody>
      </table>

      <div style="height: 1px; background-color: #AAAAAA;margin-top: 20px;margin-bottom: 20px;"></div>

      <div style="text-align: center; padding: 10px;">换下记录</div>

      <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="margin: auto;">
        <thead>
        <tr>
          <th class="mdl-data-table__cell--non-numeric">序号</th>
          <th class="mdl-data-table__cell--non-numeric">用户</th>
          <th class="mdl-data-table__cell--non-numeric">车辆车牌号(From)</th>
          <th class="mdl-data-table__cell--non-numeric">车辆编号(From)</th>
          <th class="mdl-data-table__cell--non-numeric">电站名称(To)</th>
          <th class="mdl-data-table__cell--non-numeric">完成日期</th>
        </tr>
        </thead>
        <tbody>
        <%orderNumber = 1;%>
        <%recordList = Database.getBatteryAllRecord(Database.OLD_BATTERY_ID, batteryId);%>
        <%for (Record record : recordList) {%>
        <tr>
          <td><%=orderNumber++%></td>
          <td><%=record.getUserPhone()%></td>
          <td><%=record.getVehiclePlate()%></td>
          <td><%=record.getVehicleNumber()%></td>
          <td><%=record.getStationName()%></td>
          <td><%=record.getDate()%></td>
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
