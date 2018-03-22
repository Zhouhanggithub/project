package com.eny.dao.Impl;

import com.eny.dao.BookDAO;

import com.eny.dao.CategoryDAO;
import com.eny.domain.Book;
import com.eny.utils.JdbcUtil;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MoMo on 2018/1/3.
 */
public class BookDaoImpl extends GenericDaoImpl implements BookDAO {

    @Override
    public List<Book> findAll() throws Exception {
        String sql = "select * from t_book";
        Connection conn = JdbcUtil.getConnection();
        List<Book> books = query(conn,sql,new BookListHandler(), null);
        conn.close();
        return books;
    }

    @Override
    public List<Book> findLimit(Integer before, Integer dataItemCont) throws Exception {
       String sql = "select * from t_book limit ?,?";
       Object [] paramValues = {before,dataItemCont};
        Connection conn = JdbcUtil.getConnection();
        List<Book> partBookList = query(conn,sql, new BookListHandler(), paramValues);
        conn.close();
        return partBookList;
    }

    @Override
    public List<Book> findPartBookListByCategoryId(Integer bookCategoryId) throws Exception {
        String sql = "select * from t_book where bookCategory=?";
        Object [] paramVlaues = {bookCategoryId};
        Connection conn = JdbcUtil.getConnection();
        List<Book> partBookList = query(conn,sql, new BookListHandler(), paramVlaues);
        conn.close();
        return partBookList;
    }

    @Override
    public List<Book> findLimitByCategory(Integer bookCategoryId, Integer before, Integer dataItemCont) throws Exception {
        String sql = "select * from t_book where bookCategory=? limit ?,?";
        Object [] paramValues = {bookCategoryId,before,dataItemCont};
        Connection conn = JdbcUtil.getConnection();
        List<Book> partBookList = query(conn,sql, new BookListHandler(), paramValues);
        conn.close();
        return partBookList;
    }

    @Override
    public List<Book> findStackRoomBookListByUserId(Integer userId) throws Exception {
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from book_user where user_id = ?";
        Object [] paramValues = {userId};
        List<Book> bookList = query(conn, sql, new ResultSetHandler<List<Book>>() {
            @Override
            public List<Book> handle(ResultSet resultSet) throws SQLException {
                List<Book> bookList = new ArrayList<>();
                Integer bookId = null;
                while(resultSet.next()){
                    bookId = resultSet.getInt(2);
                    try {
                        bookList.add(findBooksByBookId(bookId));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return bookList;
            }
        }, paramValues);
        return bookList;
    }

    @Override
    public Book findBooksByBookId(Integer bookId) throws Exception {
        String sql = "select * from t_book where bookId = ?";
        Connection conn = JdbcUtil.getConnection();
        Object[] paramValue = {bookId};
        List <Book> bookList = query(conn,sql,new BookListHandler(),paramValue);
        conn.close();
        return bookList == null || "".equals(bookList.get(0)) ? null : bookList.get(0);
    }

    @Override
    public Book findBookByBookName(String bookName) throws Exception {
        String sql = "select * from t_book where bookName = ?";
        Object [] paramValue = {bookName};
        List<Book> bookList = query(sql,new BookListHandler(),paramValue);
        return bookList != null || "".equals(bookList.get(0)) ? bookList.get(0) : null;
    }

    @Override
    public void addBook(Integer userId, Integer bookId) throws SQLException {
        String sql = "insert into book_user value(?,?)";
        Object [] paramValues = {userId,bookId};
        update(sql,paramValues);
    }

    @Override
    public void deleteBook(Integer userId, Integer bookId) throws SQLException {
        String sql = "delete from book_user where user_id = ? and book_id = ?";
        Object [] paramValues = {userId,bookId};
        update(sql,paramValues);
    }
}

class BookListHandler implements ResultSetHandler {
        @Override
        public List<Book> handle(ResultSet resultSet) throws SQLException {
            CategoryDAO categoryDao = new CategoryDaoImpl();
            List<Book> bookList = new ArrayList<>();
            Book book;
            while (resultSet.next()){
                book = new Book();
                try {
                    book.setBookId(resultSet.getInt(1));
                    book.setBookName(resultSet.getString(2));
                    book.setBookCategory(categoryDao.findByCategoryId(resultSet.getInt(3)));
                    book.setBookAuthor(resultSet.getString(4));
                    book.setPress(resultSet.getString(5));
                    book.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(6)));
                    book.setBookPrice(resultSet.getDouble(7));
                    book.setBookNum(resultSet.getInt(8));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                bookList.add(book);
            }
            return bookList;
        }


}

