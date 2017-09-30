package com.qingyunqifu.controller;

import com.qingyunqifu.base.utils.Result;
import com.qingyunqifu.base.utils.exception.ExceptionMsg;
import com.qingyunqifu.domain.LittleTypes;
import com.qingyunqifu.domain.Sellers;
import com.qingyunqifu.domain.Stuffs;
import com.qingyunqifu.service.QingYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-12.
 */
@Controller
public class AdminStuffController {
    @Autowired
    @Qualifier("QingYunService")
    private QingYunService qingYunService;

    /*
    * edit函数的功能与转发器类似
    * if（没有指名id）{
    *   //你想新增
    *   return "addXXXX"
    * }
    * //如果指明id
    * //你想修改
    * renturn modifyXXXXX
    * */
    @RequestMapping(value = "/sys_stuff/edit")
    public String edit( String id, Model model) {
        if (id!=null) {
            System.out.println("第一次"+id);
            System.out.println("第二次"+Integer.parseInt(id));
            Stuffs stuff = qingYunService.findStuffById(Integer.parseInt(id));
            System.out.println(stuff.toString());
            model.addAttribute("stuff", stuff);
            System.out.println("---22222222");
            return "modifystuff";

        }else {
            List<LittleTypes> littleTypes = qingYunService.findAllLittleType();
            model.addAttribute("littleTypes", littleTypes);
            System.out.println("1111111");
            return "addstuff";
        }

    }


    //查询所有商品
    @RequestMapping(value = "/sys_stuff/find")
    public ModelAndView stuffs(ModelAndView modelAndView) {
        List<Stuffs> stuffs = qingYunService.findAllStuffs();
        modelAndView.addObject("stuffs", stuffs);
        modelAndView.setViewName("stuff");
        return modelAndView;
    }



    @RequestMapping(value = "/sys_stuff/modify")
    @ResponseBody
    public Result update(@ModelAttribute("name") String name ,
                       @ModelAttribute("id") String id,
                       @ModelAttribute("lid") String lid,
                       @ModelAttribute("mid") String mid) {
        System.out.println("name" + name);
        System.out.println("id" + id);
        System.out.println("lid" + lid);
        System.out.println("mid" + mid);
        if (id!=null&&!id.equals(" ")) {
            System.out.println("-sys_stuff/modify--"+name + id + lid + mid);
            Stuffs stuff = qingYunService.findStuffById(Integer.parseInt(id));
            stuff.setName(name);
            LittleTypes littleType = qingYunService.findLittleTypeById(Integer.parseInt(lid));
            littleType.setMainTypes(qingYunService.findMainTypeById(Integer.parseInt(mid)));
            stuff.setLittleTypes(littleType);
            qingYunService.modifyStuff(stuff);
            Result result = Result.success();
            return Result.success();
        }else {

            return Result.failure("id为空");
        }

    }

    @RequestMapping(value = "/sys_stuff/add")
    @ResponseBody
    public Result add(@ModelAttribute("name") String name ,
                      @ModelAttribute("opid") String opid ) {


        System.out.println("name" + name);
        System.out.println("opid" + opid);
            Stuffs stuff = new Stuffs();
            stuff.setName(name);
            stuff.setLittleTypes(qingYunService.findLittleTypeById(Integer.parseInt(opid)));
            qingYunService.saveStuff(stuff);
            System.out.println("新增的商品信息"+stuff.toString());
            return Result.success();


    }

    //删除商品数据
    @RequestMapping(value = "/sys_stuff/delete")
    @ResponseBody
    public Result delete(String ids) {
        try {
            qingYunService.deleteStuffById(Integer.parseInt(ids));
        } catch(ExceptionMsg e) {
            return Result.failure(e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
            return Result.failure(e.getMessage());
        }
        return Result.success();
    }
}

