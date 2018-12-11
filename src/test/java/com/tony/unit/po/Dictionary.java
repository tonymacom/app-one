package com.tony.unit.po;

import lombok.Data;

import java.util.List;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/7
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Data
public class Dictionary {

    //分类 , 类似 country等.
    private String category;

    //具体的字典值, 类似country中国家列表
    private List<Content> content;

}
