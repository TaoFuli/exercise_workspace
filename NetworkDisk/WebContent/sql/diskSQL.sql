/*
SQLyog v10.2 
MySQL - 5.5.60 : Database - network_disk
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`network_disk` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `network_disk`;

/*Table structure for table `files` */

DROP TABLE IF EXISTS `files`;

CREATE TABLE `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `filename` varchar(100) DEFAULT NULL COMMENT '文件名',
  `fileType` varchar(50) DEFAULT NULL COMMENT '文件类型',
  `fileRoad` varchar(100) DEFAULT NULL COMMENT '文件路径',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '文件创建时间',
  `author_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `users_id_FK` (`author_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `files` */

insert  into `files`(`id`,`filename`,`fileType`,`fileRoad`,`createtime`,`author_id`) values (1,'abc','.txt',NULL,'2018-10-29 18:28:43',1),(2,'x','.txt',NULL,'2018-10-29 18:28:43',2),(3,'xxx','.txt',NULL,'2018-10-29 18:28:43',3),(4,'yyyy','.txt',NULL,'2018-10-29 18:28:43',1),(5,'zzzz','.txt',NULL,'2018-10-29 18:28:43',3),(6,'tttt','.txt',NULL,'2018-10-29 18:28:43',3),(7,'hhhh','.txt',NULL,'2018-10-29 18:28:43',2),(8,'ggg','.txt',NULL,'2018-10-29 18:28:43',2),(9,'eeeee','.txt',NULL,'2018-10-29 18:28:43',1),(10,'aaa','.txt',NULL,'2018-10-29 18:28:43',1);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `loginName` varchar(100) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `relName` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`loginName`,`password`,`email`,`relName`,`sex`,`registerTime`) values (1,'张三','san','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9','san@123.com','张三','男','2018-10-29 18:28:18'),(2,'李四','lisi','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9','lisi@123.com','李四','男','2018-10-29 18:28:18'),(3,'王五','wang','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9','wang@123.com','王五','男','2018-10-29 18:28:18'),(4,'李白','li','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9','li@123.com','李白','男','2018-10-30 09:30:55'),(5,'','liu','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257','','',NULL,'2018-10-30 22:30:36'),(6,'','liu','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257','','',NULL,'2018-10-30 22:30:45'),(7,'','liu','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257','','',NULL,'2018-10-30 22:30:49'),(8,'','','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257','','',NULL,'2018-10-31 09:53:07'),(9,'','liu','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257','','',NULL,'2018-10-31 09:53:49'),(10,'老王 ','san','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9','123@wang.com','王老五','男','2018-10-31 10:00:16'),(11,'赵四','zhaosi','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9','zhaosi@123.com','赵四','男','2018-10-31 10:28:47'),(12,'刘公','liugong','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9','liu@123.com','刘工','男','2018-10-31 10:45:13'),(13,'张三','san','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9','abc@q.com','san','男','2018-10-31 11:16:45'),(14,'aaa','san','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9','abc@123.com','赵四','男','2018-10-31 11:33:28'),(15,'张八','san','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9','123@123.com','张三','男','2018-10-31 11:39:23');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
