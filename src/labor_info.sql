/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : labor_info

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2018-07-04 09:06:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `enterprise`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` int(15) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `nature` varchar(20) default NULL,
  `corporate` varchar(20) default NULL,
  `introduce` varchar(100) default NULL,
  `telephone` varchar(20) default NULL,
  `img_url` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES ('1', '天旦11', '计算机软件', 'tom11', 'dasdada', '21421412412', '1.png');
INSERT INTO `enterprise` VALUES ('2', 'Morgan', '计算机软件', 'jack', 'wrdfrwefq', '2134135125', '2.png');
INSERT INTO `enterprise` VALUES ('3', '招商银行', '互联网金融', 'tom', 'gfsgsgs', '2435353253', '3.png');
INSERT INTO `enterprise` VALUES ('4', 'dell', '智能硬件', 'jack', 'dadqwdfqwf', '23141225254', '4.png');
INSERT INTO `enterprise` VALUES ('5', '携程', '旅游', 'mary', 'fafafeq', '12212412', '5.png');
INSERT INTO `enterprise` VALUES ('7', 'EF', '教育', 'jdak', 'dwdqwd', '321312312', '7.png');
INSERT INTO `enterprise` VALUES ('8', 'infor11', '在线教育', 'ewrwe', 'dadwdqw', '312124124', '8.png');
INSERT INTO `enterprise` VALUES ('9', '蚂蚁金服', '互联网金融', 'fdwe', 'sdfewf', '31242142141', '9.png');
INSERT INTO `enterprise` VALUES ('10', '埃森哲', '计算机软件', 'ewdwe', 'dcfwef', '12412412', '10.png');
INSERT INTO `enterprise` VALUES ('11', '爱立信', '智能硬件', 'dawd', 'adwedwe', '12312412', '11.png');
INSERT INTO `enterprise` VALUES ('12', '花旗', '互联网金融', 'dwdw', 'ffew', '4214124', '12.png');
INSERT INTO `enterprise` VALUES ('13', 'NIO', '信息安全', 'fedqw', 'dsadw', '312424', '13.png');
INSERT INTO `enterprise` VALUES ('14', 'Free Wheel', '智能硬件', 'fsdfwe', 'fdsfwef', '12312312', '14.png');
INSERT INTO `enterprise` VALUES ('15', 'digital', '媒体', '发的威威', 'fdwef', '2132123', '15.png');
INSERT INTO `enterprise` VALUES ('16', 'state street', '互联网金融', 'dwe', 'wqdew', '231312312', '16.png');
INSERT INTO `enterprise` VALUES ('17', 'test', '计算机软件', 'dwe', 'qdewff', '12312', null);
INSERT INTO `enterprise` VALUES ('18', 'dsadw', '游戏', 'fasewf', 'ewfwefwe', 'efwefwe', 'dsadw.png');
INSERT INTO `enterprise` VALUES ('19', 'gssr', '电子商务', 'feerf', 'fewfwefew', 'fesfe', 'gssr.png');
INSERT INTO `enterprise` VALUES ('20', 'feewf', '游戏', 'ewfew', 'efewfw', 'ewfew', 'feewf.png');

-- ----------------------------
-- Table structure for `job_offers`
-- ----------------------------
DROP TABLE IF EXISTS `job_offers`;
CREATE TABLE `job_offers` (
  `id` int(11) NOT NULL auto_increment,
  `skill_need` varchar(50) default NULL,
  `peo_num` int(11) default NULL,
  `claim` varchar(50) default NULL,
  `telephone` varchar(20) default NULL,
  `wage` double default NULL,
  `enterprise_id` int(11) default NULL,
  `enterprise_name` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `enterprise_id` (`enterprise_id`),
  CONSTRAINT `job_offers_ibfk_1` FOREIGN KEY (`enterprise_id`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_offers
-- ----------------------------
INSERT INTO `job_offers` VALUES ('1', '电子商务', '20', '吃苦耐劳', '1232141', '5000', '1', '天旦11');
INSERT INTO `job_offers` VALUES ('2', '信息安全', '2', '技术好', '31224125', '6000', '1', 'aaa');
INSERT INTO `job_offers` VALUES ('3', '硬件', '3', '技术好', '21312312', '5000', '2', 'Morgan');

-- ----------------------------
-- Table structure for `labor`
-- ----------------------------
DROP TABLE IF EXISTS `labor`;
CREATE TABLE `labor` (
  `id` int(15) NOT NULL auto_increment,
  `name` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  `gender` varchar(5) default NULL,
  `telephone` varchar(20) NOT NULL,
  `role` varchar(10) default '''普通用户''',
  `skill` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `QQ` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of labor
-- ----------------------------
INSERT INTO `labor` VALUES ('1', 'cyb123', '123456', '男', '17693459940', '\'admin\'', 'daesfeagae', 'sdagrgaerhea', '245455758');
INSERT INTO `labor` VALUES ('2', 'tom123', '123456', '男', 'scdsfcfw', '\'普通用户\'', 'dfwcefw', 'fefwefw', '231231233');
INSERT INTO `labor` VALUES ('3', 'jack12', '123456', '男', '17693459940', '\'普通用户\'', 'java', '甘肃兰州', '2364523019');

-- ----------------------------
-- Table structure for `work_info`
-- ----------------------------
DROP TABLE IF EXISTS `work_info`;
CREATE TABLE `work_info` (
  `lab_id` int(11) NOT NULL default '0',
  `enterprise_id` int(11) NOT NULL default '0',
  `entry_time` date default NULL,
  `jobs` varchar(50) default NULL,
  `departure_time` date default NULL,
  PRIMARY KEY  (`lab_id`,`enterprise_id`),
  KEY `enterprise_id` (`enterprise_id`),
  CONSTRAINT `work_info_ibfk_1` FOREIGN KEY (`lab_id`) REFERENCES `labor` (`id`),
  CONSTRAINT `work_info_ibfk_2` FOREIGN KEY (`enterprise_id`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work_info
-- ----------------------------
