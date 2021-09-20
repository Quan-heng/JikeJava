drop table if exists 'user';
create table user
(
    id          int(11)  primary key,
    name        varchar(255),
    create_time timestamp,
    update_time timestamp
)