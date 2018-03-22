package com.eny.controller;

import com.eny.domain.PageConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by MoMo on 2018/1/10.
 */
public abstract class AbstractBaseServlet extends HttpServlet {
    private static final String REDIRECT = "r";
    private static final String DISPATCHER_INCLUDE = "di";
    private static final String DISPATCHER_FORWORD = "df";
    private static PageConfig pageConfig;
    @Override
    public void init() throws ServletException {
        pageConfig = new PageConfig();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("pageConfig",pageConfig);
        String methodPar = request.getParameter("M");
        if(methodPar==null || "".equals(methodPar.trim())){
            methodPar = "execute";
        }
        try {
            Method method = this.getClass().getMethod(methodPar,HttpServletRequest.class,HttpServletResponse.class);
            Object resultObj = method.invoke(this,request,response);
            if(resultObj instanceof String){
                String[] split = ((String) resultObj).split(":");
                if(REDIRECT.equals(split[0])){
                    response.sendRedirect(split[1]);
                    return;
                }
                if(DISPATCHER_INCLUDE.equals(split[0])){
                    request.getRequestDispatcher(split[1]).include(request,response);
                    return;
                }
                request.getRequestDispatcher(split[1]).forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public abstract String execute(HttpServletRequest request,HttpServletResponse response);
}
