package com.example.ssh;

import com.example.entity.Book;
import com.example.entity.User;
import com.example.repository.BookRepository;
import com.example.repository.BookRepositoryCustom;
import com.example.repository.StudentRepository;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SshApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(SshApplicationTests.class);

    @Test
    public void contextLoads() {
    }

   /* @Autowired
    private BookService bookService;*/

    @Autowired
    BookRepositoryCustom bookRepositoryCustom;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;





    @Test
    public void findEntityListBySql(){
        @SuppressWarnings("unchecked")
        List<Book> books = bookRepository.findEntityListBySql("select * from test_book",Book.class);
        System.out.println(books.size());
        for (Book book:books){
            System.out.println(book.toString());
        }

    }






    @Test
    public void test2() {
       Optional optional= bookRepository.findById(1);

        System.out.println(optional.get());
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("name")));
        final Page<Book> books = bookRepository.findAll(pageable);
        System.out.println(books.getTotalPages());
    }

    @Test
    public void test3() {
        userService.deleteByName("CCC");
    }


    @Test
    public void test4(){
      List<User> users=  userRepository.findAll();
        System.out.println(users);
    }


    @Test
    public void testCustom(){
        //bookRepositoryCustom.deleteByIdWithHql(3);
        System.out.println("删除成功。。。。。。。。。。。。");
    }




}
