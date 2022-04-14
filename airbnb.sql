drop database airbnb_db;
drop user airbnb_admin;
create database airbnb_db;
create user airbnb_admin with password 'password';
\connect airbnb_db;
alter default privileges grant all on tables to airbnb_admin;
alter default privileges grant all on sequences to airbnb_admin;

create table users(
user_id integer primary key not null,
first_name varchar(20) not null,
last_name varchar(20) not null,
email varchar(30) not null,
password text not null
);

create sequence users_seq increment 1 start 1;