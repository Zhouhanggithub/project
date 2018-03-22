package com.eny.service.Imp;

import com.eny.dao.BookDAO;
import com.eny.dao.Impl.BookDaoImpl;
import com.eny.domain.Book;
import com.eny.service.BookService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by MoMo on 2018/1/3.
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDao = new BookDaoImpl();
    @Override
    public List<Book> getAllBookList() {
        List<Book> bookList = null;
        try {
            bookList = bookDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> gainBookList(Integer before, Integer dataItemCont) {
        List<Book> partBookList = null;
        try {
            partBookList =  bookDao.findLimit(before,dataItemCont);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return partBookList;
    }

    @Override
    public List<Book> gainBookListByCategoryId(Integer bookCategoryId) {
        List<Book> partBookList = null;
        try {
            partBookList = bookDao.findPartBookListByCategoryId(bookCategoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return partBookList;
    }

    @Override
    public List<Book> gainBookListByCategoryIdLimit(Integer bookCategoryId, Integer before, Integer dataItemCont) {
        List<Book> partBookList = null;
        try {
            partBookList = bookDao.findLimitByCategory(bookCategoryId,before,dataItemCont);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return partBookList;
    }

    @Override
    public List<Book> getStackRoomList(Integer userId) throws Exception {
        List<Book>  stackRoomBookList = null;
        stackRoomBookList = bookDao.findStackRoomBookListByUserId(userId);
        return stackRoomBookList;
    }

    @Override
    public Book gainBookByBookName(String bookName) throws Exception {
        Book book = bookDao.findBookByBookName(bookName);
        if (book == null){
            throw new RuntimeException("该书不存在");
        }
        return book;
    }

    @Override
    public void stackRoomAddBook(Integer userId, Integer bookId) throws SQLException {
        bookDao.addBook(userId,bookId);
    }

    @Override
    public void returnBooks(Integer userId, Integer bookId) throws SQLException {
        bookDao.deleteBook(userId,bookId);
    }

}
