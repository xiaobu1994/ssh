package com.example.service;

import com.example.base.service.BaseService;
import com.example.entity.Book;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/13 11:14
 * @description V1.0
 */

public interface BookService extends BaseService<Book,Integer> {
    void deleteByIdWithHql(Integer id);

}
