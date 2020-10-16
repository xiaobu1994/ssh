package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2019/2/18 17:16
 * @description V1.0
 */
@RestController
@RequestMapping("exception")
public class ExceptionController {




    @GetMapping("demo")
    public String demo(){
        int a = 1 / 0;
        return "123456";
    }

}
