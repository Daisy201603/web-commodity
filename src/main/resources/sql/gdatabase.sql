/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : gdatabase

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-09-04 00:02:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `birthday` date DEFAULT NULL,
  `sex` char(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
