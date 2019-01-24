package com.tony.unit;

import lombok.Builder;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/1
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class LombokTest {

    @Data
    @Builder
    static class ClassA{
        Integer id;
        String name;
    }

    @Test
    public void testBuilder() {
        ClassA classA =  ClassA.builder().id(1).name("aa").build();
        ClassA classB =  ClassA.builder().id(1).name("aa").build();
        Assert.assertEquals(classA,classB);

        System.out.println("aa");

    }


}
