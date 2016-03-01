/*
Navicat MySQL Data Transfer

Source Server         : 192.168.140.31
Source Server Version : 50547
Source Host           : 192.168.140.31:3306
Source Database       : user_db

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-03-01 16:35:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_entity`
-- ----------------------------
DROP TABLE IF EXISTS `user_entity`;
CREATE TABLE `user_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `slat` varchar(255) DEFAULT NULL,
  `user_status` int(11) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

