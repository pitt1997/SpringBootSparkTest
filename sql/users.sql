/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : sparktest

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2019-07-08 16:07:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `UserID` int(11) NOT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Occupation` int(10) DEFAULT NULL,
  `Zip-code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'F', '10', '10', '48067');
INSERT INTO `users` VALUES ('2', 'M', '56', '16', '70072');
INSERT INTO `users` VALUES ('3', 'M', '25', '15', '55117');
INSERT INTO `users` VALUES ('4', 'M', '25', '7', '55117');
INSERT INTO `users` VALUES ('5', 'M', '25', '20', '55117');
INSERT INTO `users` VALUES ('6', 'F', '35', '12', '55117');
INSERT INTO `users` VALUES ('7', 'M', '25', '20', '55117');
INSERT INTO `users` VALUES ('8', 'M', '25', '12', '55117');
INSERT INTO `users` VALUES ('9', 'M', '25', '17', '55117');
INSERT INTO `users` VALUES ('10', 'F', '35', '17', '55117');
INSERT INTO `users` VALUES ('11', 'F', '25', '17', '55117');
INSERT INTO `users` VALUES ('12', 'M', '25', '17', '55117');
INSERT INTO `users` VALUES ('13', 'M', '45', '17', '55117');
INSERT INTO `users` VALUES ('14', 'M', '35', '17', '55117');
INSERT INTO `users` VALUES ('15', 'M', '25', '17', '55117');
INSERT INTO `users` VALUES ('16', 'F', '35', '17', '55117');
INSERT INTO `users` VALUES ('17', 'M', '18', '17', '55117');
INSERT INTO `users` VALUES ('18', 'F', '18', '17', '55117');
INSERT INTO `users` VALUES ('19', 'M', '18', '17', '55117');
INSERT INTO `users` VALUES ('20', 'M', '18', '17', '55117');
INSERT INTO `users` VALUES ('21', 'M', '18', '17', '55117');
INSERT INTO `users` VALUES ('22', 'M', '18', '17', '55117');
INSERT INTO `users` VALUES ('23', 'M', '18', '17', '55117');
INSERT INTO `users` VALUES ('24', 'F', '18', '17', '55117');
INSERT INTO `users` VALUES ('25', 'F', '18', '17', '55117');
INSERT INTO `users` VALUES ('26', 'F', '18', '17', '55117');
INSERT INTO `users` VALUES ('27', 'F', '18', '17', '55117');
INSERT INTO `users` VALUES ('28', 'F', '18', '17', '55117');
INSERT INTO `users` VALUES ('29', 'M', '18', '17', '55117');
INSERT INTO `users` VALUES ('30', 'M', '18', '17', '55117');
