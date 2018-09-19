package com.tony.unit.controller;

import com.tony.unit.Vo.ObjParams;
import com.tony.unit.base.ResponseData;
import org.springframework.web.bind.annotation.*;

/**
 * Created by MABO on 2017/6/27.
 */
@RestController
public class AppOneController {

    @RequestMapping(value = "/output/{str}")
    public ResponseData outInputString(@PathVariable(value = "str") String str){
        ResponseData data = new ResponseData();
        data.setData(str);
        return data;
    }


    @RequestMapping(value = "/obj/cansubmit/with/form")
    public ResponseData getObjParams(ObjParams objParams){
        ResponseData data = new ResponseData();
        data.setData(objParams.toString());
        return data;
    }

    /**
     * 请求Content-type需要以application/json的方式提交请求.否则会出现415错误
     * @param objParams
     * @return
     */
    @RequestMapping(value = "/obj/cansubmit/with/raw", method = RequestMethod.POST)
    public ResponseData getObjParamsWithRaw(@RequestBody ObjParams objParams){
        ResponseData data = new ResponseData();
        data.setData(objParams.toString());
        return data;
    }

}
