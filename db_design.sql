
--创建四个表：S、P、J、SPJ
create table S
(
  SNO varchar(20) not null ,
  SNAME varchar(30),
  STATUS int,
  CITY varchar(30),
  primary key (SNO)
);

create table P
(
  PNO varchar(20) not null ,
  PNAME varchar(30),
  COLOR varchar(20),
  WEIGHT int,
  primary key (PNO)
);

create table J
(
  JNO varchar(20) not null ,
  JNAME varchar(30),
  CITY varchar(30),
  primary key (JNO)
);


create table SPJ
(
  SNO varchar(20) not null ,
  PNO varchar(20) not null ,
  JNO varchar(20) not null ,
  QTY int,
  foreign key (SNO) references S(SNO),
  foreign key (PNO) references P(PNO),
  FOREIGN KEY (JNO) references J(JNO)
);
--创建表结束

--将数据插入S表中
insert into s (SNO,SNAME,STATUS,CITY) values ('S1','精益',20,'天津');
insert into s (SNO,SNAME,STATUS,CITY) values ('S2','盛锡',10,'北京');
insert into s (SNO,SNAME,STATUS,CITY) values ('S3','东方红',30,'北京');
insert into s (SNO,SNAME,STATUS,CITY) values ('S4','丰泰盛',20,'天津');
insert into s (SNO,SNAME,STATUS,CITY) values ('S5','为民',30,'上海');

--将数据插入P表中
insert into P (PNO,PNAME,COLOR,WEIGHT) values ('P1','螺母','红',12);
insert into P (PNO,PNAME,COLOR,WEIGHT) values ('P2','螺栓','绿',17);
insert into P (PNO,PNAME,COLOR,WEIGHT) values ('P3','螺丝刀','蓝',14);
insert into P (PNO,PNAME,COLOR,WEIGHT) values ('P4','螺丝刀','红',14);
insert into P (PNO,PNAME,COLOR,WEIGHT) values ('P5','凸轮','蓝',40);
insert into P (PNO,PNAME,COLOR,WEIGHT) values ('P6','齿轮','红',30);


--将数据插入J表中
insert into J (JNO,JNAME,CITY) values ('J1','三建','北京');
insert into J (JNO,JNAME,CITY) values ('J2','一汽','长春');
insert into J (JNO,JNAME,CITY) values ('J3','弹簧厂','天津');
insert into J (JNO,JNAME,CITY) values ('J4','造船厂','天津');
insert into J (JNO,JNAME,CITY) values ('J5','机车厂','唐山');
insert into J (JNO,JNAME,CITY) values ('J6','无线电厂','常州');
insert into J (JNO,JNAME,CITY) values ('J7','半导体厂','南京');

--将数据插入SPJ表中
insert into SPJ (SNO,PNO,JNO,QTY) values ('S1','P1','J1',200);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S1','P1','J3',100);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S1','P1','J4',700);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S1','P2','J2',100);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S2','P3','J1',400);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S2','P3','J2',200);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S2','P3','J4',500);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S2','P3','J5',400);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S2','P5','J1',400);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S2','P5','J2',100);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S3','P1','J1',200);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S3','P3','J1',200);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S4','P6','J3',300);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S4','P6','J4',200);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S5','P2','J4',100);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S5','P3','J1',200);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S5','P6','J2',200);
insert into SPJ (SNO,PNO,JNO,QTY) values ('S5','P6','J4',500);
