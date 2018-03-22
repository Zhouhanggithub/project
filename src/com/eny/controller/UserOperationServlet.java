package com.eny.controller;

import com.eny.domain.Book;
import com.eny.domain.Category;
import com.eny.domain.PageConfig;
import com.eny.domain.User;
import com.eny.service.BookService;
import com.eny.service.CategoryService;
import com.eny.service.Imp.BookServiceImpl;
import com.eny.service.Imp.CategoryServiceImpl;


import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by MoMo on 2018/1/11.
 */
@WebServlet("/userOperationServlet")
public class UserOperationServlet extends AbstractBaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private static PageConfig pageConfig;
    static {
        pageConfig = new PageConfig();
    }
    /**
     *  查询所有图书分类,动态添加;
     */
    public String classify(HttpServletRequest request,HttpServletResponse response){
        List<Category> allCategory = categoryService.getAllCategory();
        request.getSession().setAttribute("allCategory",allCategory);
        request.getSession().setAttribute("pageConfig",pageConfig);
        for(Category category:allCategory){
            System.out.println(category);
        }
        return "r:classify.jsp";
    }

    /**
     *  查询对应的分类的详细图书列表
     */
    public String datail(HttpServletRequest request,HttpServletResponse response){
        String bookCategoryName = request.getParameter("bookCategoryName");
        //根据分类名称获取到ID
        Category category = categoryService.getCatecoryByName(bookCategoryName);
        List<Book> bookList = bookService.gainBookListByCategoryId(category.getBookCategoryId());
        request.getSession().setAttribute("category",category);
        request.setAttribute("bookListCount",bookList.size());
        return "df:about.jsp";
    }

    /**
     *  返回对应的分类的分页查询
     */
    public String aboutBook(HttpServletRequest request,HttpServletResponse response){
        Integer bookCategoryId = Integer.valueOf(request.getParameter("categoryId"));
        //获取开始分页开始下标
        Integer before = Integer.valueOf(request.getParameter("before"));
        //获取每次获取的数据行数
        Integer dataItemCont = Integer.valueOf(request.getParameter("dataItemCont"));
        System.out.println(before  + " : " +dataItemCont);
        //调用bookService方法
        List<Book> bookList = bookService.gainBookListByCategoryIdLimit(bookCategoryId,before,dataItemCont);
        request.setAttribute("bookList",bookList);
        System.out.println("==分页查询==");
        for (Book book:bookList){
            System.out.println(book);
        }
        return "df:bookList.jsp";
    }

    /**
     *  返回所有图书(不分类)
     */
    public String allBook(HttpServletRequest request,HttpServletResponse response){
        System.out.println("分页查询开始");
        Integer before = Integer.valueOf(request.getParameter("before"));
        Integer dataItemCont = Integer.valueOf(request.getParameter("dataItemCont"));
        List<Book> bookList = bookService.gainBookList(before, dataItemCont);
        request.setAttribute("bookList",bookList);
        for(Book book:bookList){
            System.out.println(book);
        }
        return "df:bookList.jsp";
    }

    public String showBook(HttpServletRequest request,HttpServletResponse response){
        int bookListSize = bookService.getAllBookList().size();
        request.setAttribute("bookListSize",bookListSize);
        return  "df:showBook.jsp";
    }

    /**
     *      我的书库
     */
    public String stackRoom(HttpServletRequest request,HttpServletResponse response) {
        //客户已登录,客户信息已存在Session中
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        //获取用户ID
        Integer userId = user.getUserId();
        //通过service层返回该用户所借所有图书
        List<Book> bookList = null;
        try {
            bookList = bookService.getStackRoomList(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("bookListSize",bookList.size());
        session.setAttribute("bookList",bookList);
        return "r:myStackRoom.jsp";
    }

    public String showStackRoom (HttpServletRequest request,HttpServletResponse response) throws Exception{
        return "r:myStackRoomList.jsp";
    };

    /**
     *  用户点击借阅时  将该书加入我的书库
     *      对应进行数据库操作
     */
    public String borrowBook(HttpServletRequest request,HttpServletResponse response)throws Exception{
        //获取session
        HttpSession session = request.getSession(false);
        //获取到当前登录的用户ID
        User user = (User)session.getAttribute("user");
        Integer userId = user.getUserId();
        System.out.println("用户Id = " + userId );
        //获取到当前借阅的书的ID和数量
        String bookName = request.getParameter("bookName");
        System.out.println(" 图书名 = " + bookName);
        Book book = bookService.gainBookByBookName(bookName);
        System.out.println(" 图书ID = " + book.getBookId());
        //数量大于1时可以借阅  否则不可以借阅
        if(book.getBookNum() < 1){
            throw new RuntimeException("该书已经没有了");
        }
        bookService.stackRoomAddBook(userId,book.getBookId());
        //将用户ID和被借阅的书的ID 放入表中,
        request.getSession(false);
        return null;
    }

    /**
     *  归还书籍
     */
    public String giveBack(HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("执行还书");
        //获取session
        HttpSession session = request.getSession(false);
        //获取到当前登录的用户ID
        User user = (User)session.getAttribute("user");
        System.out.println(user);
        Integer userId = user.getUserId();
        System.out.println("用户Id = " + userId );
        //获取到当前借阅的书的ID和数量
        String bookName = request.getParameter("bookName");
        Book book = bookService.gainBookByBookName(bookName);
        bookService.returnBooks(userId,book.getBookId());
        return null;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
