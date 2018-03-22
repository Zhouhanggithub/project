package com.eny.controller;

import com.eny.domain.User;
import com.eny.service.Imp.UserServiceImp;
import com.eny.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  处理用户相关操作(登录,注册)
 * @author MoMo
 * @date 2018/1/10
 */
@WebServlet("/userServlet")
public class UserServlet extends AbstractBaseServlet {
    private UserService userService = new UserServiceImp();
    public String login(HttpServletRequest request,HttpServletResponse response){
        System.out.println("用户执行了登录");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.checkUser(username, password);
        if(user != null){
            request.getSession().setAttribute("user",user);
            return "r:index.jsp";
        }
        request.setAttribute("message","用户不存在！！</br>用户名或者密码错误");
        return "df:error.jsp";
    }

    public String logout(HttpServletRequest request,HttpServletResponse response){
        System.out.println("用户执行了注销");
        request.getSession().invalidate();
        return null;
    }

    public String register(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("用户执行了注册");
        String reUsername = request.getParameter("reUsername");
        String rePassword = request.getParameter("rePassword");
        String rePasswordQ = request.getParameter("rePasswordQ");
        System.out.println(reUsername+":"+rePassword+":"+rePasswordQ);
        return null;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("没找到对应操作");
        return null;
    }
}
