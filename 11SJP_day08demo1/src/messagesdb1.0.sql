
CREATE  TABLE  users(
   id  INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(50) NOT NULL,
   loginName  VARCHAR(20) NOT NULL,
   PASSWORD  VARCHAR(100),
   sex  CHAR(2) DEFAULT '男',
   birthday  TIMESTAMP,
   email TEXT
) DEFAULT CHARSET utf8;

/*数据库插入数据*/
INSERT INTO users(username,loginName,PASSWORD,sex,birthday,email) VALUE('管理员','admin','admin','男','2018-10-15','101@qq.com');

INSERT INTO users(username,loginName,PASSWORD,sex,birthday,email) VALUE('管理员101','admin','101','男','2018-10-16','fdfad@qq.comxd');

/*删除表中的记录*/
DELETE FROM users WHERE loginName='admin';
/*查询*/
SELECT * FROM users;

SELECT * FROM  users WHERE  loginName='admin' AND PASSWORD='admin';

/*设置数据库编码*/
SHOW VARIABLES LIKE '%char%';

SHOW DATABASES;
USE web_test;
/*判断表是否存在，并删除表*/
DROP TABLE IF EXISTS luser; 
 
/*创建留言用户表*/
CREATE TABLE luser(
uid INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL UNIQUE,
uloginName VARCHAR(20) NOT NULL UNIQUE,
upassword VARCHAR(100),
usex CHAR(2),
ubirthday DATE,
uemail TEXT,
ucreateTime TIMESTAMP
)DEFAULT CHARSET utf8;

DROP TABLE IF EXISTS leaveWord;/*删除存在的表*/
/*创建留言信息表*/
CREATE TABLE leaveWord(
wid INT AUTO_INCREMENT PRIMARY KEY,
wleaveWord VARCHAR(200) NOT NULL,
wtime TIMESTAMP,
uid INT,
FOREIGN KEY (wid) REFERENCES luser(uid)
)DEFAULT CHARSET utf8;

/*建立留言信息关系表*/
CREATE TABLE leaveWord(
wid INT AUTO_INCREMENT PRIMARY KEY,
wleaveWord TEXT NOT NULL,
fk_uloginName VARCHAR(20),
wtime DATE,
FOREIGN KEY (fk_uloginName) REFERENCES luser(uloginName)
)DEFAULT CHARSET utf8;
/*查询*/
SELECT * FROM luser;
SELECT * FROM leaveWord;
/*分页查询*/
SELECT * FROM leaveWord ORDER BY wtime DESC LIMIT 0,2;
/*查询记录总数*/
SELECT COUNT(2) FROM leaveword;

SELECT * FROM luser WHERE uloginName='zhangsan' AND upassword=('zhangsan');

INSERT INTO luser(username,uloginName,upassword,usex,ubirthday,uemail) VALUE('王五','wangwu','wangwu','男','2018-10-18','wu@qq.com');
INSERT INTO leaveWord(wleaveWord,fk_uloginName,wtime) VALUE('天文','wang','2018-10-18');

/*模糊查询*/
SELECT * FROM luser WHERE uloginName LIKE '%a%';

/*修改用户信息*/
UPDATE luser SET usex='女',uemail='111@qq.com' WHERE uloginName='zhangsan';

/*删除无作用的列*/
ALTER TABLE leaveWord DROP COLUMN fk_uloginName;
ALTER TABLE leaveWord ADD COLUMN fk_uloginName VARCHAR(20) AFTER wleaveWord;
/*添加外键*/
ALTER TABLE leaveWord ADD fk_uloginName FOREIGN KEY (wloginName) REFERENCES luser(uloginName);