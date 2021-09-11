drop table is exists 'orders';
create table orders
(
    id          int(11) primary,
    user_id     int(11),
    create_time timestamp,
    update_time timestamp,
    note        varchar(250)
)