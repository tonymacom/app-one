package com.tony.unit;

import org.junit.Test;

import java.util.Random;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/1/17
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class ModulaHashing {

    /**
     * 取模算法
     */
    @Test
    public void test(){
        int length = (int) Math.pow(2,5);
        long t1= System.nanoTime();
        for (int i = 0; i < 1000000000; i++) {
           int a =  i % length-1;
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);

    }

}
