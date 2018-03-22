package com.eny.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by MoMo on 2018/1/2.
 */
public class CheckSessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        //判断该请求是否是登录页面发送,如果是登录页面发送则不过滤 直接放行
        if(!"/loginServlet".equals(request.getRequestURI())){
            if(session.getAttribute("users") == null){
                request.getRequestDispatcher("login.jsp").forward(request,response);
                return;
            }
        }
        chain.doFilter(req,resp);

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        
    }


}
