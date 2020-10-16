package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author tanhw119214  on  2018/6/12 17:36
 */

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);

    @Query("select u from User u where u.name = ?1")
    User findByName(String name);


    @Query("select u from User u where u.id = ?1")
    User findById(long id);

    /**
     * 使用原生SQL语句
     * @param id   nativeQuery = true
     * @return
     */
    @Query(value="select * from test_user  where id =?1", nativeQuery = true)
    User  findById2(long id);



}
