#创建数据库 qingyu_db2
drop database if exists qingyun_db2;
create database qingyun_db2;

#使用数据库
use qingyun_db2;

#创建三四个主类型 main_types
drop table if exists main_types;
create table main_types(
  id INT (11) not null auto_increment,
  type_name VARCHAR (20) not NULL ,
  PRIMARY KEY (id)
)engine=innodb auto_increment=1 DEFAULT charset=utf8;
INSERT INTO main_types(id,type_name) VALUES (1,'全车'),(2,'专营'),(3,'装饰'),(4,'汽保');



#大类下面的小类别 little_types
drop table if exists little_types;
CREATE TABLE little_types(
  id INT (11) not null auto_increment,
  type_name VARCHAR (20) not NULL ,
  main_type int(11) NOT NULL ,
  FOREIGN KEY (main_type) REFERENCES main_types(id),
  PRIMARY KEY (id)
)engine=innodb auto_increment=1 DEFAULT charset=utf8;
INSERT into little_types(id, type_name, main_type) VALUES (1,'汽保工具',4),(2,'机修设备',4),(3,'洗车店用品',4);
INSERT into little_types(id, type_name, main_type) VALUES (4,'电子/车灯',3),(5,'外装饰件',3),(6,'内饰/贴膜',3);
INSERT into little_types(id, type_name, main_type) VALUES (7,'容易损坏类',2),(8,'油品类',2),(9,'外观件类',2);
INSERT into little_types(id, type_name, main_type) VALUES (10,'欧美车系',1),(11,'日韩车系',1),(13,'国产车系',1);


#商品大全表
drop table if exists stuffs;
create table stuffs(
  id INT (32) not NULL  auto_increment,
  name VARCHAR (8) not null,
  little_type INT (11) NOT NULL ,
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
  id INT (11) not null auto_increment,
  name VARCHAR (50) not NULL ,
  manager_name VARCHAR (50) not NULL ,
  tel VARCHAR (16) DEFAULT NULL ,
  phone VARCHAR (16) DEFAULT NULL ,
  qq_num VARCHAR (10) DEFAULT NULL ,
  address VARCHAR (50) not NULL ,
  remark varchar(500) DEFAULT NULL ,
--   主营范围
  sell_arrange VARCHAR (500) not NULL ,
  PRIMARY KEY (id)
)engine=innodb auto_increment=1 DEFAULT charset=utf8;
INSERT into sellers(id, name, manager_name,tel,phone,qq_num,address,remark,sell_arrange) VALUES (1,'沈阳车酷汽配','张经理','02431123123','18392613114','1500256797','陕西-安康','暂无介绍','能修国内车，还能修国外的！');
INSERT into sellers(id, name, manager_name,tel,phone,qq_num,address,remark,sell_arrange) VALUES  (2,'沈阳杨宁汽配','张经理','02431123123','1232613114','1500256797','湖北-安康','暂无介绍','有易损件');
INSERT into sellers(id, name, manager_name,tel,phone,qq_num,address,remark,sell_arrange) VALUES (3,'沈阳兴业汽配','王经理','02431123123','1232613114','1500256797','湖北-安康','暂无介绍','我家卖有油品');


#商家商品经营表
drop table if exists seller_stuff_run;
create table seller_stuff_run(
    id INT (11) not null auto_increment,
    stuff_id INT (11) not null,
    seller_id int (11) not NULL ,
    PRIMARY KEY (id),
    FOREIGN KEY (seller_id) REFERENCES sellers(id),
    FOREIGN KEY (stuff_id) REFERENCES stuffs(id)
)engine=innodb auto_increment=1 DEFAULT charset=utf8;
INSERT INTO seller_stuff_run(id, stuff_id, seller_id) VALUES (1,12,2),(2,9,3);


#普通用户表
create table users(
  id INT(11) not null auto_increment,
  loginname VARCHAR(20) NOT NULL ,
  password VARCHAR (16) not NULL ,
  status INT (11) not NULL DEFAULT '1',
  createdate TIMESTAMP not NULL DEFAULT CURRENT_TIMESTAMP ,
  username VARCHAR (20) DEFAULT NULL ,
  PRIMARY key(id)
) engine=innodb auto_increment=2 DEFAULT charset=utf8;
INSERT into users(id, loginname, password, status, createdate, username) VALUES (1,'admin','123456','2','2017-08-21 23:49:34','超级管理员');

