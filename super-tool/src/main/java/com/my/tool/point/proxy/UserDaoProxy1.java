package com.my.tool.point.proxy;

/**
 * Created by lilianga on 2018/11/27.
 */

//静态代理
public class UserDaoProxy1 implements IUserDao {
    //接收保存目标对象
    private IUserDao target;

    public UserDaoProxy1(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
