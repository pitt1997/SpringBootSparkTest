/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : sparktest

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2019-07-08 16:07:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for movies
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `movieId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `genres` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`movieId`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movies
-- ----------------------------
INSERT INTO `movies` VALUES ('1', 'Toy Story (1995)', 'Adventure|Animation|Children|Comedy|Fantasy');
INSERT INTO `movies` VALUES ('2', 'Jumanji (1995)', 'Adventure|Children|Fantasy');
INSERT INTO `movies` VALUES ('3', 'Grumpier Old Men (1995)', 'Comedy|Romance');
INSERT INTO `movies` VALUES ('4', 'Waiting to Exhale (1995)', 'Comedy|Drama|Romance');
INSERT INTO `movies` VALUES ('5', 'Father of the Bride Part II (1995)', 'Comedy');
INSERT INTO `movies` VALUES ('6', 'Heat (1995)', 'Action|Crime|Thriller');
INSERT INTO `movies` VALUES ('7', 'Sabrina (1995)', 'Comedy|Romance');
INSERT INTO `movies` VALUES ('8', 'Tom and Huck (1995)', 'Adventure|Children');
INSERT INTO `movies` VALUES ('9', 'Sudden Death (1995)', 'Action');
INSERT INTO `movies` VALUES ('10', 'GoldenEye (1995)', 'Action|Adventure|Thriller');
INSERT INTO `movies` VALUES ('11', 'American President, The (1995)', 'Comedy|Drama|Romance');
INSERT INTO `movies` VALUES ('12', 'Dracula: Dead and Loving It (1995)', 'Comedy|Horror');
INSERT INTO `movies` VALUES ('13', 'Balto (1995)', 'Adventure|Animation|Children');
INSERT INTO `movies` VALUES ('14', 'Nixon (1995)', 'Drama');
INSERT INTO `movies` VALUES ('15', 'Cutthroat Island (1995)', 'Action|Adventure|Romance');
INSERT INTO `movies` VALUES ('16', 'Casino (1995)', 'Crime|Drama');
INSERT INTO `movies` VALUES ('17', 'Sense and Sensibility (1995)', 'Drama|Romance');
INSERT INTO `movies` VALUES ('18', 'Four Rooms (1995)	', 'Comedy');
INSERT INTO `movies` VALUES ('19', 'Ace Ventura: When Nature Calls (1995)', 'Comedy');
INSERT INTO `movies` VALUES ('20', 'Money Train (1995)', 'Action|Comedy|Crime|Drama|Thriller');
INSERT INTO `movies` VALUES ('21', 'Get Shorty (1995)', 'Comedy|Crime|Thriller');
INSERT INTO `movies` VALUES ('22', 'Copycat (1995)', 'Crime|Drama|Horror|Mystery|Thriller');
