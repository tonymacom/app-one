package com.tony.unit.controller;

import com.tony.unit.base.ResponseData;
import com.tony.unit.pojo.AppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MABO on 2017/7/4.
 */
@RestController
public class SysInfoController {

    @Autowired
    private AppInfo appInfo;

    @RequestMapping(value = "/getInfo")
    public ResponseData getSysInfo(HttpServletRequest request){
        ResponseData data = new ResponseData();
        Map<String,Object> map = new HashMap<>();
        map.put("app-Name",this.appInfo.getName());
        map.put("app-addr",this.appInfo.getIpAddr());
        data.setData(map);
        return data;
    }

}
