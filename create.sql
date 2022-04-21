drop database airbnb_db;
drop user airbnb_admin;
create database airbnb_db;
create user airbnb_admin with password 'password';
\connect airbnb_db;
alter default privileges grant all on tables to airbnb_admin;
alter default privileges grant all on sequences to airbnb_admin;
