package com.example.repository.impl;

import com.example.repository.EmpRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author xiaobu
 * @date 2018-11-20 11:21:37
 * @description 
 */
@Repository
@SuppressWarnings({"rawtypes","unchecked","all"})
public class EmpRepositoryCustomImpl implements  EmpRepositoryCustom{
    @Autowired
       @PersistenceContext
       private EntityManager entityManager;


}