/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.29 : Database - netctoss
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`netctoss` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `netctoss`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `account_id` decimal(9,0) NOT NULL,
  `recommender_id` decimal(9,0) DEFAULT NULL,
  `login_name` varchar(30) NOT NULL,
  `login_passwd` varchar(30) NOT NULL,
  `status` char(1) DEFAULT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `pause_date` datetime DEFAULT NULL,
  `close_date` datetime DEFAULT NULL,
  `real_name` varchar(20) NOT NULL,
  `idcard_no` char(18) NOT NULL,
  `birthdate` datetime DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `occupation` varchar(50) DEFAULT NULL,
  `telephone` varchar(15) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mailaddress` varchar(200) DEFAULT NULL,
  `zipcode` char(6) DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `last_login_ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `account` */

insert  into `account`(`account_id`,`recommender_id`,`login_name`,`login_passwd`,`status`,`create_date`,`pause_date`,`close_date`,`real_name`,`idcard_no`,`birthdate`,`gender`,`occupation`,`telephone`,`email`,`mailaddress`,`zipcode`,`qq`,`last_login_time`,`last_login_ip`) values 
(1005,NULL,'taiji001','256528','1','2008-03-15 00:00:00',NULL,NULL,'zhangsanfeng','410381194302256528','1943-02-25 00:00:00',NULL,NULL,'13669351234',NULL,NULL,NULL,NULL,NULL,NULL),
(1010,NULL,'xl18z60','190613','1','2009-01-10 00:00:00',NULL,NULL,'guojing','330682196903190613','1969-03-19 00:00:00',NULL,NULL,'13338924567',NULL,NULL,NULL,NULL,NULL,NULL),
(1011,1010,'dgbf70','270429','1','2009-03-01 00:00:00',NULL,NULL,'huangrong','330902197108270429','1971-08-27 00:00:00',NULL,NULL,'13637811357',NULL,NULL,NULL,NULL,NULL,NULL),
(1015,1005,'mjjzh64','041115','1','2010-03-12 00:00:00',NULL,NULL,'zhangwuji','610121198906041115','1989-06-04 00:00:00',NULL,NULL,'13572952468',NULL,NULL,NULL,NULL,NULL,NULL),
(1019,1011,'ljxj90','310346','1','2012-02-01 00:00:00',NULL,NULL,'luwushuang','320211199307310346','1993-07-31 00:00:00',NULL,NULL,'13186454984',NULL,NULL,NULL,NULL,NULL,NULL),
(1020,NULL,'kxhxd20','012115','1','2012-02-20 00:00:00',NULL,NULL,'weixiaobao','321022200010012115','2000-10-01 00:00:00',NULL,NULL,'13953410078',NULL,NULL,NULL,NULL,NULL,NULL),
(1021,NULL,'kxhxd21','012116','1','2012-02-20 00:00:00',NULL,NULL,'zhangsan','321022200010012116','2000-10-02 00:00:00',NULL,NULL,'13953410079',NULL,NULL,NULL,NULL,NULL,NULL),
(1022,NULL,'kxhxd22','012117','1','2012-02-20 00:00:00',NULL,NULL,'lisi','321022200010012117','2000-10-03 00:00:00',NULL,NULL,'13953410080',NULL,NULL,NULL,NULL,NULL,NULL),
(1023,NULL,'kxhxd23','012118','1','2012-02-20 00:00:00',NULL,NULL,'wangwu','321022200010012118','2000-10-04 00:00:00',NULL,NULL,'13953410081',NULL,NULL,NULL,NULL,NULL,NULL),
(1024,NULL,'kxhxd24','012119','1','2012-02-20 00:00:00',NULL,NULL,'zhouliu','321022200010012119','2000-10-05 00:00:00',NULL,NULL,'13953410082',NULL,NULL,NULL,NULL,NULL,NULL),
(1025,NULL,'kxhxd25','012120','1','2012-02-20 00:00:00',NULL,NULL,'maqi','321022200010012120','2000-10-06 00:00:00',NULL,NULL,'13953410083',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `admin_info` */

DROP TABLE IF EXISTS `admin_info`;

CREATE TABLE `admin_info` (
  `admin_id` decimal(8,0) NOT NULL,
  `admin_code` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `enrolldate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `admin_info` */

insert  into `admin_info`(`admin_id`,`admin_code`,`password`,`name`,`telephone`,`email`,`enrolldate`) values 
(2000,'admin','123','ADMIN','123456789','admin@tarena.com.cn','2021-03-08 00:09:27'),
(3000,'zhangfei','123','ZhangFei','123456789','zhangfei@tarena.com.cn','2021-03-08 00:09:27'),
(4000,'liubei','123','LiuBei','123456789','liubei@tarena.com.cn','2021-03-08 00:09:27'),
(5000,'caocao','123','CaoCao','123456789','caocao@tarena.com.cn','2021-03-08 00:09:27'),
(6000,'aaa','123','AAA','123456789','aaa@tarena.com.cn','2021-03-08 00:09:27'),
(7000,'bbb','123','BBB','123456789','bbb@tarena.com.cn','2021-03-08 00:09:27');

/*Table structure for table `admin_role` */

DROP TABLE IF EXISTS `admin_role`;

CREATE TABLE `admin_role` (
  `admin_id` decimal(8,0) NOT NULL,
  `role_id` decimal(4,0) NOT NULL,
  PRIMARY KEY (`admin_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `admin_role` */

insert  into `admin_role`(`admin_id`,`role_id`) values 
(2000,100),
(3000,200),
(4000,300),
(5000,100),
(5000,200),
(5000,300);

/*Table structure for table `cost` */

DROP TABLE IF EXISTS `cost`;

CREATE TABLE `cost` (
  `cost_id` decimal(4,0) NOT NULL,
  `name` varchar(50) NOT NULL,
  `base_duration` decimal(11,0) DEFAULT NULL,
  `base_cost` decimal(7,2) DEFAULT NULL,
  `unit_cost` decimal(7,4) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `descr` varchar(100) DEFAULT NULL,
  `creatime` datetime DEFAULT CURRENT_TIMESTAMP,
  `startime` datetime DEFAULT NULL,
  `cost_type` char(1) DEFAULT NULL,
  PRIMARY KEY (`cost_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `cost` */

insert  into `cost`(`cost_id`,`name`,`base_duration`,`base_cost`,`unit_cost`,`status`,`descr`,`creatime`,`startime`,`cost_type`) values 
(1,'5.9元套餐',20,5.90,0.4000,'0','5.9元20小时/月,超出部分0.4元/时','2021-03-07 23:19:10',NULL,'2'),
(2,'6.9元套餐',40,6.90,0.3000,'0','6.9元40小时/月,超出部分0.3元/时','2021-03-07 23:19:10',NULL,'2'),
(3,'8.5元套餐',100,8.50,0.2000,'0','8.5元100小时/月,超出部分0.2元/时','2021-03-07 23:19:10',NULL,'2'),
(4,'10.5元套餐',200,10.50,0.1000,'0','10.5元200小时/月,超出部分0.1元/时','2021-03-07 23:19:10',NULL,'2'),
(5,'计时收费',NULL,NULL,0.5000,'0','0.5元/时,不使用不收费','2021-03-07 23:19:10',NULL,'3'),
(6,'包月',NULL,20.00,NULL,'0','每月20元,不限制使用时间','2021-03-07 23:19:10',NULL,'1');

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `DEPTNO` decimal(2,0) NOT NULL,
  `DNAME` varchar(14) DEFAULT NULL,
  `LOC` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`DEPTNO`),
  UNIQUE KEY `unique_loc` (`LOC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `dept` */

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `id` int(11) NOT NULL,
  `ename` varchar(30) DEFAULT NULL,
  `hired` date NOT NULL DEFAULT '1970-01-01',
  `separated` date NOT NULL DEFAULT '9999-12-31',
  `job` varchar(30) NOT NULL,
  `store_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
/*!50100 PARTITION BY HASH (store_id)
PARTITIONS 4 */;

/*Data for the table `emp` */

/*Table structure for table `module_info` */

DROP TABLE IF EXISTS `module_info`;

CREATE TABLE `module_info` (
  `module_id` decimal(4,0) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `module_info` */

insert  into `module_info`(`module_id`,`name`) values 
(1,'角色管理'),
(2,'管理员'),
(3,'资费管理'),
(4,'账务账号'),
(5,'业务账号'),
(6,'账单管理'),
(7,'报表');

/*Table structure for table `role_info` */

DROP TABLE IF EXISTS `role_info`;

CREATE TABLE `role_info` (
  `role_id` decimal(4,0) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `role_info` */

insert  into `role_info`(`role_id`,`name`) values 
(100,'管理员'),
(200,'营业员'),
(300,'经理'),
(400,'aaa'),
(500,'bbb'),
(600,'ccc');

/*Table structure for table `role_module` */

DROP TABLE IF EXISTS `role_module`;

CREATE TABLE `role_module` (
  `role_id` decimal(4,0) NOT NULL,
  `module_id` decimal(4,0) NOT NULL,
  PRIMARY KEY (`role_id`,`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `role_module` */

insert  into `role_module`(`role_id`,`module_id`) values 
(100,1),
(100,2),
(200,3),
(200,4),
(200,5),
(200,6),
(300,7);

/*Table structure for table `service` */

DROP TABLE IF EXISTS `service`;

CREATE TABLE `service` (
  `service_id` decimal(10,0) NOT NULL,
  `account_id` decimal(9,0) NOT NULL,
  `unix_host` varchar(15) NOT NULL,
  `os_username` varchar(8) NOT NULL,
  `login_passwd` varchar(30) NOT NULL,
  `status` char(1) DEFAULT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `pause_date` datetime DEFAULT NULL,
  `close_date` datetime DEFAULT NULL,
  `cost_id` decimal(4,0) NOT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `service` */

insert  into `service`(`service_id`,`account_id`,`unix_host`,`os_username`,`login_passwd`,`status`,`create_date`,`pause_date`,`close_date`,`cost_id`) values 
(2001,1010,'192.168.0.26','guojing','guo1234','0','2021-03-07 23:59:02',NULL,NULL,1),
(2002,1011,'192.168.0.26','huangr','huang234','0','2021-03-07 23:59:02',NULL,NULL,1),
(2003,1011,'192.168.0.20','huangr','huang234','0','2021-03-07 23:59:02',NULL,NULL,3),
(2004,1011,'192.168.0.23','huangr','huang234','0','2021-03-07 23:59:02',NULL,NULL,6),
(2005,1019,'192.168.0.26','luwsh','luwu2345','0','2021-03-07 23:59:02',NULL,NULL,4),
(2006,1019,'192.168.0.20','luwsh','luwu2345','0','2021-03-07 23:59:02',NULL,NULL,5),
(2007,1020,'192.168.0.20','weixb','wei12345','0','2021-03-07 23:59:02',NULL,NULL,6),
(2008,1010,'192.168.0.20','guojing','guo09876','0','2021-03-07 23:59:02',NULL,NULL,6);

/*Table structure for table `service_update_bak` */

DROP TABLE IF EXISTS `service_update_bak`;

CREATE TABLE `service_update_bak` (
  `ID` decimal(10,0) NOT NULL,
  `SERVICE_ID` decimal(9,0) NOT NULL,
  `COST_ID` decimal(4,0) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `service_update_bak` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
