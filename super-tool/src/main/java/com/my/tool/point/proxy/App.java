package com.my.tool.point.proxy;

/**
 * Created by lilianga on 2018/11/27.
 */
public class App {
    //测试类
    public static void main(String[] args) {
/*        //目标对象
        UserDao target = new UserDao();
        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();//执行的是代理的方法*/

/*        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());
        // 执行方法   【代理对象】
        proxy.save();*/

        //目标对象
        UserDao target = new UserDao();
        //代理对象
        UserDao proxy = (UserDao)new CglibProxyFactory(target).getProxyInstance();
        //执行代理对象的方法
        proxy.save();

    }
}
