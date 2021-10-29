package com.quan.redis.lock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;

public class RedisLock {
    private static RedisLock instance;
    public static RedisLock getInstance(){
        if(instance==null){
            instance = new RedisLock();
        }
        return instance;
    }
    private JedisPool jedisPool = new JedisPool();
    public boolean lock(String lockValue,int seconds){
        try(Jedis jedis = jedisPool.getResource()){
            return "OK".equals(jedis.set(lockValue,lockValue,"NX","EX",seconds));
        }
    }

    public boolean release(String lock){
        String luaScript = "if redis.call('get',KEYS[1])==ARGV[1] then "+"return redis.call('del',KEYS[1]) else return 0 end";
        try(Jedis jedis=jedisPool.getResource()){
            return jedis.eval(luaScript, Collections.singletonList(lock),Collections.singletonList(lock)).equals(1l);
        }
    }
}
