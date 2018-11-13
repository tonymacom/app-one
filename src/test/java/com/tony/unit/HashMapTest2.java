package com.tony.unit;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/11/13
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class HashMapTest2 {

    /**
     * 测试hashmap 链表存储.
     */
    @Test
    public void testMap() {
        Country india = new Country("India", 1000);
        Country japan = new Country("Japan", 10000);
        Country france = new Country("France", 2000);
        Country russia = new Country("Russia", 20000);
        Country a = new Country("aaa", 20000);
        Country b = new Country("bbbb", 20000);

        System.out.println("india hash : "+ india.hashCode());
        System.out.println("japan hash : "+ japan.hashCode());
        System.out.println("france hash : "+ france.hashCode());
        System.out.println("russia hash : "+ russia.hashCode());

        HashMap<Country, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put(india, "Delhi");
        countryCapitalMap.put(japan, "Tokyo");
        countryCapitalMap.put(france, "france");
        countryCapitalMap.put(russia, "Moscow");
        countryCapitalMap.put(a, "aaaa");
        countryCapitalMap.put(b, "bbbb");

        /**
         * 这里打断点watches countryCapitalMap变量中的table.
         */
        Iterator<Country> countryCapitalIter = countryCapitalMap.keySet().iterator();// put debug point at this line
    }

    static class Country {
        String name;
        long population;
        public Country(String name, long population) {
            super();
            this.name = name;
            this.population = population;
        }


        /**
         * 31 与 95 会hash到table的同一个下标中去.
         * @return
         */
        @Override
        public int hashCode() {
            if (this.name.length() % 2 == 0)
                return 30;
            else
                return 95;
        }
        @Override
        public boolean equals(Object obj) {
            Country other = (Country) obj;
            if (name.equalsIgnoreCase((other.name)))
                return true;
            return false;
        }

    }


}
