/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : battery

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-31 15:12:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) DEFAULT NULL,
  `station_id` int(255) DEFAULT NULL,
  `new_battery_id` int(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `complete` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES ('1', '1', '1', '1', '2018-01-01 13:09:27', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of battery
-- ----------------------------
INSERT INTO `battery` VALUES ('1', 'B1000001', 'NCR18650A', '1', '-1', '100', '85', '85', '85', '2018-01-01 15:04:06');
INSERT INTO `battery` VALUES ('2', 'B1000002', 'NCR18650A', '2', '-1', '70.6', '85', '85', '60', '2018-01-01 15:05:29');
INSERT INTO `battery` VALUES ('3', 'B1000003', 'NCR18650A', '-1', '1', '100', '85', '85', '85', '2018-01-01 15:06:12');
INSERT INTO `battery` VALUES ('4', 'B1000004', 'NCR18650A', '-1', '1', '50', '85', '85', '42.5', '2018-01-01 15:06:56');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) DEFAULT NULL,
  `station_id` int(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `old_battery_id` int(255) DEFAULT NULL,
  `new_battery_id` int(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1', '1', '60', '4', '1', '2018-01-01 14:08:56');

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES ('1', '四川省成都市天府广场', '104.06', '30.67');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '18402884427', '123456', '0');
INSERT INTO `user` VALUES ('2', '15280830189', '123456', '500');

-- ----------------------------
-- Table structure for user-station
-- ----------------------------
DROP TABLE IF EXISTS `user-station`;
CREATE TABLE `user-station` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) DEFAULT NULL,
  `station_id` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user-station
-- ----------------------------
INSERT INTO `user-station` VALUES ('1', '1', '1');
INSERT INTO `user-station` VALUES ('2', '2', '1');

-- ----------------------------
-- Table structure for user-vehicle
-- ----------------------------
DROP TABLE IF EXISTS `user-vehicle`;
CREATE TABLE `user-vehicle` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) DEFAULT NULL,
  `vehicle_id` int(255) DEFAULT NULL,
  `admin` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user-vehicle
-- ----------------------------
INSERT INTO `user-vehicle` VALUES ('1', '1', '1', '1');
INSERT INTO `user-vehicle` VALUES ('2', '2', '2', '1');
INSERT INTO `user-vehicle` VALUES ('3', '1', '2', '0');

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
  `user-id` int(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('1', 'V1000001', '特斯拉', 'Model-s', '川A88888', '1', '104.07', '30.7', '2018-01-01 14:58:26');
INSERT INTO `vehicle` VALUES ('2', 'V1000002', '凯迪拉克', 'CT6', '川A12345', '2', '104.05', '30.6', '2018-01-01 15:00:21');
