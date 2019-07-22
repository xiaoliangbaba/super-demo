package com.my.tool.point.java8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lilianga on 2019/7/17.
 */
public class Future_test {

    public void gogogo() {
        ExecutorService executors = Executors.newFixedThreadPool(10);

/*        Future<String> doSomething = executors.submit(() -> {
            try {
                Thread.sleep(1000 * 3);
                System.out.println("doSomething1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                endGate.countDown();
                System.out.println("shutdown");
                executors.shutdown();
            }
            return "success";
        });*/

        CountDownLatch endGate = new CountDownLatch(9);
        for (int i = 1; i < 10; i++) {
            executors.execute(() -> {
                try {
                    Thread.sleep(1000 * 3);
                    System.out.println(Thread.currentThread().getName() + "doSomething");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    endGate.countDown();
                    System.out.println("shutdown");
                }
            });
        }


        try {
            endGate.await();
            System.out.println("executors.shutdown()");
            executors.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //doSomething.get();
    }


}
