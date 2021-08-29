package homework02;

import static homework02.commons.sum;

public class Method01 extends Thread {
    private int result;
    public void run() {
        result = sum();
    }

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Method01 thread = new Method01();
        thread.start();
        thread.join();
        System.out.println("异步计算结果为："+thread.result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
