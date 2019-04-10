package com.tony.unit;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/4/9
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class Happy {


    public static void main(String[] args) {
        int i=1; //i = 1
        int j = i++; // i = 2, j = 1;
        if ((i == ++j) && (i++ ==j )) { // i = 2,j = 2 || j = 2, i = 3
            i +=j;
        }
        System.out.println(i); // 5
    }

}
