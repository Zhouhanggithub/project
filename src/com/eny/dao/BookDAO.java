package com.eny.dao;

import com.eny.domain.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by MoMo on 2018/1/3.
 */
public interface BookDAO {
    /**
     * 查询并返回所有图书
     * @return  图书集合
     * @throws Exception 异常
     */
    List<Book> findAll() throws Exception;

    /**
     * 查询并返回部分图书
     * @param before  从哪里开始
     * @param dataItemCont   多少条数据
     * @return  部分图书集合(ArrayList)
     * @throws Exception 异常
     */
    List<Book> findLimit(Integer before, Integer dataItemCont) throws Exception;


    /**
     *  查询并返回部分图书(分类查询)
     * @param bookCategoryId 分类ID
     * @return  部分图书集合
     */
    List<Book> findPartBookListByCategoryId(Integer bookCategoryId) throws Exception;

    /**
     *  根据分类ID查询并返回部分图书
     * @param bookCategoryId    分类ID
     * @param before        从哪里开始
     * @param dataItemCont  多少条数据
     * @return  部分图书集合
     */
    List<Book> findLimitByCategory(Integer bookCategoryId, Integer before, Integer dataItemCont) throws Exception;

    /**
     *  根据用户ID查找所借图书
     * @param userId    用户ID
     * @return      图书集合
     */
    List<Book> findStackRoomBookListByUserId(Integer userId) throws Exception;

    /**
     * 根据图书ID查找图书
     * @param bookId 图书ID
     * @return  图书对象
     * @throws Exception 异常
     */
    Book findBooksByBookId(Integer bookId) throws Exception;

    /**
     *  根据图书名查找图书
     * @param bookName 书名
     * @return  图书对象
     */
    Book findBookByBookName(String bookName) throws Exception;

    /**
     *  向表中添加数据
     * @param userId  用户ID
     * @param bookId  图书ID
     */
    void addBook(Integer userId, Integer bookId) throws SQLException;

    /**
     * 向表中删除数据
     * @param userId   用户ID
     * @param bookId   图书ID
     */
    void deleteBook(Integer userId, Integer bookId) throws SQLException;

}
