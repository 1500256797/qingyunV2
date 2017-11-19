#创建数据库 qingyu_db
drop database if exists qingyun_db;
create database qingyun_db;

#使用数据库
use qingyun_db;

#一级类型main_types
drop table if exists main_types;
create table main_types(
  id INT (11) not null auto_increment COMMENT '主键',
  type_name VARCHAR (20) not NULL COMMENT '一级类型名',
  PRIMARY KEY (id)
)engine=innodb auto_increment=1 DEFAULT charset=utf8;
INSERT INTO main_types(id,type_name) VALUES (1,'全车'),(2,'专营'),(3,'装饰'),(4,'汽保');



#二级类型
drop table if exists little_types;
CREATE TABLE little_types(
  id INT (11) not null auto_increment,
  type_name VARCHAR (20) not NULL COMMENT '二级类型名',
  main_type int(11) NOT NULL COMMENT '一级类',
  FOREIGN KEY (main_type) REFERENCES main_types(id),
  PRIMARY KEY (id)
)engine=innodb auto_increment=1 DEFAULT charset=utf8;
INSERT into little_types(id, type_name, main_type) VALUES (1,'汽保工具',4),(2,'机修设备',4),(3,'洗车店用品',4);
INSERT into little_types(id, type_name, main_type) VALUES (4,'电子/车灯',3),(5,'外装饰件',3),(6,'内饰/贴膜',3);
INSERT into little_types(id, type_name, main_type) VALUES (7,'容易损坏类',2),(8,'油品类',2),(9,'外观件类',2);
INSERT into little_types(id, type_name, main_type) VALUES (10,'欧美车系',1),(11,'日韩车系',1),(13,'国产车系',1);


#商品表
drop table if exists stuffs;
create table stuffs(
  id INT (32) not NULL  auto_increment COMMENT '主键',
  name VARCHAR (8) not null COMMENT '商品名',
  little_type INT (11) NOT NULL COMMENT '二级类型',
  PRIMARY KEY (id),
  FOREIGN KEY (little_type) REFERENCES little_types(id)
)engine=innodb auto_increment=1 DEFAULT charset=utf8;
INSERT INTO stuffs(id, name,little_type) VALUES (1,'汽保工具',1),(2,'机修设备',2),(3,'洗车店用品',3);
INSERT INTO stuffs(id, name,little_type) VALUES (4,'行车记录仪',1),(5,'电子狗',1),(6,'扶手箱',2),(7,'座垫',3);
INSERT INTO stuffs(id, name,little_type) VALUES (8,'过滤器',7),(9,'发动机机油',8),(10,'灯具',9),(11,'转向油',8);
INSERT INTO stuffs(id, name,little_type) VALUES (12,'大众',10),(13,'奥迪',10),(14,'本田',11),(15,'长安微型',13);



#商家大全表
drop table if exists sellers;
create table sellers(
  id INT (11) not null auto_increment COMMENT '主键',
  name VARCHAR (50) not NULL COMMENT '商户名',
  manager_name VARCHAR (50) not NULL COMMENT '经理',
  tel VARCHAR (16) DEFAULT NULL COMMENT '联系电话',
  phone VARCHAR (16) DEFAULT NULL COMMENT '联系电话',
  province VARCHAR (50) not NULL COMMENT '省份',
  city VARCHAR (50) not NULL COMMENT '城市',
  address VARCHAR (50) not NULL COMMENT '详细地址',
  remark varchar(500) DEFAULT NULL COMMENT '描述',
  img_url varchar(500) DEFAULT NULL COMMENT '图片文件名',
  sell_arrange VARCHAR (500) not NULL COMMENT '经营范围',
  vip INT(11) DEFAULT 1 COMMENT 'vip等级',
  PRIMARY KEY (id)
)engine=innodb auto_increment=1 DEFAULT charset=utf8;
INSERT into sellers
(id, name, manager_name,tel,phone,province,city,address,remark,img_url,sell_arrange,vip)VALUES(1, '山西车酷汽配', '张经理','02431123123','18392613114','陕西','西安','灞桥区','暂无介绍','/home/jian/Pictures/1.png','能修国内车，还能修国外的！',1);

INSERT into sellers(id, name, manager_name,tel,phone,province,city,address,remark,img_url,sell_arrange,vip) VALUES (2,'山西车酷汽配','张经理','02431123123','18392613114','陕西','西安','灞桥区','暂无介绍','/home/jian/Pictures/1.png','能修国内车，还能修国外的！',1);
INSERT into sellers(id, name, manager_name,tel,phone,province,city,address,remark,img_url,sell_arrange,vip) VALUES (3,'湖南汽配','张经理','02431123123','18392613114','山西','大同','碑林区','暂无介绍','/home/jian/Pictures/1.png','能修国内车，还能修国外的！',1);
INSERT into sellers(id, name, manager_name,tel,phone,province,city,address,remark,img_url,sell_arrange,vip) VALUES (4,'越南车酷汽配','张经理','02431123123','18392613114','湖南','焦作','高新区','暂无介绍','/home/jian/Pictures/1.png','能修国内车，还能修国外的！',1);
INSERT into sellers(id, name, manager_name,tel,phone,province,city,address,remark,img_url,sell_arrange,vip) VALUES (5,'北京车酷汽配','张经理','02431123123','18392613114','北京','四合院','32号胡同','暂无介绍','/home/jian/Pictures/1.png','能修国内车，还能修国外的！',1);



#经营表
drop table if exists seller_stuff_run;
create table seller_stuff_run(
    id INT (11) not null auto_increment,
    stuff_id INT (11) not null COMMENT '商品id',
    seller_id int (11) not NULL  COMMENT '商家id',
    PRIMARY KEY (id),
    FOREIGN KEY (seller_id) REFERENCES sellers(id),
    FOREIGN KEY (stuff_id) REFERENCES stuffs(id)
)engine=innodb auto_increment=1 DEFAULT charset=utf8;
INSERT INTO seller_stuff_run(id, stuff_id, seller_id) VALUES (1,12,2),(2,9,3);

#会员价位表
create table vip_price(
  id INT(11) not null auto_increment,
  name VARCHAR(20) NOT NULL COMMENT '等级名称',
  price INT(11) NOT NULL COMMENT '收费标准',
  PRIMARY KEY (id)
)engine=innodb auto_increment=2 DEFAULT charset=utf8;
INSERT INTO vip_price(id,name,price)VALUES (1,'普通会员',0),(2,'银牌会员',33),(3,'金牌会员',66),(4,'钻石会员',99);

#用户表
create table users(
  id INT(11) not null auto_increment COMMENT '管理员/普通用户表',
  loginname VARCHAR(20) NOT NULL ,
  password VARCHAR (16) not NULL ,
  status INT (11) not NULL DEFAULT '1',
  createdate TIMESTAMP not NULL DEFAULT CURRENT_TIMESTAMP ,
  username VARCHAR (20) DEFAULT NULL ,
  PRIMARY key(id)
) engine=innodb auto_increment=2 DEFAULT charset=utf8;
INSERT into users(id, loginname, password, status, createdate, username) VALUES (1,'admin','123456','2','2017-08-21 23:49:34','超级管理员');

