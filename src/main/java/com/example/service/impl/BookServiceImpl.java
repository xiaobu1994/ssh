package com.example.service.impl;

import com.example.base.service.BaseServiceImpl;
import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.repository.BookRepositoryCustom;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/13 11:15
 * @description V1.0
 */
@Service
@SuppressWarnings({"rawtypes", "unchecked", "all"})
public class BookServiceImpl extends BaseServiceImpl<Book, Integer> implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookRepositoryCustom bookRepositoryCustom;

    @Override
    public void deleteByIdWithHql(Integer id) {
        bookRepositoryCustom.deleteByIdWithHql(id);
    }
}
