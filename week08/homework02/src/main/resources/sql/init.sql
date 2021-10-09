#分库
create schema jk_db_0;
create schema jk_db_1;

#分表
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_0
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_1
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_2
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_3
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_4
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_5
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_6
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_7
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_8
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_9
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_10
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_11
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_12
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_13
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_14
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_0.t_order_15
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS jk_db_1.t_order_0
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_1
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_2
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_3
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_4
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_5
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_6
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_7
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_8
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_9
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_10
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_11
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_12
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_13
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_14
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS jk_db_1.t_order_15
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    user_id     INT    NOT NULL,
    status      VARCHAR(50),
    create_time bigint(20),
    update_time bigint(20),
    PRIMARY KEY (id)
);