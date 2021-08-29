package homework02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static homework02.commons.sum;

public class Method05  {
    private int result;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future=executorService.submit(()->sum());
        try {
            System.out.println("异步计算结果为：" + future.get());
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        executorService.shutdown();

    }
}
