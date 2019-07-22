package com.my.tool.point.java8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ParallelHelper {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void Execute(IMyParallel... parallelFunc) {
        if (parallelFunc == null || parallelFunc.length == 0) {
            return;
        }

        try {
            doTask(executorService, parallelFunc);
            System.out.println("doTask finish");
        } catch (Throwable ex) {

        }
    }

    private static void doTask(ExecutorService executorService, IMyParallel[] parallelFunc) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(parallelFunc.length);

        for (IMyParallel item : parallelFunc) {
            executorService.execute(() -> {
                try {
                    item.gogogo();
                    System.out.println(Thread.currentThread().getName()+" item.gogogo();");
                } catch (Throwable ex) {

                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
    }

    public interface IMyParallel {
        void gogogo();
    }

}
