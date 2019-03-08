package com.my.tool.point.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by lilianga on 2018/11/22.
 */
public class ReflectionTest {

    /**
     * Class是一个类，封装了当前对象所对应的类的信息
     * Class是用来描述类的类
     * Class 对象只能由系统建立对象，一个类（而不是一个对象）在 JVM 中只会有一个Class实例
     *
     * @throws ClassNotFoundException
     */
    public void testClass() throws ClassNotFoundException {
        Class clazz = null;

        //1.通过类名
        clazz = Person.class;

        //2.通过对象名
        //这种方式是用在传进来一个对象，却不知道对象类型的时候使用
        Person person = new Person();
        clazz = person.getClass();
        //上面这个例子的意义不大，因为已经知道person类型是Person类，再这样写就没有必要了
        //如果传进来是一个Object类，这种做法就是应该的
        Object obj = new Person();
        clazz = obj.getClass();

        //3.通过全类名(会抛出异常)
        //一般框架开发中这种用的比较多，因为配置文件中一般配的都是全类名，通过这种方式可以得到Class实例
        String className = "com.my.tool.point.Reflection.Person";
        clazz = Class.forName(className);

        //字符串的例子
        clazz = String.class;
        clazz = "javaTest".getClass();
        clazz = Class.forName("java.lang.String");

        System.out.println();
    }

    public void testMethod() throws Exception {
        Class clazz = Class.forName("com.my.tool.point.Reflection.Person");

        //
        //1.获取方法
        //  1.1 获取取clazz对应类中的所有方法--方法数组（一）
        //     不能获取private方法,且获取从父类继承来的所有方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.print(" " + method.getName());
        }
        System.out.println();

        //
        //  1.2.获取所有方法，包括私有方法 --方法数组（二）
        //  所有声明的方法，都可以获取到，且只获取当前类的方法
        methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print(" " + method.getName());
        }
        System.out.println();

        //
        //  1.3.获取指定的方法
        //  需要参数名称和参数列表，无参则不需要写
        //  对于方法public void setName(String name) {  }
        Method method = clazz.getDeclaredMethod("setName", String.class);
        System.out.println(method);
        //  而对于方法public void setAge(int age) {  }
        method = clazz.getDeclaredMethod("setAge", Integer.class);
        System.out.println(method);
        //  这样写是获取不到的，如果方法的参数类型是int型
        //  如果方法用于反射，那么要么int类型写成Integer： public void setAge(Integer age) {  }
        //  要么获取方法的参数写成int.class

        //
        //2.执行方法
        //  invoke第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数
        Object obje = clazz.newInstance();
        method.invoke(obje, 2);

        //如果一个方法是私有方法，第三步是可以获取到的，但是这一步却不能执行
        //私有方法的执行，必须在调用invoke之前加上一句method.setAccessible（true）;
    }

    public void testField() throws Exception {
        String className = "com.my.tool.point.Reflection.Person";
        Class clazz = Class.forName(className);

        //1.获取字段
        //  1.1 获取所有字段 -- 字段数组
        //     可以获取公用和私有的所有字段，但不能获取父类字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.print(" " + field.getName());
        }
        System.out.println();

        //  1.2获取指定字段
        Field field = clazz.getDeclaredField("name");
        System.out.println(field.getName());

        Person person = new Person("ABC", 12);

        //2.使用字段
        //  2.1获取指定对象的指定字段的值
        Object val = field.get(person);
        System.out.println(val);

        //  2.2设置指定对象的指定对象Field值
        field.set(person, "DEF");
        System.out.println(person.getName());

        //  2.3如果字段是私有的，不管是读值还是写值，都必须先调用setAccessible（true）方法
        //     比如Person类中，字段name字段是公用的，age是私有的
        field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println(field.get(person));
    }

    /**
     * //创建 className 对应类的对象, 并为其 fieldName 赋值为 val
     * //Student继承自Person,age是Person类的私有字段
     */
    public void testClassField() throws Exception {
        String className = "com.my.tool.point.Reflection.Student";
        String fieldName = "age"; //可能为私有, 可能在其父类中.
        Object val = 20;

        Object obj = null;
        //1.创建className 对应类的对象
        Class clazz = Class.forName(className);
        //2.创建fieldName 对象字段的对象
        Field field = getField(clazz, fieldName);
        //3.为此对象赋值
        obj = clazz.newInstance();
        setFieldValue(obj, field, val);
        //4.获取此对象的值
        Object value = getFieldValue(obj, field);
    }

    public Object getFieldValue(Object obj, Field field) throws Exception {
        field.setAccessible(true);
        return field.get(obj);
    }

    public void setFieldValue(Object obj, Field field, Object val) throws Exception {
        field.setAccessible(true);
        field.set(obj, val);
    }

    public Field getField(Class clazz, String fieldName) throws Exception {
        Field field = null;
        for (Class clazz2 = clazz; clazz2 != Object.class; clazz2 = clazz2.getSuperclass()) {
            field = clazz2.getDeclaredField(fieldName);
        }
        return field;
    }


    public void testConstructor() throws Exception {
        String className = "com.my.tool.point.Reflection.Person";
        Class<Person> clazz = (Class<Person>) Class.forName(className);

        //1. 获取 Constructor 对象
        //   1.1 获取全部
        Constructor<Person>[] constructors = (Constructor<Person>[]) Class.forName(className).getConstructors();

        for (Constructor<Person> constructor : constructors) {
            System.out.println(constructor);
        }

        //  1.2获取某一个，需要参数列表
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //2. 调用构造器的 newInstance() 方法创建对象
        Object obj = constructor.newInstance("zhagn", 1);
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
