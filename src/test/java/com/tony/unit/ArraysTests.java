package com.tony.unit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/18
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class ArraysTests {

    /**
     * Arrays.asList(..)返回的是ArrayList的一个私有类而非ArrayList对象本身, 有set,get,contains方法, 但是没有add方法
     * 以下代码会报异常 : java.lang.UnsupportedOperationException
     * 解决方案 : List<String> strings = new ArrayList(Arrays.asList(new String[] {"A","B","C"}));
     */
    @Test
    public void testArrays(){

        List<String> strings = Arrays.asList(new String[] {"A","B","C"});

        for (int i = 0; i < 10; i++) {
            strings.add(i+"");
        }

    }


}
