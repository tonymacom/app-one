package com.tony.unit;

import org.junit.Test;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/25
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class JavaHomeTest {

    @Test
    public void getJavaHome(){
        String home = System.getProperty("java.home");
        System.out.println(home);
    }
}
