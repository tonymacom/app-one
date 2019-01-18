package com.tony.unit;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.junit.Test;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/1/17
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class JSONandGson {

    /**
     * 静态内部类
     */
    static class Student {
        private Integer id;
        private String name;

        private Student(){}

        public Student(Integer id, String name){
            this.id = id;
            this.name = name;
        }

        public void setId(Integer id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return id + "," + name;
        }
    }

    /**
     * json转换测试
     */
    @Test
    public void test(){
        Student stu = new Student(1,"tony.ma");
        String stuStr = JSON.toJSONString(stu);

        Student stu2 =   JSON.parseObject(stuStr,Student.class);
        System.out.println(stu2.toString());

    }

    /**
     * gson转换测试
     */
    @Test
    public void test2(){
        Student stu = new Student(1,"tony.ma");
        String stuStr = JSON.toJSONString(stu);
        System.out.println(stuStr);

        Student stu2 =   new Gson().fromJson(stuStr,Student.class);
        System.out.println(stu2.toString());

    }


}
