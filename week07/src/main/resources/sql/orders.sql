drop table if exists orders;
create table orders
(
    id          bigint(20) auto_increment not null,
    user_id     bigint(20),
    create_time bigint(20),
    update_time bigint(20),
    name        varchar(250),
    primary key (id)
) ENGINE = InnoDB DEFAULT charset = utf8mb4;