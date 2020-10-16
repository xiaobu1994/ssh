package com.example.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.base.repository.BaseRepositoryImpl;
import com.example.repository.McMblUserCountRepositoryCustom;

/**
 * @author xiaobu
 * @date 2019-12-13 15:33:17
 * @description 这些实现类必须加 @Repository 否则回报没有注入bean 
 */
@Repository
@SuppressWarnings({"rawtypes","unchecked","all"})
public class McMblUserCountRepositoryCustomImpl implements  McMblUserCountRepositoryCustom{
    @Autowired
       @PersistenceContext
       private EntityManager entityManager;


}