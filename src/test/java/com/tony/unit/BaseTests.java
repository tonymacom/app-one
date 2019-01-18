package com.tony.unit;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.tony.unit.po.BasePo;
import org.junit.Test;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/1/17
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class BaseTests {

    @Test
    public void test1(){

        BasePo bp = new BasePo(1,1);
        bp.setAge(1);
        bp.setId(1);

        String bpstr = JSON.toJSONString(bp);
        System.out.println(bpstr);


        Gson gson = new Gson();
        BasePo bp2  =  gson.fromJson(bpstr,BasePo.class);
        System.out.println(bp2.getId()+","+bp2.getAge());
    }

    @Test
    public void test2() throws Exception{

        BasePo b = BasePo.class.newInstance();

        b.setId(1);
        b.setAge(1);

        String bpstr = JSON.toJSONString(b);
        System.out.println(bpstr);

    }

}
