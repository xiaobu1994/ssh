package com.example.ssh;

import com.example.base.entity.vo.PageFinder;
import com.example.base.entity.vo.QueryBuilder;
import com.example.entity.Book;
import com.example.entity.vo.BookVo;
import com.example.repository.BookRepository;
import com.example.service.BookService;
import com.example.base.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTests {


    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;


    /**
     * @return void
     * @author xiaobu
     * @date 2018/11/15 16:06
     * @descprition 看下继承了那些查询方法
     * @version 1.0
     */
    @Test
    public void find() {
        //findOne() 和 getOne(),就很像Hibernate中的load和get.
        //get 找不到会报错，load找不到会返回null springboot 2.0没有findOne() getone 不会保存在内存中所以会报no session
       // Book book2 = bookRepository.getOne(255);
       // System.out.println(book2);

        Optional optional = bookRepository.findById(1);
        //这个是Book对象
        System.out.println(optional.get());
        //查询所有
        System.out.println(bookRepository.findAll());
        //排序查询
        System.out.println(bookRepository.findAll(Sort.by(Sort.Order.desc("name"))));
        //实例查询
        //Hibernate: select book0_.id as id1_0_, book0_.name as name2_0_ from test_book book0_ where (book0_.name like ?) and book0_.id=1
        Book book = new Book();
        book.setName("java");
        //如果不set id则默认为0
        book.setId(1);
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
                .withIgnorePaths("id");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
        //创建实例
        Example<Book> ex = Example.of(book, matcher);
        System.out.println(bookRepository.findAll(ex));

    }


    /**
     * @author xiaobu
     * @date 2018/11/15 17:02
     * @descprition 保存的方法
     * @version 1.0
     */
    @Test
    public void save() {
        List<Book> list = new ArrayList<>();
        for (int i = 100; i < 120; i++) {
            Book book = new Book();
            book.setName("admin 专用" + i);
            list.add(book);
            //保存单个
            //bookRepository.save(book);
        }
        //保存list
        bookRepository.saveAll(list);
    }


    /**
     * update的话需要先find再执行save的方法
     * 或者写JPQL
     * update或delete时必须使用@Modifying对方法进行注解，
     * 才能使得ORM知道现在要执行的是写操作
     */
    @Test
    public void update() {
        //经测试 开始前 Book(id=2, name=三国演义, author=罗贯中)
        //操作后Book(id=2, name=红楼梦, author=罗贯中)
        //只会修改set过的值
        Book book = bookRepository.findUnique(" from Book where id=2");
        System.out.println(book);
        book.setName("红楼梦");
        bookRepository.save(book);
        // bookRepository.saveAndFlush(book);
        System.out.println("ok===================");
    }


    @Test
    public void delete() {
        bookRepository.deleteById(1);
    }

    /**
     * @return void
     * @author xiaobu
     * @date 2018/11/15 16:56
     * @descprition 简单的分页查询
     * @version 1.0
     */
    @Test
    public void findBySimplePage() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("name")));
        final Page<Book> books = bookRepository.findAll(pageable);
        System.out.println(books.getTotalPages());
    }


    @Test
    @SuppressWarnings("unchecked")
    public void test() {
        List<Book> bookList = bookRepository.findEntityListByHql("from Book ");
        System.out.println(bookList);
        //这个方法要在vo类里面写一个构造方法
        List<BookVo> list = bookRepository.findByHql("select new com.example.entity.vo.BookVo (b.name,b.author) from Book b");
        System.out.println(list);
        List<Object[]> list1 = bookRepository.findListBySql("select b.name,b.author from test_book b");
       for(Object[] objects:list1){
           System.out.println(Arrays.toString(objects));
       }
        List<BookVo> vos = EntityUtils.castEntity(list1,BookVo.class);
        System.out.println("bookVos:"+vos);

        List<Object[]> list2 = bookRepository.findListBySql("select name from test_book");
        System.out.println(list2);

        //统计总数
        System.out.println(bookRepository.count());
        System.out.println(bookRepository.countTotalByHql("from Book "));
        System.out.println(bookRepository.countTotalBySql("from test_book"));

    }



    @Test
    public void testCriteria(){
        System.out.println( bookRepository.getCountByCriteriaBuilder(Book.class));
        List<Book> list = bookRepository.getEntityListByCriteriaBuilder(Book.class);

    }


    @Test
    public void testDefinePage(){
        QueryBuilder queryBuilder = new QueryBuilder();
        PageFinder<Book> pageFinder = bookRepository.findPageListByHql("from Book",queryBuilder);
        System.out.println(pageFinder);
        pageFinder = bookService.findPageListByHql(queryBuilder);
        System.out.println(pageFinder);
    }


    @Test
    public void testCustom(){
        bookService.deleteByIdWithHql(4);
        System.out.println("删除成功。。。。。。。。。。。。");
    }

}
