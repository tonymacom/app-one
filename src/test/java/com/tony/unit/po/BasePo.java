package com.tony.unit.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/1/17
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Data
public class BasePo {

    private int id;
    private int age;

    private BasePo(){

    }

    public BasePo(int id, int age){
        this.id = id;
        this.age = age;
    }


}
