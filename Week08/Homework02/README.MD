### Homework2
> 数据库用的mysql-5.7 docker境像，用mysql-8.0.25 mybatis连接会报错
1. sharding-proxy配置
  - config-sharding.yaml
```
schemaName: sharding_db
dataSources:
  ds_0:
    url: jdbc:mysql://127.0.0.1:3316/jk_db_0?serverTimezone=UTC&useSSL=false
    username: root
    password: 123456
    connectionTimeoutMilliseconds: 30000
    idleTimeoutMilliseconds: 60000
    maxLifetimeMilliseconds: 1800000
    maxPoolSize: 50
  ds_1:
    url: jdbc:mysql://127.0.0.1:3316/jk_db_1?serverTimezone=UTC&useSSL=false
    username: root
    password: 123456
    connectionTimeoutMilliseconds: 30000
    idleTimeoutMilliseconds: 60000
    maxLifetimeMilliseconds: 1800000
    maxPoolSize: 50

shardingRule:
  tables:
    t_order:
      actualDataNodes: ds_${0..1}.t_order_${0..15}
      tableStrategy:
        inline:
          shardingColumn: id
          algorithmExpression: t_order_${id % 16}
      keyGenerator:
        type: SNOWFLAKE
        column: id
#    t_order_item:
#      actualDataNodes: ds_${0..1}.t_order_item_${0..15}
#      tableStrategy:
#        inline:
#          shardingColumn: order_id
#          algorithmExpression: t_order_item_${order_id % 16}
#      keyGenerator:
#        type: SNOWFLAKE
#        column: order_item_id
  bindingTables:
    - t_order
  defaultDatabaseStrategy:
    inline:
      shardingColumn: user_id
      algorithmExpression: ds_${user_id % 2}
  defaultTableStrategy:
    none:

```
  - server.yaml
```
authentication:
  users:
    root:
      password: root
#    sharding:
#      password: sharding
#      authorizedSchemas: sharding_db

props:
  max.connections.size.per.query: 1
  acceptor.size: 16  # The default value is available processors count * 2.
  executor.size: 16  # Infinite by default.
  proxy.frontend.flush.threshold: 128  # The default value is 128.
    # LOCAL: Proxy will run with LOCAL transaction.
    # XA: Proxy will run with XA transaction.
    # BASE: Proxy will run with B.A.S.E transaction.
  proxy.transaction.type: LOCAL
  proxy.opentracing.enabled: false
  proxy.hint.enabled: false
  query.with.cipher.column: false
  sql.show: true
  allow.range.query.with.inline.sharding: false
```
2. [sql](https://github.com/Quan-heng/JikeJava/blob/master/Week08/Homework02/src/main/resources/sql/init.sql)
3. [测试代码](https://github.com/Quan-heng/JikeJava/blob/master/Week08/Homework02/src/test/java/com/example/homework02/Homework2ApplicationTests.java)

### Homework06