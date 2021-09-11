drop table if exists 'goods';
create table goods
(
    id       int(11) primary key,
    name     varchar(255),
    order_id int(11),
    note     varchar(255)
);