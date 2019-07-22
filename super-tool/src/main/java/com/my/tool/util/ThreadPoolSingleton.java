package com.my.tool.util;

import java.util.concurrent.*;

/**
 * Created by lilianga on 2019/7/18.
 */
public class ThreadPoolSingleton {
    private ExecutorService executorService;
    private final int availableProcessor = Runtime.getRuntime().availableProcessors();

    private ThreadPoolSingleton() {
        if (executorService == null) {
            int coreNum = availableProcessor / 2;

            // 用单例模式创建线程池，保留2个核心线程，最多线程为CPU个数的2n+1的两倍.
            int maxProcessor = (availableProcessor * 2 + 1) * 2;

            executorService = new ThreadPoolExecutor(coreNum > 2 ? 2 : coreNum, maxProcessor,
                    60L, TimeUnit.SECONDS,
                    new SynchronousQueue<Runnable>());
        }
    }


    private static ThreadPoolSingleton instance;

    public static ThreadPoolSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadPoolSingleton();
        }
        return instance;
    }

    int executeThreadNum = 1;

    public void executeTask(Runnable runnable) {
        executorService.execute(runnable);
        System.out.println(("ThreadPoolSingleton ," + String.format("异步线程执行了%d次。", executeThreadNum++)));
    }

    /**
     * 这个方法可根据你的需要添加
     */
    public <T> Future<T> submit(Runnable task, T result) {
        return executorService.submit(task, result);
    }

    /**
     * 这个方法可根据你的需要添加
     */
    public Future<?> submit(Runnable task) {
        return executorService.submit(task);
    }
}
