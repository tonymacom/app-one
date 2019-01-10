package com.tony.unit.po;

import lombok.Data;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/8
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Data
public class Content {
    private Integer id;
    private String code;
    private String name_cn;
    private String name_en;


    public Content(String code,String name_cn,String name_en){
        this.code = code;
        this.name_cn = name_cn;
        this.name_en = name_en;
    }

    public Content(Integer id,String code,String name_cn,String name_en){
        this.id = id;
        this.code = code;
        this.name_cn = name_cn;
        this.name_en = name_en;
    }
}
