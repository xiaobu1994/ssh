package com.example.repository;

import com.example.base.repository.BaseRepository;
import com.example.entity.Book;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/13 11:12
 * @description V1.0 因为被factorybean管理所以不需要@Repository 注解
 */
public interface BookRepository extends BaseRepository<Book,Integer> {

}
