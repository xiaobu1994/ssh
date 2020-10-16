package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2019/2/14 10:09
 * @description V1.0
 */

@Data
public class FastJson implements Serializable {

    private static final long serialVersionUID = 1227274234431420125L;
    private int id;

    private String name;

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime birthDate;
}
