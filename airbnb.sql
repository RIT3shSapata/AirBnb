drop database airbnb_db;
drop user airbnb_admin;
create database airbnb_db;
create user airbnb_admin with password 'password';
\connect airbnb_db;
alter default privileges grant all on tables to airbnb_admin;
alter default privileges grant all on sequences to airbnb_admin;

create table tenant(
    tenantID integer primary key not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(30) not null,
    password text not null,
    phoneNumber varchar(10) not null
);
create sequence tenant_seq increment 1 start 1;

create table owner(
    ownerId integer primary key not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(30) not null,
    password text not null,
    phoneNumber varchar(10) not null
);
create sequence owner_seq increment 1 start 1;

create table home(
    homeID integer primary key not null,
    ownerID integer not null,
    roomNo integer not null,
    price float not null,
    city varchar (20) not null,
    state varchar (20) not null,
    country varchar (20) not null,
    pin varchar (6) not null,
    foreign key (ownerID) references owner(ownerId)
);
create sequence home_seq increment 1 start 1;

create table availability(
    homeID integer not null,
    ownerID integer not null,
    tenantID integer not null,
    startDate Date not null,
    endDate Date not null,
    status varchar(20) not null,
    foreign key (ownerID) references owner(ownerId),
    foreign key (homeID) references home(homeID),
    foreign key (tenantID) references tenant(tenantID),
    primary key (homeID,ownerID,tenantID)
);

create table homeReview(
    homeID integer not null,
    ownerID integer not null,
    tenantID integer not null,
    rating float not null,
    review varchar(100),
    foreign key (ownerID) references owner(ownerId),
    foreign key (homeID) references home(homeID),
    foreign key (tenantID) references tenant(tenantID),
    primary key (homeID,ownerID,tenantID)
);

create table tenantReview(
    ownerID integer not null,
    tenantID integer not null,
    rating float not null,
    review varchar(100),
    foreign key (ownerID) references owner(ownerId),
    foreign key (tenantID) references tenant(tenantID),
    primary key (ownerID,tenantID)
);
