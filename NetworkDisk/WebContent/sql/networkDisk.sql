USE network_disk;

/*如果存在则删除表*/
DROP TABLE IF EXISTS sharedFile;
/*创建共享文件表，sharedFile*/
CREATE TABLE sharedFile(
	sid INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '共享ID',
	fileName VARCHAR(50) NOT NULL COMMENT '文件名',
	filePath VARCHAR(100) NOT NULL COMMENT '文件路径',
	fileType VARCHAR(50) NOT NULL COMMENT '文件类型',
	loginName VARCHAR(50) NOT NULL COMMENT '共享者',
	sharedTime VARCHAR(100) NOT NULL COMMENT '共享截止日期',
	sCreateTime VARCHAR(100) NOT NULL COMMENT '共享创建日期',
	sTimeStamp TIMESTAMP)DEFAULT CHARSET=utf8;

/*插入共享文件*/
INSERT INTO sharedFile(randomFileName,fileName,filePath,fileType,loginName,sharedTime,sCreateTime) 
VALUE('201810311954','自定义注解','download/mp4/','.mp4','zhangsan','2018年11月08日','2018年11月01日');

INSERT INTO sharedFile(randomFileName,fileName,filePath,fileType,loginName,sharedTime,sCreateTime) 
VALUE('201810311953','讲真','download/mp3/','.mp3','zhangsan','2018年11月08日','2018年11月01日');

INSERT INTO sharedFile(randomFileName,fileName,filePath,fileType,loginName,sharedTime,sCreateTime) 
VALUE('201810311951','轮播图','download/image/jpg/','.jpg','zhangsan','2018年11月08日','2018年11月01日');

INSERT INTO sharedFile(randomFileName,fileName,filePath,fileType,loginName,sharedTime,sCreateTime) 
VALUE('201810311952','logon图标','download/image/png/','.png','zhangsan','2018年11月08日','2018年11月01日');

INSERT INTO sharedFile(randomFileName,fileName,filePath,fileType,loginName,sharedTime,sCreateTime) 
VALUE('201810311950','表格文件Test','download/excel/','.xlsx','zhangsan','2018年11月08日','2018年11月01日');

INSERT INTO sharedFile(randomFileName,fileName,filePath,fileType,loginName,sharedTime,sCreateTime) 
VALUE('201811011955','英语文本English123','download/other/','.txt','zhangsan','2018年11月08日','2018年11月01日');

INSERT INTO sharedFile(randomFileName,fileName,filePath,fileType,loginName,sharedTime,sCreateTime) 
VALUE('201811021963','活动策划','download/word/','.docx','zhangsan','2018年11月08日','2018年11月01日');

/*查询 共享文件列表*/
SELECT * FROM sharedFile;
SELECT * FROM sharedFile LIMIT 0,5;
SELECT COUNT(*) FROM sharedfile;
/*删除共享路径*/
DELETE FROM sharedFile WHERE sid=1;
/*向指定列添加字段*/
ALTER TABLE sharedfile ADD COLUMN randomFileName VARCHAR(100) UNIQUE AFTER sid;