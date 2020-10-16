package com.example.controller;

import com.battcn.boot.swagger.model.DataType;
import com.battcn.boot.swagger.model.ParamType;
import com.example.entity.Book;
import com.example.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/21 10:58
 * @description V1.0
 */
@RestController
@RequestMapping("/book")
@Api(tags = "1.1", description = "书籍管理", value = "书籍管理")
@Slf4j
//@ApiIgnore
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping
    @ApiOperation(value = "条件查询（DONE）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "书籍名", dataType = DataType.STRING, paramType = ParamType.QUERY),
            @ApiImplicitParam(name = "author", value = "作者"),
    })
    public Book query(String name, String author) {
        return bookService.findUnique("from Book where name=" + "'" + name + "'" + " and author=" + "'" + author + "'");
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "修改用户（DONE）")
    public String put(@PathVariable String id, @RequestBody Book book) {
        log.info("如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息 ");
        return id + "/" + book.getAuthor();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "主键查询（DONE）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH),
    })
    public Book get(@PathVariable int id) {
        log.info("单个参数用  @ApiImplicitParam");
        return bookService.findById(id);
    }


    /**
     * @author xiaobu
     * @date 2018/11/22 12:01
     * @param name 书籍名
     * @return java.lang.String
     * @descprition   {name} 自定义变量规则  变量中不可以包含分隔符 /
     *  {name:[a-zA-Z0-9_]+} 正则表达式只允许大、小写字母以及数字和_下划线
     * @version 1.0
     */
    @GetMapping("/bookName/{name:[a-zA-Z0-9_]+}")
    @ApiOperation("验证@PathVariable参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "书籍名称", dataType = DataType.STRING, paramType = ParamType.PATH),
    })
    public String getName(@PathVariable String name) {
        return "bookName/"+name;
    }



    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除书籍（DONE）")
    @ApiImplicitParam(name = "id", value = "书籍编号", dataType = DataType.INT, paramType = ParamType.PATH)
    public void delete(@PathVariable int id) {
        bookService.deleteById(id);
        log.info("单个参数用 ApiImplicitParam");
    }

}
