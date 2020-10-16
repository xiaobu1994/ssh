package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.FastJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2019/2/14 9:59
 * @description V1.0 验证项目集成fastjson是否成功  观察下面的方法表明fastjson配置生效了,默认是启用jackjson
 */

@RestController
@RequestMapping("fastJson")
public class FastJsonController {

    @GetMapping("demo2")
    public FastJson demo2(){
        FastJson fastJson = new FastJson();
        fastJson.setId(1);
        fastJson.setName("xiaobu");
        fastJson.setBirthDate(LocalDateTime.now());
        return  fastJson;
    }

    @GetMapping("demo3")
    public String demo3(){
        FastJson fastJson = new FastJson();
        fastJson.setId(1);
        fastJson.setName("xiaobu");
        fastJson.setBirthDate(LocalDateTime.now());
       return JSON.toJSONString(fastJson);
    }
}
