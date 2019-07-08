/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : sparktest

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2019-07-08 16:07:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ratings
-- ----------------------------
DROP TABLE IF EXISTS `ratings`;
CREATE TABLE `ratings` (
  `userId` int(11) NOT NULL,
  `movieId` int(11) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `timestamp` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ratings
-- ----------------------------
INSERT INTO `ratings` VALUES ('1', '1', '1', '1425941529');
INSERT INTO `ratings` VALUES ('1', '2', '1', '1425941529');
INSERT INTO `ratings` VALUES ('1', '3', '2', '1425941529');
INSERT INTO `ratings` VALUES ('1', '4', '2', '1425941529');
INSERT INTO `ratings` VALUES ('1', '5', '4', '1425941529');
INSERT INTO `ratings` VALUES ('2', '1', '1', '1425941529');
INSERT INTO `ratings` VALUES ('2', '2', '1', '1425941529');
INSERT INTO `ratings` VALUES ('2', '3', '2', '1425941529');
INSERT INTO `ratings` VALUES ('2', '4', '4', '1425941529');
INSERT INTO `ratings` VALUES ('2', '6', '3', '1425941529');
INSERT INTO `ratings` VALUES ('3', '3', '3', '1425941529');
INSERT INTO `ratings` VALUES ('3', '4', '4', '1425941529');
INSERT INTO `ratings` VALUES ('3', '5', '5', '1425941529');
INSERT INTO `ratings` VALUES ('3', '7', '5', '1425941529');
INSERT INTO `ratings` VALUES ('4', '8', '3', '1425941529');
INSERT INTO `ratings` VALUES ('4', '2', '3', '1425941529');
INSERT INTO `ratings` VALUES ('5', '5', '5', '1425941529');
INSERT INTO `ratings` VALUES ('5', '9', '3', '1425941529');
INSERT INTO `ratings` VALUES ('6', '6', '3', '1425941529');
INSERT INTO `ratings` VALUES ('7', '7', '5', '1425941529');
INSERT INTO `ratings` VALUES ('8', '8', '3', '1425941529');
INSERT INTO `ratings` VALUES ('9', '9', '3', '1425941529');
INSERT INTO `ratings` VALUES ('10', '10', '3', '1425941529');
INSERT INTO `ratings` VALUES ('11', '11', '4', '1425941529');
INSERT INTO `ratings` VALUES ('12', '12', '3', '1425941529');
INSERT INTO `ratings` VALUES ('13', '13', '4', '1425941529');
INSERT INTO `ratings` VALUES ('14', '14', '3', '1425941529');
INSERT INTO `ratings` VALUES ('15', '15', '3', '1425941529');
INSERT INTO `ratings` VALUES ('16', '16', '3', '1425941529');
INSERT INTO `ratings` VALUES ('17', '17', '2', '1425941529');
INSERT INTO `ratings` VALUES ('18', '18', '2', '1425941529');
INSERT INTO `ratings` VALUES ('19', '19', '2', '1425941529');
INSERT INTO `ratings` VALUES ('20', '20', '2', '1425941529');
INSERT INTO `ratings` VALUES ('21', '21', '2', '1425941529');
INSERT INTO `ratings` VALUES ('22', '20', '2', '1425941529');
INSERT INTO `ratings` VALUES ('23', '1', '2', '1425941529');
INSERT INTO `ratings` VALUES ('24', '1', '2', '1425941529');
INSERT INTO `ratings` VALUES ('25', '1', '2', '1425941529');
INSERT INTO `ratings` VALUES ('26', '1', '2', '1425941529');
INSERT INTO `ratings` VALUES ('27', '1', '2', '1425941529');
INSERT INTO `ratings` VALUES ('28', '1', '2', '1425941529');
INSERT INTO `ratings` VALUES ('29', '1', '2', '1425941529');
INSERT INTO `ratings` VALUES ('30', '1', '2', '1425941529');
INSERT INTO `ratings` VALUES ('30', '22', '2', '1425941529');
INSERT INTO `ratings` VALUES ('30', '22', '2', '1425941529');
