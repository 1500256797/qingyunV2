package com.qingyunqifu.controller;

import com.qingyunqifu.utils.Result;
import com.qingyunqifu.utils.exception.ExceptionMsg;
import com.qingyunqifu.domain.LittleTypes;
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
public class AdminLittleTypeController {
    @Autowired
    @Qualifier("QingYunService")
    private QingYunService qingYunService;


    //查询所有次级类型
    @RequestMapping(value = "/sys_ltype/find")
    public String stuffs(Model model) {
        List<LittleTypes> littleTypes = qingYunService.findAllLittleType();
        model.addAttribute("littletypes", littleTypes);
        return "littletype";
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
    @RequestMapping(value = "/sys_ltype/edit")
    public String edit( String id, Model model) {
        if (id!=null) {
            LittleTypes littleType = qingYunService.findLittleTypeById(Integer.parseInt(id));
            model.addAttribute("littletype", littleType);
            System.out.println("展示修改页面");
            List<MainTypes> mainTypesList = qingYunService.findAllMainType();
            model.addAttribute("mainypes", mainTypesList);
            return "littletype/modifylittletype";

        }else {
            System.out.println("展示新增页面");
            List<MainTypes> mainTypesList = qingYunService.findAllMainType();
            model.addAttribute("mainypes", mainTypesList);
            return "littletype/addlittletype";
        }

    }


    //新增
    @RequestMapping(value = "/sys_ltype/add")
    @ResponseBody
    public Result save(@ModelAttribute("name") String name,
                       @ModelAttribute("mid") String mid) {
        if (!name.equals(" ")) {
            LittleTypes littleType = new LittleTypes();
            littleType.setTypeName(name);
            MainTypes mainType = qingYunService.findMainTypeById(Integer.parseInt(mid));
            littleType.setMainTypes(mainType);
            qingYunService.saveLittleType(littleType);
            return Result.success();
        }else{
            return Result.failure("添加失败");
        }


    }


    @RequestMapping(value = "/sys_ltype/modify")
    @ResponseBody
    public Result update(@ModelAttribute("name") String name ,
                         @ModelAttribute("id") String id) {
        System.out.println("name" + name);
        System.out.println("id" + id);
        if (id!=null&&!id.equals(" ")) {
            LittleTypes littleType  = qingYunService.findLittleTypeById(Integer.parseInt(id));
            littleType.setTypeName(name);
            System.out.println("更改后的littletype" + littleType.toString());
            qingYunService.modifyLittleType(littleType);
            Result result = Result.success();
            return Result.success();
        }else {
            return Result.failure("id为空");
        }

    }


    //删除次级类型数据
    @RequestMapping(value = "/sys_ltype/delete")
    @ResponseBody
    public Result delete(String ids) {
        try {

            qingYunService.deleteLittleTypeById(Integer.parseInt(ids));
        } catch(ExceptionMsg e) {
            return Result.failure(e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
            return Result.failure(e.getMessage());
        }
        return Result.success();
    }
}
