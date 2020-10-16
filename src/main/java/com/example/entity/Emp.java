package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/16 9:16
 * @description V1.0
 */
@Entity
@Table(name = "test_emp")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Emp implements Serializable {
    private static final long serialVersionUID = 5814957936844771773L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "dept_id")
    private Dept dept;
}
