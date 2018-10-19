package com.tony.unit;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <br>
 * <b>功能：</b><br>
 * <b>作者：</b>www.yamibuy.com<br>
 * <b>日期：</b> 2018/10/16 <br>
 * <b>版权所有：</b>版权所有(C) 2016，www.yamibuy.com<br>
 */
public class HashMapTest {


    public static void main(String[] args) {

        Student s1 = Student.builder().id(1).age(1).name("tony1").build();
        Student s2 = Student.builder().id(2).age(1).name("tony2").build();
        Student s3 = Student.builder().id(3).age(2).name("tony3").build();

        HashMap map = new HashMap();
        ConcurrentHashMap map2 = new ConcurrentHashMap<>();

        map.put(s1,s1.getName());
        map.put(s2,s2.getName());
        map.put(s3,s3.getName());


        System.out.println(map.size());

    }

}

@Data
@Builder
class Student{

    int id;
    int age;
    String name;

    public int hashCode(){
        return age;
    }

}
