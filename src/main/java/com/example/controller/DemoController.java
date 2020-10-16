package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2019/2/14 9:10
 * @description V1.0
 */
@Controller
@RequestMapping("demo")
public class DemoController {

    /**
     * @author xiaobu
     * @date 2019/2/14 9:46
     * @return java.lang.String
     * @descprition  shiro标签集成测试
     * @version 1.0
     */
    @GetMapping("index")
    public String index(){
        return "index";
    }
}
