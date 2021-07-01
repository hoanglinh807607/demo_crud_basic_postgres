create table account
(
    id       bigserial
        constraint account_pk
            primary key,
    username varchar(50)  not null,
    password varchar(100) not null,
    fullname varchar(50)  not null,
    phone    varchar(10)  not null,
    address  varchar(100) not null
);

create table role
(
    id   bigserial
        constraint role_pk
            primary key,
    code varchar(50) not null,
    name varchar(50) not null
);

create table account_role
(
    id         bigserial
        constraint account_role_pk
            primary key,
    account_id bigint,
    role_id    bigint
);
