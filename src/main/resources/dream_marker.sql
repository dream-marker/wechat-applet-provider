/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : dream_marker

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-10-12 02:34:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_image
-- ----------------------------
DROP TABLE IF EXISTS `tb_image`;
CREATE TABLE `tb_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `img` varchar(300) NOT NULL COMMENT '图片地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COMMENT='图片表';

-- ----------------------------
-- Records of tb_image
-- ----------------------------

-- ----------------------------
-- Table structure for tb_system_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_config`;
CREATE TABLE `tb_system_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` tinyint(4) NOT NULL COMMENT '类型',
  `config` varchar(1024) NOT NULL COMMENT '内容',
  `create_user` bigint(20) NOT NULL COMMENT '创建人ID',
  `update_user` bigint(20) NOT NULL COMMENT '创建时间',
  `create_time` datetime NOT NULL COMMENT '更新人ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='系统配置表';

-- ----------------------------
-- Records of tb_system_config
-- ----------------------------
INSERT INTO `tb_system_config` VALUES ('1', '101', '{\"appId\":\"wxe999d4c1904d3f23\",\"appSecret\":\"ddd36814cdd616810d390e4e5131260e\"}', '-1', '-1', '2018-10-11 22:00:02', '2018-10-11 22:00:00');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `nick` varchar(64) NOT NULL COMMENT '昵称',
  `avatar` varchar(300) NOT NULL COMMENT '头像',
  `gender` tinyint(1) NOT NULL DEFAULT '-1' COMMENT '性别',
  `birthday` date NOT NULL COMMENT '生日',
  `area` tinyint(2) NOT NULL COMMENT '区域',
  `channel` tinyint(2) NOT NULL COMMENT '注册渠道',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('19', '痕过已然 、足迹', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eroHqAxuLcuWQLshgiaM6Gr4pt8wkwaicJjTq5kZatAZY0OIqk154wh1mlDvmJ60vaajDMr9j0Bcuwg/132', '1', '2018-10-11', '-1', '1', '1', '2018-10-11 23:39:39', '2018-10-11 23:39:39');

-- ----------------------------
-- Table structure for tb_user_third
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_third`;
CREATE TABLE `tb_user_third` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `account_1` varchar(64) NOT NULL COMMENT '账号_1 取决于channel',
  `account_2` varchar(64) NOT NULL COMMENT '账号_2 取决于channel',
  `nick` varchar(32) NOT NULL COMMENT '昵称',
  `avatar` varchar(300) NOT NULL COMMENT '头像',
  `channel` tinyint(2) NOT NULL COMMENT '渠道 枚举',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_1__channel` (`account_1`,`channel`) USING BTREE,
  UNIQUE KEY `account_1__2` (`account_1`,`account_2`) USING BTREE,
  UNIQUE KEY `user_id__channel` (`user_id`,`channel`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='第三方用户绑定表';

-- ----------------------------
-- Records of tb_user_third
-- ----------------------------
INSERT INTO `tb_user_third` VALUES ('16', '19', 'oNFjJw3CyXUy-Wb49uIF_GMwZXGs', 'oChX-0INjwWunu0QlVzzHSu1tR9A', '痕过已然 、足迹', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eroHqAxuLcuWQLshgiaM6Gr4pt8wkwaicJjTq5kZatAZY0OIqk154wh1mlDvmJ60vaajDMr9j0Bcuwg/132', '1', '2018-10-11 23:39:39');
