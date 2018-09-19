package com.tony.unit.Vo;

import lombok.Data;

/**
 * Created by MABO on 2017/7/4.
 */
@Data
public class ObjParams {

    private String code;

    private String name;

    private String desc;

    public String toString(){
        return "-->code:" + this.code +"-->name:"+ this.name + "-->desc:" + this.desc;
     }

}
