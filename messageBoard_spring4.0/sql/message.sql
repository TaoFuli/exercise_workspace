-- 使用igeekhome'
-- use  `igeekhome`;

-- 创建数据库
CREATE DATABASE messageBoard_db CHARACTER SET UTF8;
USE messageBoard_db;

-- 先删除从表
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS users;

-- 创建表
-- 用户表
CREATE TABLE  users(
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
  username VARCHAR(20) COMMENT '姓名',
  loginName VARCHAR(20) UNIQUE COMMENT '登录名',
  `password` VARCHAR(50) COMMENT '密码',
  email VARCHAR(100)  DEFAULT 'xxx@igeekhome.com'  COMMENT '邮箱',
  writerName VARCHAR(400) DEFAULT '该用户比较懒，什么也没有留下。' COMMENT '签名'
) DEFAULT CHARSET utf8;

-- 留言表
CREATE TABLE message(
 id INT AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
 publishTime TIMESTAMP COMMENT '发布时间',
 context TEXT COMMENT '发布内容',
 author_id INT,
 CONSTRAINT users_id_FK  FOREIGN KEY(author_id) REFERENCES users(id)
)DEFAULT CHARSET utf8;

-- 插入测试数据
INSERT INTO users(username,loginname,`password`)
VALUES('张三','san',PASSWORD('123'))
,('李四','lisi',PASSWORD('123'))
,('王五','wangwu',PASSWORD('123'));

SELECT * FROM users;
SELECT * FROM message;

INSERT INTO message(author_id,context) 
VALUES(1,'我是张三，全国知名度最高'),
(2,'我是李四，呵呵'),
(3,'我是王五，隔壁都值得'),
(1,'Test'),
(1,'灌水'),
(2,'哈哈哈哈哈'),
(2,'哈哈哈哈哈'),
(3,'阿萨德发水电费'),
(3,'才才踩踩踩'),
(2,'啊啊啊啊'),
(1,'哈哈哈哈哈');

-- 关联查询
SELECT 
 m.`id` msgid,
 m.`publishTime` publishTime,
 m.`context` context,
 u.`id` userid,
 u.`username` username,
 u.`loginName` loginName,
 u.`writerName`  writerName
FROM message m 
INNER JOIN users u ON m.`author_id` = u.`id`;

-- 分页
SELECT 
 m.`id` msgid,
 m.`publishTime` publishTime,
 m.`context` context,
 u.`id` userid,
 u.`username` username,
 u.`loginName` loginName,
 u.`writerName`  writerName
FROM message m 
INNER JOIN users u ON m.`author_id` = u.`id` ORDER BY m.`publishTime` DESC  LIMIT 3,3;

-- 登录
SELECT * FROM users WHERE loginName = 'san' AND `password`=PASSWORD('123');

-- 注册
INSERT INTO users(username,loginname,`password`,email,writerName) 
VALUES('张三','san',PASSWORD('123'),'xxx@xx.com','sssss')

-- 发布
INSERT INTO message(author_id,context) VALUES(1,'我是张三，全国知名度最高')

-- 修改
UPDATE message SET  context='' WHERE id = 1

-- 查询数量
SELECT COUNT(1) FROM message;



SELECT id,publishTime,context,author_id authorId FROM message;

SELECT * FROM users WHERE id = 1;

