/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : battery

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-03-11 13:10:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) DEFAULT NULL,
  `vehicle_id` int(255) DEFAULT NULL,
  `station_id` int(255) DEFAULT NULL,
  `new_battery_id` int(255) DEFAULT NULL,
  `time` int(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `complete` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES ('1', '1', '1', '1', '1', '12', '2018-02-10 16:47:29', '1');
INSERT INTO `appointment` VALUES ('3', '1', '1', '1', '3', '14', '2018-02-10 16:47:31', '-1');
INSERT INTO `appointment` VALUES ('4', '3', '3', '2', '3', '0', '2018-03-01 17:10:11', '0');
INSERT INTO `appointment` VALUES ('5', '4', '4', '2', '4', '2', '2018-03-01 17:10:15', '0');
INSERT INTO `appointment` VALUES ('6', '5', '5', '2', '5', '4', '2018-03-01 17:10:16', '0');
INSERT INTO `appointment` VALUES ('7', '6', '6', '2', '6', '6', '2018-03-01 17:10:18', '0');
INSERT INTO `appointment` VALUES ('8', '7', '7', '2', '7', '8', '2018-03-01 17:10:19', '0');
INSERT INTO `appointment` VALUES ('9', '8', '8', '2', '8', '10', '2018-03-01 17:10:22', '0');
INSERT INTO `appointment` VALUES ('10', '9', '9', '2', '9', '12', '2018-03-01 17:10:24', '0');
INSERT INTO `appointment` VALUES ('11', '10', '10', '2', '10', '14', '2018-03-01 17:10:26', '0');
INSERT INTO `appointment` VALUES ('12', '11', '11', '2', '11', '16', '2018-03-01 17:10:27', '0');
INSERT INTO `appointment` VALUES ('13', '12', '12', '1', '12', '0', '2018-03-01 17:10:29', '0');
INSERT INTO `appointment` VALUES ('14', '13', '13', '1', '13', '2', '2018-03-01 17:10:30', '0');
INSERT INTO `appointment` VALUES ('15', '14', '14', '3', '14', '0', '2018-03-01 17:10:32', '0');
INSERT INTO `appointment` VALUES ('16', '15', '15', '3', '15', '2', '2018-03-01 17:10:33', '0');
INSERT INTO `appointment` VALUES ('17', '16', '16', '4', '16', '0', '2018-03-01 17:10:35', '0');
INSERT INTO `appointment` VALUES ('18', '17', '17', '4', '17', '2', '2018-03-01 17:10:37', '0');
INSERT INTO `appointment` VALUES ('19', '18', '18', '5', '18', '0', '2018-03-01 17:10:39', '0');
INSERT INTO `appointment` VALUES ('20', '19', '19', '5', '19', '2', '2018-03-01 17:10:41', '0');
INSERT INTO `appointment` VALUES ('21', '20', '20', '5', '20', '4', '2018-03-01 17:10:42', '0');
INSERT INTO `appointment` VALUES ('22', '21', '21', '5', '21', '6', '2018-03-01 17:10:43', '0');
INSERT INTO `appointment` VALUES ('23', '22', '22', '6', '22', '0', '2018-03-01 17:10:45', '0');
INSERT INTO `appointment` VALUES ('24', '23', '23', '6', '23', '2', '2018-03-01 17:10:47', '0');
INSERT INTO `appointment` VALUES ('25', '24', '24', '6', '24', '4', '2018-03-01 17:10:48', '0');
INSERT INTO `appointment` VALUES ('26', '25', '25', '6', '25', '6', '2018-03-01 17:10:50', '0');
INSERT INTO `appointment` VALUES ('27', '26', '26', '6', '26', '8', '2018-03-01 17:10:52', '0');
INSERT INTO `appointment` VALUES ('28', '27', '27', '6', '27', '10', '2018-03-01 17:10:53', '0');
INSERT INTO `appointment` VALUES ('29', '28', '28', '7', '28', '0', '2018-03-01 17:10:55', '0');
INSERT INTO `appointment` VALUES ('30', '29', '29', '7', '29', '2', '2018-03-01 17:10:57', '0');
INSERT INTO `appointment` VALUES ('31', '30', '30', '7', '30', '4', '2018-03-01 17:10:59', '0');
INSERT INTO `appointment` VALUES ('32', '31', '31', '7', '31', '6', '2018-03-01 17:11:01', '0');
INSERT INTO `appointment` VALUES ('33', '32', '32', '7', '32', '8', '2018-03-01 17:11:04', '0');
INSERT INTO `appointment` VALUES ('38', '1', '1', '1', '3', '4', '2018-03-02 19:56:17', '-1');
INSERT INTO `appointment` VALUES ('39', '1', '1', '1', '3', '4', '2018-03-02 19:56:25', '-1');
INSERT INTO `appointment` VALUES ('40', '1', '1', '1', '3', '4', '2018-03-02 19:56:28', '-1');
INSERT INTO `appointment` VALUES ('41', '1', '1', '1', '3', '4', '2018-03-02 19:56:30', '-1');
INSERT INTO `appointment` VALUES ('42', '1', '1', '1', '3', '4', '2018-03-02 19:56:33', '-1');
INSERT INTO `appointment` VALUES ('43', '1', '1', '1', '3', '4', '2018-03-02 19:57:04', '-1');
INSERT INTO `appointment` VALUES ('44', '1', '1', '1', '3', '4', '2018-03-02 20:06:59', '-1');
INSERT INTO `appointment` VALUES ('45', '1', '1', '2', '5', '18', '2018-03-02 20:08:42', '-1');
INSERT INTO `appointment` VALUES ('46', '1', '1', '2', '5', '18', '2018-03-02 21:00:46', '-1');
INSERT INTO `appointment` VALUES ('47', '1', '1', '1', '33', '4', '2018-03-10 17:51:25', '-1');

-- ----------------------------
-- Table structure for battery
-- ----------------------------
DROP TABLE IF EXISTS `battery`;
CREATE TABLE `battery` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `vehicle_id` int(255) DEFAULT NULL,
  `station_id` int(255) DEFAULT NULL,
  `electricity` double DEFAULT NULL,
  `rated_capacity` double DEFAULT NULL,
  `actual_capacity` double DEFAULT NULL,
  `residual_capacity` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of battery
-- ----------------------------
INSERT INTO `battery` VALUES ('1', 'B1000001', 'NCR18650A', '1', '-1', '85', '85', '85', '72.25', '2018-02-04 22:40:15');
INSERT INTO `battery` VALUES ('2', 'B1000002', 'NCR18650A', '2', '-1', '70.6', '85', '85', '60', '2018-01-01 15:05:29');
INSERT INTO `battery` VALUES ('3', 'B1000003', 'NCR18650A', '-1', '2', '100', '85', '85', '85', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('4', 'B1000004', 'NCR18650A', '-1', '2', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('5', 'B1000005', 'NCR18650A', '-1', '2', '100', '85', '70', '70', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('6', 'B1000006', 'NCR18650A', '-1', '2', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('7', 'B1000007', 'NCR18650A', '-1', '2', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('8', 'B1000008', 'NCR18650A', '-1', '2', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('9', 'B1000009', 'NCR18650A', '-1', '2', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('10', 'B1000010', 'NCR18650A', '-1', '2', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('11', 'B1000011', 'NCR18650A', '-1', '2', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('12', 'B1000012', 'NCR18650A', '-1', '1', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('13', 'B1000013', 'NCR18650A', '-1', '1', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('14', 'B1000014', 'NCR18650A', '-1', '3', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('15', 'B1000015', 'NCR18650A', '-1', '3', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('16', 'B1000016', 'NCR18650A', '-1', '4', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('17', 'B1000017', 'NCR18650A', '-1', '4', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('18', 'B1000018', 'NCR18650A', '-1', '5', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('19', 'B1000019', 'NCR18650A', '-1', '5', '50', '85', '85', '42.5', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('20', 'B1000020', 'NCR18650B', '-1', '5', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('21', 'B1000021', 'NCR18650B', '-1', '5', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('22', 'B1000022', 'NCR18650B', '-1', '6', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('23', 'B1000023', 'NCR18650B', '-1', '6', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('24', 'B1000024', 'NCR18650B', '-1', '6', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('25', 'B1000025', 'NCR18650B', '-1', '6', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('26', 'B1000026', 'NCR18650B', '-1', '6', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('27', 'B1000027', 'NCR18650B', '-1', '6', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('28', 'B1000028', 'NCR18650B', '-1', '7', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('29', 'B1000029', 'NCR18650B', '-1', '7', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('30', 'B1000030', 'NCR18650B', '-1', '7', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('31', 'B1000031', 'NCR18650B', '-1', '7', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('32', 'B1000032', 'NCR18650B', '-1', '7', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('33', 'B1000033', 'NCR18650B', '-1', '1', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('34', 'B1000034', 'NCR18650B', '-1', '1', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('35', 'B1000035', 'NCR18650B', '-1', '2', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('36', 'B1000036', 'NCR18650B', '-1', '3', '50', '60', '60', '30', '2018-01-01 16:43:33');
INSERT INTO `battery` VALUES ('37', 'B1000037', 'NCR18650B', '-1', '4', '50', '60', '60', '30', '2018-01-01 16:43:33');

-- ----------------------------
-- Table structure for login_record
-- ----------------------------
DROP TABLE IF EXISTS `login_record`;
CREATE TABLE `login_record` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_record
-- ----------------------------
INSERT INTO `login_record` VALUES ('1', '1', '18402884427', '1', '2018-03-10 15:05:33');
INSERT INTO `login_record` VALUES ('2', null, '18402884427', '1', '2018-03-10 17:49:36');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL,
  `station_id` int(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `old_battery_id` int(255) DEFAULT NULL,
  `new_battery_id` int(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1', '1', '1', '60', '4', '1', '2018-02-04 19:01:10');

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES ('1', '天府广场充换电站', '四川省成都市天府广场', '104.06', '30.67');
INSERT INTO `station` VALUES ('2', '犀浦地铁站充换电站', '四川省成都犀浦地铁站', '103.52', '31.01');
INSERT INTO `station` VALUES ('3', '成都春秋名邸充换电站', '四川省成都市龙泉驿区龙都北路39号成都春秋名邸', '103.88', '30.99');
INSERT INTO `station` VALUES ('4', '成都龙域龙湾二期充换电站', '四川省成都市龙泉驿区燃灯寺南路', '104.55', '31.55');
INSERT INTO `station` VALUES ('5', '成都景华苑充换电站', '四川省成都市龙泉驿区董郎路226号景华苑', '104.33', '31.33');
INSERT INTO `station` VALUES ('6', '成都伊顿小镇充换电站', '四川省成都市金堂县S101', '104.22', '31.44');
INSERT INTO `station` VALUES ('7', '成都太平镇政府充换电站', '四川省成都市双流区太平镇政府街999号', '103.22', '30.22');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '18402884427', '123456', '200', '1');
INSERT INTO `user` VALUES ('2', '15280830189', '123456', '500', '2');
INSERT INTO `user` VALUES ('3', '13515469786', '123456', '100', '3');
INSERT INTO `user` VALUES ('4', '13525468654', '123456', '200', '4');
INSERT INTO `user` VALUES ('5', '13536546876', '123456', '300', '5');
INSERT INTO `user` VALUES ('6', '13545447956', '123456', '400', '6');
INSERT INTO `user` VALUES ('7', '13553215465', '123456', '500', '7');
INSERT INTO `user` VALUES ('8', '13568765634', '123456', '600', '8');
INSERT INTO `user` VALUES ('9', '13579875465', '123456', '500', '9');
INSERT INTO `user` VALUES ('10', '13589765462', '123456', '400', '10');
INSERT INTO `user` VALUES ('11', '13595462168', '123456', '300', '11');
INSERT INTO `user` VALUES ('12', '13503513035', '123456', '200', '12');
INSERT INTO `user` VALUES ('13', '13816875105', '123456', '100', '13');
INSERT INTO `user` VALUES ('14', '13826787087', '123456', '100', '14');
INSERT INTO `user` VALUES ('15', '13835491608', '123456', '200', '15');
INSERT INTO `user` VALUES ('16', '13840686089', '123456', '300', '16');
INSERT INTO `user` VALUES ('17', '13850874683', '123456', '400', '17');
INSERT INTO `user` VALUES ('18', '13866587980', '123456', '500', '18');
INSERT INTO `user` VALUES ('19', '13879854150', '123456', '600', '19');
INSERT INTO `user` VALUES ('20', '13889465405', '123456', '500', '20');
INSERT INTO `user` VALUES ('21', '13894615106', '123456', '400', '21');
INSERT INTO `user` VALUES ('22', '13809840909', '123456', '300', '22');
INSERT INTO `user` VALUES ('23', '13916508687', '123456', '200', '23');
INSERT INTO `user` VALUES ('24', '13925670546', '123456', '100', '24');
INSERT INTO `user` VALUES ('25', '13935408460', '123456', '200', '25');
INSERT INTO `user` VALUES ('26', '13940984650', '123456', '300', '26');
INSERT INTO `user` VALUES ('27', '13950846546', '123456', '400', '27');
INSERT INTO `user` VALUES ('28', '13964890840', '123456', '500', '28');
INSERT INTO `user` VALUES ('29', '13978654651', '123456', '600', '29');
INSERT INTO `user` VALUES ('30', '13986515606', '123456', '500', '30');
INSERT INTO `user` VALUES ('31', '13984980465', '123456', '400', '31');
INSERT INTO `user` VALUES ('32', '13906504600', '123456', '300', '32');
INSERT INTO `user` VALUES ('33', '18913543508', '123456', '200', null);
INSERT INTO `user` VALUES ('34', '18921685416', '123456', '100', null);
INSERT INTO `user` VALUES ('35', '18934654651', '123456', '200', null);

-- ----------------------------
-- Table structure for user_station
-- ----------------------------
DROP TABLE IF EXISTS `user_station`;
CREATE TABLE `user_station` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) DEFAULT NULL,
  `station_id` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_station
-- ----------------------------
INSERT INTO `user_station` VALUES ('2', '2', '1');
INSERT INTO `user_station` VALUES ('4', '1', '2');
INSERT INTO `user_station` VALUES ('6', '1', '1');

-- ----------------------------
-- Table structure for user_vehicle
-- ----------------------------
DROP TABLE IF EXISTS `user_vehicle`;
CREATE TABLE `user_vehicle` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) DEFAULT NULL,
  `vehicle_id` int(255) DEFAULT NULL,
  `admin` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_vehicle
-- ----------------------------
INSERT INTO `user_vehicle` VALUES ('1', '1', '1', '1');
INSERT INTO `user_vehicle` VALUES ('2', '2', '2', '1');
INSERT INTO `user_vehicle` VALUES ('3', '1', '2', '0');
INSERT INTO `user_vehicle` VALUES ('4', '3', '3', '1');
INSERT INTO `user_vehicle` VALUES ('5', '4', '4', '1');
INSERT INTO `user_vehicle` VALUES ('6', '5', '5', '1');
INSERT INTO `user_vehicle` VALUES ('7', '6', '6', '1');
INSERT INTO `user_vehicle` VALUES ('8', '7', '7', '1');
INSERT INTO `user_vehicle` VALUES ('9', '8', '8', '1');
INSERT INTO `user_vehicle` VALUES ('10', '9', '9', '1');
INSERT INTO `user_vehicle` VALUES ('11', '10', '10', '1');
INSERT INTO `user_vehicle` VALUES ('12', '11', '11', '1');
INSERT INTO `user_vehicle` VALUES ('13', '12', '12', '1');
INSERT INTO `user_vehicle` VALUES ('14', '13', '13', '1');
INSERT INTO `user_vehicle` VALUES ('15', '14', '14', '1');
INSERT INTO `user_vehicle` VALUES ('16', '15', '15', '1');
INSERT INTO `user_vehicle` VALUES ('17', '16', '16', '1');
INSERT INTO `user_vehicle` VALUES ('18', '17', '17', '1');
INSERT INTO `user_vehicle` VALUES ('19', '18', '18', '1');
INSERT INTO `user_vehicle` VALUES ('20', '19', '19', '1');
INSERT INTO `user_vehicle` VALUES ('21', '20', '20', '1');
INSERT INTO `user_vehicle` VALUES ('22', '21', '21', '1');
INSERT INTO `user_vehicle` VALUES ('23', '22', '22', '1');
INSERT INTO `user_vehicle` VALUES ('24', '23', '23', '1');
INSERT INTO `user_vehicle` VALUES ('25', '24', '24', '1');
INSERT INTO `user_vehicle` VALUES ('26', '25', '25', '1');
INSERT INTO `user_vehicle` VALUES ('27', '26', '26', '1');
INSERT INTO `user_vehicle` VALUES ('28', '27', '27', '1');
INSERT INTO `user_vehicle` VALUES ('29', '28', '28', '1');
INSERT INTO `user_vehicle` VALUES ('30', '29', '29', '1');
INSERT INTO `user_vehicle` VALUES ('31', '30', '30', '1');
INSERT INTO `user_vehicle` VALUES ('32', '31', '31', '1');
INSERT INTO `user_vehicle` VALUES ('33', '32', '32', '1');

-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `plate` varchar(255) DEFAULT NULL,
  `user_id` int(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `direction` double(255,0) DEFAULT NULL,
  `temperature` double DEFAULT NULL,
  `humidity` double DEFAULT NULL,
  `voltage` double DEFAULT NULL,
  `current` double DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('1', 'V1000001', '特斯拉', 'Model-s', '川A53776', '1', '103', '30', '2018-01-01 17:04:45', '185', '26', '50', '1.5', '0.5', '2018-03-11 13:02:52');
INSERT INTO `vehicle` VALUES ('2', 'V1000002', '凯迪拉克', 'CT6', '川A89374', '2', '103.6543', '30.3546', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('3', 'V1000003', '凯迪拉克', 'CT6', '川A45397', '3', '103.6577', '30.1357', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('4', 'V1000004', '凯迪拉克', 'CT6', '川A54379', '4', '103.5468', '30.5798', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('5', 'V1000005', '凯迪拉克', 'CT6', '川A96735', '5', '103.21654', '30.5482', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('6', 'V1000006', '凯迪拉克', 'CT6', '川A05723', '6', '103.1355', '30.5987', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('7', 'V1000007', '凯迪拉克', 'CT6', '川A57357', '7', '103.8979', '30.216', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('8', 'V1000008', '凯迪拉克', 'CT6', '川A52788', '8', '103.8432', '30.2135', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('9', 'V1000009', '凯迪拉克', 'CT6', '川A79973', '9', '103.6654', '30.21687', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('10', 'V1000010', '凯迪拉克', 'CT6', '川A24787', '10', '103.3151', '30.4897', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('11', 'V1000011', '凯迪拉克', 'CT6', '川A12877', '11', '103.1357', '30.84321', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('12', 'V1000012', '凯迪拉克', 'CT6', '川A78087', '12', '103.7466', '30.6546', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('13', 'V1000013', '凯迪拉克', 'CT6', '川A78786', '13', '103.4687', '30.5136', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('14', 'V1000014', '凯迪拉克', 'CT6', '川A45378', '14', '103.1358', '30.9843', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('15', 'V1000015', '凯迪拉克', 'CT6', '川A12097', '15', '103.5487', '30.5796', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('16', 'V1000016', '凯迪拉克', 'CT6', '川A78788', '16', '103.7839', '30.0687', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('17', 'V1000017', '凯迪拉克', 'CT6', '川A54347', '17', '103.4789', '30.65432', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('18', 'V1000018', '凯迪拉克', 'CT6', '川A79783', '18', '103.2694', '30.2498', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('19', 'V1000019', '凯迪拉克', 'CT6', '川A42024', '19', '103.2793', '30.54916', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('20', 'V1000020', '凯迪拉克', 'CT6', '川A12767', '20', '103.1863', '30.564', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('21', 'V1000021', '凯迪拉克', 'CT6', '川A87768', '21', '103.1148', '30.5466', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('22', 'V1000022', '凯迪拉克', 'CT6', '川A27507', '22', '103.1359', '30.2168', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('23', 'V1000023', '凯迪拉克', 'CT6', '川A02137', '23', '103.1768', '30.2468', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('24', 'V1000024', '凯迪拉克', 'CT6', '川A78673', '24', '103.4987', '30.4897', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('25', 'V1000025', '凯迪拉克', 'CT6', '川A05767', '25', '103.21387', '30.6843', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('26', 'V1000026', '凯迪拉克', 'CT6', '川A72873', '26', '103.4687', '30.6813', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('27', 'V1000027', '凯迪拉克', 'CT6', '川A42457', '27', '103.21357', '30.3546', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('28', 'V1000028', '凯迪拉克', 'CT6', '川A75387', '28', '103.2468', '30.6843', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('29', 'V1000029', '凯迪拉克', 'CT6', '川A43054', '29', '103.1687', '30.6873', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('30', 'V1000030', '凯迪拉克', 'CT6', '川A34837', '30', '103.2468', '30.1387', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('31', 'V1000031', '凯迪拉克', 'CT6', '川A98375', '31', '103.2168', '30.6681', '2018-01-01 17:04:45', null, null, null, null, null, null);
INSERT INTO `vehicle` VALUES ('32', 'V1000032', '凯迪拉克', 'CT6', '川A40787', '32', '103.1587', '30.6813', '2018-01-01 17:04:45', null, null, null, null, null, null);
