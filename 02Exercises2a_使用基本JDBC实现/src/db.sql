CREATE DATABASE school;

USE school;

CREATE TABLE students 
(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(10) NOT NULL
);

INSERT INTO students VALUES (NULL,'张三');

SELECT * FROM students;