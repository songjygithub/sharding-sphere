/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.10 : Database - ds0
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `sys_area` */

DROP TABLE IF EXISTS `sys_area`;

CREATE TABLE `sys_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `area_code` int(11) DEFAULT NULL COMMENT '地区编码',
  `area_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '地区名',
  `level` int(11) DEFAULT NULL COMMENT '地区级别（1:省份province,2:市city,3:区县district,4:街道street）',
  `city_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '城市编码',
  `center` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '城市中心点（即：经纬度坐标）',
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '地区父节点',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'b备注',
  `creater_id` int(11) DEFAULT NULL COMMENT 'c创建人员',
  `modifier_id` int(11) DEFAULT NULL COMMENT 'x修改人员',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT 'x修改时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地区编码';

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` int(11) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT '' COMMENT '负责人',
  `phone` varchar(11) DEFAULT '' COMMENT '联系电话',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `order_id` int(11) NOT NULL COMMENT '订单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_order0` */

DROP TABLE IF EXISTS `t_order0`;

CREATE TABLE `t_order0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `order_id` int(11) NOT NULL COMMENT '订单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_order1` */

DROP TABLE IF EXISTS `t_order1`;

CREATE TABLE `t_order1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `order_id` int(11) NOT NULL COMMENT '订单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=484718753687273473 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_order_item` */

DROP TABLE IF EXISTS `t_order_item`;

CREATE TABLE `t_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_id` int(11) NOT NULL COMMENT '订单ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `brand_name` varchar(56) NOT NULL COMMENT 'brandName',
  `product_name` varchar(56) NOT NULL COMMENT 'productName',
  `order_date` varchar(32) NOT NULL COMMENT 'orderDate',
  `pay_date` varchar(32) NOT NULL COMMENT 'payDate',
  `total_price` float NOT NULL COMMENT 'totalPrice',
  `pay_discount` int(11) NOT NULL DEFAULT '0' COMMENT 'payDiscount',
  `pay_price` float NOT NULL COMMENT 'payPrice',
  PRIMARY KEY (`id`,`pay_discount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_order_item0` */

DROP TABLE IF EXISTS `t_order_item0`;

CREATE TABLE `t_order_item0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_id` int(11) NOT NULL COMMENT '订单ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `brand_name` varchar(56) NOT NULL COMMENT 'brandName',
  `product_name` varchar(56) NOT NULL COMMENT 'productName',
  `order_date` varchar(32) NOT NULL COMMENT 'orderDate',
  `pay_date` varchar(32) NOT NULL COMMENT 'payDate',
  `total_price` float NOT NULL COMMENT 'totalPrice',
  `pay_discount` int(11) NOT NULL DEFAULT '0' COMMENT 'payDiscount',
  `pay_price` float NOT NULL COMMENT 'payPrice',
  PRIMARY KEY (`id`,`pay_discount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_order_item1` */

DROP TABLE IF EXISTS `t_order_item1`;

CREATE TABLE `t_order_item1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_id` int(11) NOT NULL COMMENT '订单ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `brand_name` varchar(56) NOT NULL COMMENT 'brandName',
  `product_name` varchar(56) NOT NULL COMMENT 'productName',
  `order_date` varchar(32) NOT NULL COMMENT 'orderDate',
  `pay_date` varchar(32) NOT NULL COMMENT 'payDate',
  `total_price` float NOT NULL COMMENT 'totalPrice',
  `pay_discount` int(11) NOT NULL DEFAULT '0' COMMENT 'payDiscount',
  `pay_price` float NOT NULL COMMENT 'payPrice',
  PRIMARY KEY (`id`,`pay_discount`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_province` */

DROP TABLE IF EXISTS `t_province`;

CREATE TABLE `t_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(120) NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
