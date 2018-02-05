# 此项目作为APP的服务器
## 说明
- 基本上仅通过IP+servlet访问本服务器
- 仅在本地使用时，IP为http://192.168.0.8:8080
- 公网IP待定

## 更新记录
### 1月31日更新
- 创建数据库，预先添加了示例数据，数据库文件已上传，详情请阅/data/README.md
- 创建与数据库对应的描述各实体的类
- 创建ConnectServlet用来测试服务器与APP的连接

### 2月2日更新
- 通过数据库查询，实现了响应APP的登录、获取车辆和电站信息的请求
- 使用GSON向APP反馈数据
- 引入的经纬测距算法目前正在试用，有待检验

### 2月3日更新
- 数据库station表中添加了name字段，表示电站的名称，有别于电站的详细地址address字段
- 增加了响应车辆请求电池数据的Servlet

### 2月4日更新
- 考虑到数据的完整，数据库appointment数据表和record数据表添加了vehicle_id字段，详见/data/README.md
- 删除了创建项目时创建的用于测试APP与服务器连接的ConnectionServlet类
- 各实体类中用于表示时间的属性Timestemp对象更换为String对象，值由Date类和SimpleDateFormat类构造生成
- 增加了响应APP对预约信息、换电记录、收藏电站的请求
- 增加了响应APP进行预约业务操作的请求，并更新数据库，增加了AppointmentJson类来向APP返回特殊结构的数据
- 增加了响应APP询问预约是否已完成的请求
- 增加了hardware.jsp页面，用来模拟硬件设备向服务器发送post，从index.jsp页面转跳
- 增加了响应硬件post换电完成，并更新数据库
- Database类中的函数结构和关系略显混乱，有待改善

### 2月5日更新
- 规范了Servlet中获取参数的键名
- 增加了UserVehicle类对应数据库中的user_vehicle数据表，同时增加了UserVehicleServlet，以使APP中发送HTTP请求的代码更通顺
- 增加了部分Servlet中，在查找无结果后的响应
- 由于APP请求结构的变动，删除了Database类中不必要的查询方法，提高复用率