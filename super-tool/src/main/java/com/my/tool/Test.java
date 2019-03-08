package com.my.tool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilianga on 2018/11/15.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0,0);
        System.out.println(list.size());
    }
}
