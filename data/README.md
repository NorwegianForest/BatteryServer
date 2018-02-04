# 数据库说明
- 数据库名为battery
- 要导入数据进入数据库，直接导入battery.sql文件即可

## 表：user
- 保存用户信息

|字段名|类型|主键|说明|
|---|---|:---:|---|
|id|int|主键|数据库自增id|
|phone|varchar| |用户手机号|
|password|varchar| |用户密码|
|balance|double| |用户的账户余额|

## 表：station
- 保存电站信息

|字段名|类型|主键|说明|
|---|---|:---:|---|
|id|int|主键|数据库自增id|
|name|varchar| |电站名称|
|address|varchar| | 电站具体地址|
|longitude|double| |经度|
|latitude|double| |纬度|

## 表：vehicle
- 保存硬件设备及对应车辆信息

|字段名|类型|主键|说明|
|---|---|:---:|---|
|id|int|主键|数据库自增id|
|number|varchar| |硬件设备唯一编号标识，编号格式为大写V加7位数字，例如V1000001|
|brand|varchar| |汽车品牌|
|model|varchar| |汽车型号|
|plate|varchar| |汽车车牌号码|
|user_id|int| |硬件设备唯一管理员用户id|
|longitude|double| |经度|
|latitude|double| |纬度|
|date|double| |该硬件设备投入使用的日期和时间，格式为yyyy-mm-dd hh:mm:ss|

## 表：battery
- 保存电池信息

|字段名|类型|主键|说明|
|---|---|:---:|---|
|id|int|主键|数据库自增id|
|number|varchar| |电池唯一编号标识，编号格式为大写B加7位数字，例如B1000001|
|model|varchar| |电池型号|
|vehicle_id|int| |搭载电池的硬件设备id，若电池存储于电站，则为-1|
|station_id|int| |存储电池的电站id，若电池搭载与车辆，则为-1|
|electricity|double| |电池剩余电量的百分比|
|rated_capacity|double| |电池额定容量，单位为千瓦时(kwh)|
|actual_capacity|double| |电池实际容量，单位为千瓦时(kwh)|
|residual_capacity|double| |电池剩余容量，单位为千瓦时(kwh)|
|date|datetime| |该电池投入使用的日期和时间，格式为yyyy-mm-dd hh:mm:ss|

## 表：record
- 保存所有换电记记录

|字段名|类型|主键|说明|
|---|---|:---:|---|
|id|int|主键|数据库自增id|
|user_id|int| |执行换电的用户id|
|vehicle_id|int| |被换电的车辆的id|
|station_id|int| |提供换电服务的电站id|
|money|double| |换电产生的费用|
|old_battery_id|int| |被换下的电池的id|
|new_battery_id|int| |新换上的电池的id|
|date|datetime| |该换电服务完成的日期和时间，格式为yyyy-mm-dd hh:mm:ss|

## 表：appointment
- 保存所有预约记录

|字段名|类型|主键|说明|
|---|---|:---:|---|
|id|int|主键|数据库自增id|
|user_id|int| |预约的用户的id|
|vehicle_id|int| |将要被换电的车辆的id|
|station_id|int| |接受预约的电站的id|
|new_battery_id|int| |电站为用户准备的电池的id|
|date|datetime| |预约时间和日期，格式为yyyy-mm-dd hh:mm:ss|
|complete|smallint| |表示预约是否完成换电，0表示已预约且未完成，1表示预约后已完成，-1表示预约后取消|

## 表：user_vehicle
- 保存用户与硬件设备的关系，一位用户可以拥有多个硬件，一个硬件可以被多个用户使用，但只有一位管理员用户

|字段名|类型|主键|说明|
|---|---|:---:|---|
|id|int|主键|数据库自增id|
|user_id|int| |用户id|
|vehicle_id|int| |硬件设备id|
|admin|smallint| |表示该用户是否为该设备的管理员，1表示是，0表示不是|

## 表：user_station
- 保存用户的收藏电站

|字段名|类型|主键|说明|
|---|---|:---:|---|
|id|int|主键|数据库自增id|
|user_id|int| |用户id|
|station_id|int| |电站id|

