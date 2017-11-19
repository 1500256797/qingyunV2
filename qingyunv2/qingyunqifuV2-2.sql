
#商家大全表
drop table if exists sellers;
create table sellers(
  id INT (11) not null auto_increment,
  name VARCHAR (50) not NULL ,
  manager_name VARCHAR (50) not NULL ,
  tel VARCHAR (16) DEFAULT NULL ,
  phone VARCHAR (16) DEFAULT NULL ,
  qq_num VARCHAR (10) DEFAULT NULL ,
  province VARCHAR (50) not NULL ,
  city VARCHAR (50) not NULL ,
  address VARCHAR (50) not NULL ,
  remark varchar(500) DEFAULT NULL ,
--   主营范围
  sell_arrange VARCHAR (500) not NULL ,
  PRIMARY KEY (id)
)engine=innodb auto_increment=1 DEFAULT charset=utf8;
INSERT into sellers(id, name, manager_name,tel,phone,qq_num,province,city,address,remark,sell_arrange) VALUES (1,'沈阳车酷汽配','张经理','02431123123','18392613114','1500256797','陕西-安康','暂无介绍','能修国内车，还能修国外的！');
INSERT into sellers(id, name, manager_name,tel,phone,qq_num,province,city,address,remark,sell_arrange) VALUES  (2,'沈阳杨宁汽配','张经理','02431123123','1232613114','1500256797','湖北-安康','暂无介绍','有易损件');
INSERT into sellers(id, name, manager_name,tel,phone,qq_num,province,city,address,remark,sell_arrange) VALUES (3,'沈阳兴业汽配','王经理','02431123123','1232613114','1500256797','湖北-安康','暂无介绍','我家卖有油品');


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

