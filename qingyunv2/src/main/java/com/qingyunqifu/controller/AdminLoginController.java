package com.qingyunqifu.controller;

import com.qingyunqifu.domain.Users;
import com.qingyunqifu.service.QingYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by qqqqqqq on 17-9-20.
 */
@Controller
public class AdminLoginController {
    @Autowired
    @Qualifier("QingYunService")
    private QingYunService qingYunService;


    /*
    * 处理登录请求
    * */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ModelAndView login(@ModelAttribute("userName") String loginname,
                              @ModelAttribute("password") String password,
                              ModelAndView mv,
                              HttpSession session) {
        //模拟数据库根据用户名与密码查找用户 判断用户登录
        System.out.println(loginname+password);
        if (loginname.equals("admin") && password.equals("123456")) {
            //模拟创建用户
            Users user = new Users();
            user.setUsername("超级管理员");
            user.setPassword(password);

            user.setLoginname(loginname);

            //登录成功 讲user对象设置到httpsession作用域
            session.setAttribute("user", user);

            //转发到main请求
            mv.setViewName("redirect:/index");

        } else {
            //登录失败 跳转回登录页面
            mv.addObject("message", "用户名密码错误，请重新登录！");
            //设置试图信息为login.html
            mv.setViewName("login");
        }

        return mv;
    }
}
