package com.quan.redis.lock;

public class LockTest {
    private final static String LOCK = "redis_lock";
    private final static int EXPIRE=3;
    private static int amount = 10;
    public static void main(String[] args) {
        Thread thread1 = new Thread(LockTest::lockTest);
        Thread thread2 = new Thread(LockTest::lockTest);
        Thread thread3 = new Thread(LockTest::lockTest);
        Thread thread4 = new Thread(LockTest::lockTest);
        thread1.start();
        thread2.start();
        thread3.start();;
        thread4.start();
        System.out.println(amount);

    }

    public static void lockTest(){
        if(!RedisLock.getInstance().lock(LOCK,EXPIRE)){
            System.out.println("获取锁失败");
            return;
        }

        try{
            Thread.sleep(10000);
            amount-=1;
            System.out.println("当前库存:"+amount);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        RedisLock.getInstance().release(LOCK);
        System.out.println("lock release");
    }

}
