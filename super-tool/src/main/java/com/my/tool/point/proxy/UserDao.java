package com.my.tool.point.proxy;

/**
 * Created by lilianga on 2018/11/27.
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
