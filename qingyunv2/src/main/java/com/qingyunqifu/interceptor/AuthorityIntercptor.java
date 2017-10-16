package com.qingyunqifu.interceptor;

import com.qingyunqifu.domain.Users;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityIntercptor implements HandlerInterceptor{

    //不拦截xxx请求
    private static final String[] IGNORE_URL = {"/loginForm", "/login"};

    /*
    * 本方法在进行处理器拦截用的，该方法在COntroller处理之前进行调用
    * 本方法返回值为ture，拦截器才会继续往下执行，该方法返回false时，整个请求就代表结束了。
    * */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        System.out.println("在请求处理来之前，也就是在controller函数调用之前");
//        System.out.println("普通拦截器正在保护您的安全");
        //flag 登录标志
        boolean flag = false;

        //获取请求路径进行判断
        String servletPath = httpServletRequest.getServletPath();
        for (String s : IGNORE_URL) {
            if (servletPath.contains(s)) {
                flag = true;
                break;

            }
        }

        //拦截请求
        if (!flag) {
            //获取session中的user
            Users user = (Users) httpServletRequest.getSession().getAttribute("user");

            if (user == null) {
//                System.out.println("你好坏，快去登录");
//                httpServletRequest.setAttribute("message", "请先登录再来");
                httpServletRequest.getRequestDispatcher("login").forward(httpServletRequest, httpServletResponse);

            }else {
//                System.out.println("放行！！！");
                flag = true;
            }

        }

        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("在请求处理后，但在试图渲染之前调用");
    }


    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        System.out.println("渲染结束后再调用");
    }
}
