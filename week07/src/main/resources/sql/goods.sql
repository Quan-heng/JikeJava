drop table if exists goods;
create table goods
(
    id       bigint(20) not null,
    name     varchar(255),
    order_id bigint(20),
    note     varchar(255),
    primary key(id)
)