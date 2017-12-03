package com.qingyunqifu.controller;

import com.qingyunqifu.utils.Result;
import com.qingyunqifu.utils.exception.ExceptionMsg;
import com.qingyunqifu.domain.MainTypes;
import com.qingyunqifu.service.QingYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-12.
 */
@Controller
public class AdminMainTypeController {
    @Autowired
    @Qualifier("QingYunService")
    private QingYunService qingYunService;

    //查询所有主营类型
    @RequestMapping(value = "/sys_mtype/find")
    public String mtypes(Model model) {
        List<MainTypes> mainTypes = qingYunService.findAllMainType();
        model.addAttribute("maintypes",mainTypes);
        return "maintype";
    }


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
    @RequestMapping(value = "/sys_mtype/edit")
    public String edit( String id, Model model) {
        if (id!=null) {
//            System.out.println("第一次"+id);
//            System.out.println("第二次"+Integer.parseInt(id));
            MainTypes mainTypes = qingYunService.findMainTypeById(Integer.parseInt(id));
            model.addAttribute("maintype", mainTypes);
            System.out.println(mainTypes.toString());
            System.out.println("展示修改页面");
            return "maintype/modifymaintype";

        }else {
            System.out.println("展示新增页面");
            return "maintype/addmaintype";
        }

    }


    //新增
    @RequestMapping(value = "/sys_mtype/add")
    @ResponseBody
    public Result save(@ModelAttribute("name") String name) {
        if (!name.equals(" ")) {
            MainTypes mainType = new MainTypes();
            mainType.setTypeName(name);
            qingYunService.saveMainType(mainType);
            return Result.success();
        }else{
            return Result.failure("添加失败");
        }


    }


    @RequestMapping(value = "/sys_mtype/modify")
    @ResponseBody
    public Result update(@ModelAttribute("name") String name ,
                         @ModelAttribute("id") String id) {
        System.out.println("name" + name);
        System.out.println("id" + id);
        if (id!=null&&!id.equals(" ")) {
            MainTypes mainType = qingYunService.findMainTypeById(Integer.parseInt(id));
            mainType.setTypeName(name);
            System.out.println("更改后的maintype" + mainType.toString());
            qingYunService.modifyMainType(mainType);
            Result result = Result.success();
            return Result.success();
        }else {
            return Result.failure("id为空");
        }

    }

    //删除主营类型
    @RequestMapping(value = "/sys_mtype/delete")
    @ResponseBody
    public Result delete(String ids) {
        try {

            qingYunService.deleteMainTypeById(Integer.parseInt(ids));
        } catch(ExceptionMsg e) {
            return Result.failure(e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
            return Result.failure(e.getMessage());
        }
        return Result.success();
    }

}
