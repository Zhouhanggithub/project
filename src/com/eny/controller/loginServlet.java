package com.eny.controller;

import com.eny.domain.User;
import com.eny.service.UserService;
import com.eny.service.Imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by MoMo on 2017/12/28.
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取Session
        HttpSession session = request.getSession();
        //获取页面用户输入的用户名和密码
        String passwd = request.getParameter("passwd");
        String username = request.getParameter("username");


        //对请求参数进行判空 有一项为空 返回登录
        if(username == null || "".equals(username.trim())){
            request.setAttribute("message","用户名不能为空");
            request.getRequestDispatcher("error.jsp").forward(request,response);
            return;
        }
        if(passwd == null || "".equals(passwd.trim())){
            request.setAttribute("message","密码不能为空");
            request.getRequestDispatcher("error.jsp").forward(request,response);
            return;
        }

        //创建Service对象
        UserService userService = new UserServiceImp();
        //调用sercice检查用户是否存在
        User user = userService.checkUser(username,passwd);

        //判断user用户是否存在
        if(user == null){
            //验证失败调回登录页面
            request.setAttribute("message","用户名或密码错误");
            request.getRequestDispatcher("error.jsp").forward(request,response);
            return;
        }
        //验证通过跳转主页面
        List users = userService.getAllUsers();
        session.setAttribute("users",users);

        response.sendRedirect("index.jsp");
    }

}
