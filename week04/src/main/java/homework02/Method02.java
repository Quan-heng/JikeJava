package homework02;

import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static homework02.commons.sum;

public class Method02 {
    private static Callable<Integer> callable = () -> sum();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        try {
            new Thread(futureTask).start();
            int result = futureTask.get();
            System.out.println("异步计算结果为：" + result);
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
