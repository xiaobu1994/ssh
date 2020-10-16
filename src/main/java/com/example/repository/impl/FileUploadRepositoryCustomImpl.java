package com.example.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.base.repository.BaseRepositoryImpl;
import com.example.repository.FileUploadRepositoryCustom;

/**
 * @author xiaobu
 * @date 2018-11-20 15:48:46
 * @description V1.0 
 */
@Repository
@SuppressWarnings({"rawtypes","unchecked","all"})
public class FileUploadRepositoryCustomImpl implements  FileUploadRepositoryCustom{
    @Autowired
       @PersistenceContext
       private EntityManager entityManager;


}