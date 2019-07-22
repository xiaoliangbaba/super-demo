package com.my.tool.point.java8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by lilianga on 2019/7/17.
 */
public class Thread_main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*        Thread1 thread1 = new Thread1();
        Thread thread = new Thread(thread1);
        thread.start();*/


/*        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("completableFuture1");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "completableFuture";
        }).thenApply(s -> {
            try {
                System.out.println("thenAccept");
                Thread.sleep(1000);
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "asd";
        });*/

        //CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFuture);

        //completableFuture.get();

/*        Future_test test= new Future_test();
        test.gogogo();*/

/*
        Future_test test1= new Future_test();
        test1.gogogo();
*/


        //System.out.println(completableFuture.get());
        System.out.println("aaaa");
        //String result = doSomething.get();
        System.out.println("bbbb");
        //System.out.println(result);

/*        ExecutorService executorService = Executors.newCachedThreadPool();
        //提交时候 线程池开始执行
        System.out.println("1主线程开始执行");
        Future<String> sFuture = executorService.submit(new TaskCallable());
        System.out.println("hhhhh");
        //Thread.sleep(10000);
        //String ResultStirng = sFuture.get();  //下面线程执行的结果
        //.out.println("2结果：" + ResultStirng);
        executorService.shutdown();*/

        /*Future future = ThreadPoolSingleton.getInstance().submit(new Thread1(),"123");
        System.out.println(future.get());*/

/*
        Account account = new Account(300);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true)
                    account.drawMoney(100);
            }).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true)
                    account.saveMoney(100);
            }).start();
        }
*/

/*        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            ParallelHelper.Execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, () -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("1111");
            return "11111";
        });
        System.out.println("wwwww");
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            ParallelHelper.Execute(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, () -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("2222");
            return "22222";
        });

        System.out.println(completableFuture.get());
        System.out.println(completableFuture1.get());*/


        System.out.println(Thread.currentThread().getName() + " over");

    }

    static class TaskCallable implements Callable<String> {  //可以返回线程结果
        @Override
        public String call() throws Exception {
            System.out.println("3正在执行任务，请等待五秒");
            Thread.sleep(5000);
            System.out.println("4执行完毕");
            return "这是返回结果";
        }

    }


}
