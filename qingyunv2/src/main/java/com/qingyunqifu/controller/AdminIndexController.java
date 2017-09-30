package com.qingyunqifu.controller;

import com.qingyunqifu.domain.LittleTypes;
import com.qingyunqifu.domain.MainTypes;
import com.qingyunqifu.domain.Sellers;
import com.qingyunqifu.domain.Stuffs;
import com.qingyunqifu.service.QingYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-10.
 */
@Controller
public class AdminIndexController {
    @Autowired
    @Qualifier("QingYunService")
    private QingYunService qingYunService;



    //后台管理首页
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    //默认内容主体区域
    @RequestMapping("/default")
    public String defaultView() {
        return "default";
    }


}
