/*
Navicat MySQL Data Transfer

Source Server         : example_conection
Source Server Version : 50556
Source Host           : 111.231.236.91:3306
Source Database       : maindb

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2019-07-05 01:21:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) CHARACTER SET utf8 NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `login_id` varchar(20) CHARACTER SET utf8 NOT NULL,
  `tel` varchar(12) CHARACTER SET utf8 DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('test', 'my name', 'test', '12345', '2022-03-04 11:03:11', '1234');
