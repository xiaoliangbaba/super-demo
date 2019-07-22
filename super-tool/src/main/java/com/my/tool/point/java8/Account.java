package com.my.tool.point.java8;

/**
 * Created by lilianga on 2019/7/18.
 */
public class Account {

    public Account(int money) {
        this.money = money;
    }

    private int money;

    public synchronized void drawMoney(int m) {
        System.out.println(Thread.currentThread().getName() + "准备取钱，账户余额:" + money);
        while (money - m < 0) {
            System.out.println("余额不足");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "drawMoney notifyAll");
                //notifyAll();
            }
        }
        money = this.money - m;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + "取走" + m + "元，账户余额：" + money);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void saveMoney(int m) {
        System.out.println(Thread.currentThread().getName() + "准备存钱，账户余额:" + money);
        money = this.money + m;
        System.out.println(Thread.currentThread().getName() + "存入" + m + "元，账户余额：" + money);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "saveMoney notifyAll");
            notifyAll();
        }
        //notifyAll();
    }
}
