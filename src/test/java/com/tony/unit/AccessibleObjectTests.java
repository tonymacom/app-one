package com.tony.unit;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/1/17
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class AccessibleObjectTests {

    /**
     * 静态内部类
     */
    static class Student {
        private Integer id;
        private String name;

        private Student(){}

        private Student(Integer id){this.id = id;}

        private void getPoint(){
            System.out.println("100分");
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return id + "," + name;
        }
    }

    /**
     * 验证成员变量默认的override值为false, 与成员变量的修饰符(public,private,protected)无关
     */
    @Test
    public void validTest() throws Exception{
        //构造方法
        Constructor<Student> constructor = Student.class.getDeclaredConstructor();
        Assert.assertEquals(false,constructor.isAccessible());

        //验证public修饰的toString方法
        Method method = Student.class.getDeclaredMethod("toString");
        Assert.assertEquals(false,method.isAccessible());

        //由于检查后默认构造方法为private,所以使用newInstance调用时会抛出异常
        constructor.newInstance();

    }


    /**
     * 验证调用setAccessible(true) 后, private修饰的方法也可以被调用成功
     * @throws Exception
     */
    @Test
    public void test() throws Exception{
        // 验证无参构造方法在
        Constructor<Student> constructor = Student.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Student stu = constructor.newInstance();
        stu.setId(1);
        stu.setName("tony.ma");
        System.out.println(stu.toString());

        //获取有一个参数的构造方法
        Constructor<Student> constructor2 = Student.class.getDeclaredConstructor(new Class[]{Integer.class});
        constructor2.setAccessible(true);
        Student stu2 = constructor2.newInstance(2);
        stu2.setName("tony.ma2");
        System.out.println(stu2.toString());

        //私有自定义方法也可以被调用
        Method method = Student.class.getDeclaredMethod("getPoint");
        method.setAccessible(true);
        method.invoke(stu2);
    }


}
