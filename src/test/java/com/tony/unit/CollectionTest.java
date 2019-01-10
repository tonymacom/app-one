package com.tony.unit;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import com.tony.unit.po.Content;
import com.tony.unit.po.Dictionary;
import lombok.SneakyThrows;
import org.aspectj.util.FileUtil;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/4
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class CollectionTest {

    @Test
    public void test(){
        Set<String> seta = new HashSet<String>(){
            {
                add("a");
                add("b");
                add("c");
            }

        };

        Set<String> setb = new HashSet<String>(){
            {
                add("b");
            }

        };

        seta.addAll(setb);
        seta.forEach(System.out::print);
        System.out.println();

        //limit
        seta.stream().limit(5).forEach(System.out::print);
        System.out.println();


        //交集
        seta.retainAll(setb);
        seta.forEach(System.out::print);
        System.out.println();

        String[] arraya = seta.toArray(new String[seta.size()]);
        for (String ab : arraya) {
            System.out.print(ab);
        }

    }

    @Test
    @SneakyThrows
    public void test2(){

        File file = ResourceUtils.getFile("D:\\dictionary.json");

        String fileStr = FileUtil.readAsString(file);

        List<Dictionary> dictionaries = JSON.parseArray(fileStr, Dictionary.class);

        Dictionary country = dictionaries.get(0);

        List<Content> contents = country.getContent();

        Map<String,List<Content>> map = contents.stream().collect(Collectors.groupingBy(Content:: getName_en));

        System.out.println(JSON.toJSONString(map));

//        System.out.println("a""b");

    }

    @Test
    @SneakyThrows
    public void test3(){

        List<Content> list = ImmutableList.of(
                new Content("CN","中国","china"),
                new Content("CH","瑞典","ruidian")
        );

        //orElse 无论是否匹配到, 都会执行getElseContent
        Content content = list.stream().filter( dic -> dic.getCode().equals("CN")).findFirst().orElse(getElseContent());
        System.out.println("-------content1:"+ content.toString());
        //orElseGet 只有在没有匹配到的时候执行getElseContent
        Content content2 = list.stream().filter( dic -> dic.getCode().equals("CN")).findFirst().orElseGet(()->getElseContent());
        System.out.println("-------content2:"+ content2.toString());
    }

    public Content getElseContent(){
        System.out.println("执行此方法");
        return new Content("AB","AB_CN","AB_EN");
    }


    /**
     * 其中有一个id为空, 调用max()方法会NullPointerException
     */
    @Test
    @SneakyThrows
    public void test4(){

        List<Content> list = ImmutableList.of(
                new Content(1,"CN","中国","china"),
                new Content("CH","瑞典","ruidian")
        );

        int max = list.stream().mapToInt(Content::getId).max().getAsInt();
        System.out.println(max);
    }

}
