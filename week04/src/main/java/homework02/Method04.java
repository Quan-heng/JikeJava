package homework02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static homework02.commons.sum;

public class Method04 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try{
            long start = System.currentTimeMillis();
            Future<Integer> future = executorService.submit(()-> sum());
            System.out.println("异步计算结果为：" + future.get());
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
            executorService.shutdown();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
