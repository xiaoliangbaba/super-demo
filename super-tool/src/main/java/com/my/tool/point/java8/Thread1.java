package com.my.tool.point.java8;

/**
 * Created by lilianga on 2019/7/17.
 */
public class Thread1 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}