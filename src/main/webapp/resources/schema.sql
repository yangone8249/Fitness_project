//외래키는 나중에 적용예정 참고!!!

create database finalproject;

-- 2023-08-23
create table user(
user_num int auto_increment,
user_email varchar(100) not null,
user_pw varchar(100) not null,
user_reg_date datetime default now(),
primary key(user_num));

alter table user add mail_auth int default 0;

alter table user add mail_key varchar(50);