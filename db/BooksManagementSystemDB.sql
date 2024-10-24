/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : BooksManagementSystemDB

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 24/10/2024 14:10:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '图书的唯一标识',
  `title` varchar(255) NOT NULL COMMENT '图书名称',
  `author` varchar(255) NOT NULL COMMENT '作者名称',
  `year` int NOT NULL COMMENT '出版年份',
  `isDelete` tinyint(1) DEFAULT '0' COMMENT '逻辑删除，1表示已删除 0未删除',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1849301695033532418 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='图书信息表，存储系统中的图书数据';

SET FOREIGN_KEY_CHECKS = 1;
