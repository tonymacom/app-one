package com.tony.unit;


import lombok.Data;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <br>
 * <b>功能：</b><br>
 * <b>作者：</b>www.yamibuy.com<br>
 * <b>日期：</b> 2018/10/16 <br>
 * <b>版权所有：</b>版权所有(C) 2016，www.yamibuy.com<br>
 */
public class HashMapTest {


    /**
     * 测试自定义对象hashcode导致map中存储key值相同的元素.这种情况会导致内存溢出.
     */
    @Test
    public void testMap(){
        Person p1 = new Person("xiaoer",1);
        Person p2 = new Person("san",4);

        Map<Person,String> maps = new HashMap<Person,String>();

        maps.put(p1, "1111");
        maps.put(p2, "2222");
        System.out.println(maps);

        maps.put(p2, "333");
        System.out.println(maps);
        System.out.println(p1.hashCode());
        p1.setAge(5);
        System.out.println(maps);


        System.out.println(p1.hashCode());
        maps.put(p1, "4444");
        System.out.println(p1.hashCode());

        System.out.println(maps);
        System.out.println(maps.get(p1));

    }

    @Test
    public void testMap2(){

        HashMap<String,String> maps = new HashMap<>();

        maps.put("Aa", "1111");
        maps.put("BB", "2222");

        Iterator<Map.Entry<String, String>> entry = maps.entrySet().iterator();

        if(entry.hasNext()){
            Map.Entry<String, String> enty = entry.next();
            System.out.println(enty.getKey());
        }


        System.out.println(maps);


    }


    @Data
    public class Person {
        private String name;
        private int age;

        public Person(String name,int age) {
            this.age=age;
            this.name=name;
        }

        @Override
        public int hashCode() {
            final int prime = 33;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (getClass() != object.getClass()) {
                return false;
            }
            Person other = (Person) object;
            if (age != other.age)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "Person [name=" + name + ", age=" + age + "]";
        }


    }

}

