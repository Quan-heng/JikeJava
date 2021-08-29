package homework02;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static homework02.commons.sum;

public class Method03 {
    private static class Thread03 implements Callable<Integer>{
        @Override
        public Integer call() {
            return sum();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread03 thread03 = new Thread03();
        FutureTask<Integer> futureTask = new FutureTask<>(thread03);
        new Thread(futureTask).start();
        try{
        System.out.println("异步计算结果为：" + futureTask.get());
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");}
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
