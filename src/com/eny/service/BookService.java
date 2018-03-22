package com.eny.service;

import com.eny.domain.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * 用于获取图书列表
 * @author MoMo
 * @date 2018/1/3
 */
public interface BookService {
    /**
     *  获取所有图书
     * @return  图书集合对象(ArrayList)
     */
    List<Book> getAllBookList();

    /**
     *  获取部分图书(分页)
     * @param before  从哪里开始
     * @param dataItemCont   多少条数据
     * @return      部分图书集合对象(ArrayList)
     */
    List<Book> gainBookList(Integer before, Integer dataItemCont);

    /**
     *  获取部分图书(分类查询)
     * @param bookCategoryId
     * @return 返回图书集合对象
     */
    List<Book> gainBookListByCategoryId(Integer bookCategoryId);


    /**
     *  获取部分图书(条件为同一类,然后使用分页查询)
     * @param bookCategoryId       分类ID
     * @param before               开始下标
     * @param dataItemCont         数据行数
     * @return                     返回图书集合对象
     */
    List<Book> gainBookListByCategoryIdLimit(Integer bookCategoryId, Integer before, Integer dataItemCont);

    /**
     *  获取用户所借图书
     * @param userId   根据用户ID查找
     * @return         返回图书集合对象
     */
    List<Book> getStackRoomList(Integer userId) throws Exception;

    /**
     *  根据图书姓名,返回图书ID
     * @param bookName  书名
     * @return  图书ID
     * @throws Exception 异常
     */
    Book gainBookByBookName(String bookName) throws Exception;

    /**
     *  向user_book表中添加数据
     * @param userId    用户ID
     * @param bookId    图书ID
     */
    void stackRoomAddBook(Integer userId, Integer bookId) throws SQLException;

    /**
     *  归还,book_user表中删除数据
     * @param userId    用户ID
     * @param bookId    图书ID
     */
    void returnBooks(Integer userId, Integer bookId) throws SQLException;
}
