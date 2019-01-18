package com.tony.unit;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/1/17
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class ConstructorTests {

    static class Student {
        private Integer id;
        private String name;

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
     * 正常创建
     */
    @Test
    public void normal() throws Exception{
        Student stu = Student.class.newInstance();
        stu.setId(1);
        stu.setName("tony.ma");
        System.out.println(stu.toString());
    }

    /**
     * 设置Student的私有构造方法为private
     * private Student(){}
     *
     */
    @Test
    public void unNormal() throws Exception{
        Student stu = Student.class.newInstance();
        stu.setId(1);
        stu.setName("tony.ma");
        System.out.println(stu.toString());
    }

    /**
     * 通过Constructor类的newInstance()创建对象
     * by getDeclaredConstructor()方法
     */
    @Test
    public void constructorTest() throws Exception{
        Constructor<Student> constructor = Student.class.getDeclaredConstructor();
        Student stu = constructor.newInstance();
        stu.setId(1);
        stu.setName("tony.ma");
        System.out.println(stu.toString());
    }

    /**
     * 通过Constructor类的newInstance()创建对象 by getConstructor()方法
     * 指定无参构造函数为public
     * public Student(){}
     *
     */
    @Test
    public void constructorTest2() throws Exception{
        Constructor<Student> constructor = Student.class.getConstructor();
        Student stu = constructor.newInstance();
        stu.setId(1);
        stu.setName("tony.ma");
        System.out.println(stu.toString());
    }

    /**
     * 实现Cloneable接口的类
     */
    static class Student2 implements Cloneable{
        private Integer id;
        private String name;

        @Override
        public Student2 clone() throws CloneNotSupportedException {
            return (Student2)super.clone();
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
     * 通过clone方法创建对象stu2
     * @throws Exception
     */
    @Test
    public void cloneTest() throws Exception{
        Student2 stu = new Student2();
        stu.setId(1);
        stu.setName("tony.ma");
        System.out.println(stu.toString());

        Student2 stu2 = stu.clone();
        stu2.setId(2);
        System.out.println(stu2.toString());
        System.out.println(stu.toString()); // 检查stu是否被修改, 结果是未被修改
    }


    /**
     * 序列化的类
     */
    static class Student3 implements Serializable {
        private Integer id;
        private String name;

        @Override
        public Student2 clone() throws CloneNotSupportedException {
            return (Student2)super.clone();
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
     * 序列化测试生成对象
     * @throws Exception
     */
    @Test
    public void serializableTest() throws Exception{

        Student3 stu = new Student3();
        stu.setId(1);
        stu.setName("tony.ma");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\students.txt"));

        oos.writeObject(stu);

        System.out.println("序列化完成,"+stu.toString());

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\students.txt"));
        Student3 stu2 = (Student3)ois.readObject();

        System.out.println("反序列化创建对象,"+stu2.toString());
    }


}
