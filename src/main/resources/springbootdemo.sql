/*
Navicat MySQL Data Transfer

Source Server         : 172.18.9.199
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : springbootdemo

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-12-26 15:44:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for file_upload
-- ----------------------------
DROP TABLE IF EXISTS `file_upload`;
CREATE TABLE `file_upload` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime NOT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='文件管理';

-- ----------------------------
-- Table structure for xg_material
-- ----------------------------
DROP TABLE IF EXISTS `xg_material`;
CREATE TABLE `xg_material` (
  `id` varchar(32) NOT NULL,
  `applicantId` varchar(255) DEFAULT NULL,
  `assessorw` varchar(255) DEFAULT NULL,
  `buyer` varchar(255) DEFAULT NULL,
  `count` varchar(255) DEFAULT NULL,
  `createTime` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `materialSn` varchar(255) NOT NULL,
  `materialState` int(11) NOT NULL,
  `materialType` varchar(255) DEFAULT NULL,
  `orderNumber` varchar(255) DEFAULT NULL,
  `planPrice` double NOT NULL,
  `purPrice` double NOT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `itemNumber` varchar(255) DEFAULT NULL,
  `amount` int(11) NOT NULL,
  `totalPrice` double NOT NULL,
  `planTotal` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_obv2msyaf4wuhuph5qraoxua1` (`materialSn`),
  KEY `description` (`description`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xg_user
-- ----------------------------
DROP TABLE IF EXISTS `xg_user`;
CREATE TABLE `xg_user` (
  `id` varchar(32) NOT NULL,
  `createTime` bigint(20) NOT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `employeeID` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `lastLoginTime` bigint(20) NOT NULL,
  `level` varchar(255) DEFAULT NULL,
  `loginName` varchar(255) DEFAULT NULL,
  `user_mobilePhone` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_sex` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `user_telPhone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `agd` (`employeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
