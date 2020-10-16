package com.example.entity;

/**
 * @author tanhw119214  on  2018/6/12 17:33
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户表
 */
@Entity
@Table(name = "test_user")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //姓名
    @Column(nullable = false, length = 50)
    private String name;
    //登录密码
    private String password;

    private String roleName;

    private boolean locked;

    private int age;


    public User(long id,String name, String password, String roleName, boolean locked) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roleName = roleName;
        this.locked = locked;
    }
}


