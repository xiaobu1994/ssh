package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author  xiaobu
 * @date   on  2019/12/13 15:23
 * @version JDK1.8.0_171
 * @description 
 */
@Data
@Entity
public class McMblUserCount implements Serializable {
    private static final long serialVersionUID = 4386405295772542285L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
    * 系统(安卓&IOS)
    */
    private String system;

    /**
    * 助手版本
    */
    private String version;

    /**
    * 系统版本
    */
    private String osversion;

    private String model;

    /**
    * 新用户
    */
    private Integer newPerson;

    /**
    * 一日留存
    */
    private Integer one;

    /**
    * 两日留存
    */
    private Integer two;

    /**
    * 三日留存
    */
    private Integer three;

    /**
    * 一周留存
    */
    private Integer wk;

    /**
    * 两周留存
    */
    private Integer twk;

    /**
    * 一月留存
    */
    private Integer mth;

    /**
    * 日活
    */
    private Integer act;

    /**
    * 周活跃
    */
    private Integer wkact;

    /**
    * 月活跃
    */
    private Integer mthact;

    /**
    * 三个月活跃
    */
    private Integer threemthact;

    /**
    * 总用户
    */
    private Integer alluser;

    private Integer loginUser;

    private Integer newRegisterUser;

    private Integer allRegisterUser;

    private String date;
}