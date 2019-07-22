package com.my.tool.point.java8;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lilianga on 2019/7/18.
 */
public class CountDownLatchApproach {
    public static void main(String[] args) throws IOException, InterruptedException {
        final int nThreads = 10;
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < nThreads; i++) {
            final int num = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(String.valueOf(num));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        endGate.countDown();
                    }
                }
            };
            exec.submit(task);
        }
        endGate.await();
        System.out.println("---END---\n");
    }
}
