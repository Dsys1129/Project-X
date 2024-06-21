create table if not exists user
(
    id   bigint auto_increment,
    user_id varchar(30) not null,
    password varchar(255) not null,
    name varchar(30) not null ,
    email varchar(30) not null ,
    created_at datetime,
    updated_at datetime,
    constraint user_pk primary key (id)
    );

create table if not exists exploration_log
(
    id   bigint auto_increment,
    title varchar(100) not null,
    body text not null,
    createdBy varchar(30) not null ,
    updated_by varchar(50),
    created_at datetime,
    updated_at datetime,
    constraint exploration_log_pk primary key (id)
    );