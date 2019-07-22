package com.my.tool.point.java8;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by lilianga on 2019/7/16.
 */
public class Function_main {

    //连接器
    private static final Joiner JOINER = Joiner.on(",").skipNulls();
    //分割器
    private static final Splitter SPLITTER = Splitter.on(",").trimResults().omitEmptyStrings();

    public static void main(String[] args) {
        //function
        Function<Integer, String> function = new Function<Integer, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Integer integer) {
                return integer + "";
            }
        };

        String s = function.apply(123);

        String join = Joiner.on(",").skipNulls().join(Lists.newArrayList("a", null, "b"));
        System.out.println(join);

        for (String tmp : SPLITTER.split(" a,  ,b ,,")) {
            System.out.print("|" + tmp + "|");
        }
        System.out.println();
        System.out.println(Ints.join(",", 1, 2, 3, 4));

        //Immutable
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("name", "liliang", "sex", "man");
        //immutableMap.put("wife", "no");//UnsupportedOperationException

        List<String> shortFeature = JSONArray.parseArray("", String.class);
        System.out.println(JSONArray.parseArray("[]", String.class).size());

        System.out.println(isJson("sss"));
    }

    public static boolean isJson(String content) {
        try {
            JSON.parse(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
