--数据库初始化脚本

--创建数据库
create database seckill;
use seckill;

--1、创建秒杀库存表
create table seckill(
    seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
    name varchar (120) NOT NULL COMMENT '商品名称',
    number int NOT NULL COMMENT '库存数量',
    start_time timestamp NOT NULL COMMENT '秒杀开启时间',
    end_time timestamp NOT NULL COMMENT '秒杀结束时间',
    create_time timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (seckill_id),
    key idx_start_time(start_time),
    key idx_end_time(end_time),
    key idx_create_time(create_time)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';


--初始化数据
insert into
    seckill(name,number,start_time,end_time)
values
('1000元秒杀iphoneX',100,'2019-06-17 00:00:00','2019-06-18 00:00:00'),
('500元秒杀ipadPro',200,'2019-06-17 00:00:00','2019-06-18 00:00:00'),
('300元秒杀小米8',300,'2019-06-17 00:00:00','2019-06-18 00:00:00'),
('200元秒杀benz',400,'2019-06-17 00:00:00','2019-06-18 00:00:00');



--2、秒杀成功明细表
--用户登录认证相关信息
create table success_killed(
seckill_id bigint NOT NULL COMMENT '秒杀商品id',
user_phone bigint NOT NULL COMMENT '用户手机号',
state tinyint NOT NULL DEFAULT -1 COMMENT '状态表示：-1：无效 0：成功 1：已付款 2：已发货',
create_time timestamp NOT NULL COMMENT '创建时间',
PRIMARY KEY (seckill_id,user_phone), /*联合主键,(一个用户不能对同一产品重复秒杀*/
key idx_create_time(create_time)

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';


