package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/16 9:14
 * @description V1.0
 */
@Entity
@Table(name = "test_dept")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Dept implements Serializable {
    private static final long serialVersionUID = -8311205280361098689L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dept")
    private List<Emp> emps;

}
