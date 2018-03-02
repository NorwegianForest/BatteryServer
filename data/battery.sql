/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : battery

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-03-02 21:22:05
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
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `complete` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES ('1', '1', '1', '1', '1', '12', '2018-03-01 12:48:33', '1');
INSERT INTO `appointment` VALUES ('3', '1', '1', '1', '3', '14', '2018-03-02 19:46:59', '-1');
INSERT INTO `appointment` VALUES ('4', null, null, '2', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('5', null, null, '2', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('6', null, null, '2', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('7', null, null, '2', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('8', null, null, '2', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('9', null, null, '2', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('10', null, null, '2', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('11', null, null, '2', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('12', null, null, '2', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('13', null, null, '1', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('14', null, null, '1', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('15', null, null, '3', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('16', null, null, '4', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('17', null, null, '3', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('18', null, null, '4', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('19', null, null, '5', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('20', null, null, '5', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('21', null, null, '5', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('22', null, null, '5', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('23', null, null, '6', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('24', null, null, '6', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('25', null, null, '6', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('26', null, null, '6', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('27', null, null, '6', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('28', null, null, '6', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('29', null, null, '7', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('30', null, null, '7', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('31', null, null, '7', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('32', null, null, '7', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('33', null, null, '7', null, null, '2018-03-01 12:48:37', '0');
INSERT INTO `appointment` VALUES ('38', '1', '1', '1', '3', '4', '2018-03-02 19:56:17', '-1');
INSERT INTO `appointment` VALUES ('39', '1', '1', '1', '3', '4', '2018-03-02 19:56:25', '-1');
INSERT INTO `appointment` VALUES ('40', '1', '1', '1', '3', '4', '2018-03-02 19:56:28', '-1');
INSERT INTO `appointment` VALUES ('41', '1', '1', '1', '3', '4', '2018-03-02 19:56:30', '-1');
INSERT INTO `appointment` VALUES ('42', '1', '1', '1', '3', '4', '2018-03-02 19:56:33', '-1');
INSERT INTO `appointment` VALUES ('43', '1', '1', '1', '3', '4', '2018-03-02 19:57:04', '-1');
INSERT INTO `appointment` VALUES ('44', '1', '1', '1', '3', '4', '2018-03-02 20:06:59', '-1');
INSERT INTO `appointment` VALUES ('45', '1', '1', '2', '5', '18', '2018-03-02 20:08:42', '-1');
INSERT INTO `appointment` VALUES ('46', '1', '1', '2', '5', '18', '2018-03-02 21:00:46', '-1');

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
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of battery
-- ----------------------------
INSERT INTO `battery` VALUES ('1', 'B1000001', 'NCR18650A', '1', '-1', '100', '85', '85', '85', '2018-02-04 22:40:15');
INSERT INTO `battery` VALUES ('2', 'B1000002', 'NCR18650A', '2', '-1', '70.6', '85', '85', '60', '2018-01-01 15:05:29');
INSERT INTO `battery` VALUES ('3', 'B1000003', 'NCR18650A', '-1', '1', '100', '85', '85', '85', '2018-02-04 22:40:23');
INSERT INTO `battery` VALUES ('4', 'B1000004', 'NCR18650A', '-1', '1', '50', '85', '85', '42.5', '2018-01-01 15:06:56');
INSERT INTO `battery` VALUES ('5', 'B1000005', 'NCR18650A', '-1', '2', '100', '80', '70', '70', '2018-03-02 19:58:37');

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
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1', '1', '1', '60', '4', '1', '2018-02-04 19:01:10');
INSERT INTO `record` VALUES ('2', null, null, null, null, null, null, '2018-03-03 16:07:05');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '18402884427', '123456', '200', '1');
INSERT INTO `user` VALUES ('2', '15280830189', '123456', '500', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_vehicle
-- ----------------------------
INSERT INTO `user_vehicle` VALUES ('1', '1', '1', '1');
INSERT INTO `user_vehicle` VALUES ('2', '2', '2', '1');
INSERT INTO `user_vehicle` VALUES ('3', '1', '2', '0');

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
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('1', 'V1000001', '特斯拉', 'Model-s', '川A88888', '1', '103.57145', '31.05413', '2018-02-03 22:27:21');
INSERT INTO `vehicle` VALUES ('2', 'V1000002', '凯迪拉克', 'CT6', '川A12345', '2', '104.05', '30.6', '2018-01-01 15:00:21');
