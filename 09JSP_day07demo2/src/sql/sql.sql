
-- 登录，查询

CREATE DATABASE igeekhome CHARACTER SET utf8;

USE igeekhome;

DROP TABLE  IF EXISTS users;

-- 创建一张表
CREATE  TABLE  users(
   id  INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(50) NOT NULL,
   loginName  VARCHAR(20) NOT NULL,
   PASSWORD  VARCHAR(100),
   sex  CHAR(2) DEFAULT '男',
   birthday  TIMESTAMP,
   email TEXT
) DEFAULT CHARSET utf8;

SELECT * FROM users;

SELECT MD5('123')
SELECT PASSWORD('123')


-- 插入测试数据
INSERT INTO users(username,loginName,PASSWORD,email) VALUES('张三','san',PASSWORD('123'),'san@igeekhome.com'); 
INSERT INTO users(username,loginName,PASSWORD,email) VALUES('李四','lisi',PASSWORD('123'),'lisi@igeekhome.com'); 
INSERT INTO users(username,loginName,PASSWORD,email) VALUES('王五','wang',PASSWORD('123'),'wang@igeekhome.com'); 
INSERT INTO users(username,loginName,PASSWORD,email) VALUES('贾六','jia',PASSWORD('123'),'jia@igeekhome.com'); 
INSERT INTO users(username,loginName,PASSWORD,email) VALUES('田七','tian',PASSWORD('123'),'tian@igeekhome.com'); 
INSERT INTO users(username,loginName,PASSWORD,email) VALUES('极客','geek',PASSWORD('123'),'geek@igeekhome.com'); 



-- 登录语句
SELECT * FROM  users WHERE  loginName = 'san' AND PASSWORD = PASSWORD('123');

-- 查询
SELECT * FROM users WHERE  username LIKE '%%';




