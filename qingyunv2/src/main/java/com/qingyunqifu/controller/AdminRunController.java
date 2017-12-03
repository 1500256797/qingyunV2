package com.qingyunqifu.controller;

import com.qingyunqifu.utils.Result;
import com.qingyunqifu.utils.exception.ExceptionMsg;
import com.qingyunqifu.domain.SellerStuffRun;
import com.qingyunqifu.domain.Sellers;
import com.qingyunqifu.domain.Stuffs;
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
public class AdminRunController {
    @Autowired
    @Qualifier("QingYunService")
    private QingYunService qingYunService;


    //查询所有经营关系
    @RequestMapping(value = "/sys_run/find")
    public String stuffs(Model model) {
        List<SellerStuffRun> sellerStuffRuns = qingYunService.findAllSellerStuffRun();
        model.addAttribute("runs", sellerStuffRuns);
        return "runs";
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
    @RequestMapping(value = "/sys_run/edit")
    public String edit( String id, Model model) {
        List<Sellers> sellersList = qingYunService.findAllSellers();
        List<Stuffs> stuffsList = qingYunService.findAllStuffs();
        model.addAttribute("stuffs", stuffsList);
        model.addAttribute("sellers", sellersList);
        if (id!=null) {
            SellerStuffRun sellerStuffRun = qingYunService.findSellerStuffRunById(Integer.parseInt(id));
            model.addAttribute("sellerandstuff", sellerStuffRun);
            return "runs/modifyrun";
        }else {
            System.out.println("展示新增页面");
            return "runs/addrun";
        }

    }


    //新增
    @RequestMapping(value = "/sys_run/add")
    @ResponseBody
    public Result save(@ModelAttribute("sid") String sid,
                       @ModelAttribute("seid") String seid) {
        if (!sid.equals(" ")&&(!seid.equals(" "))) {
            Sellers seller = qingYunService.findSellerById(Integer.parseInt(seid));
            Stuffs stuff = qingYunService.findStuffById(Integer.parseInt(sid));
            System.out.println("商品" + stuff);
            System.out.println("商户" + seller);
            SellerStuffRun sellerStuffRun = new SellerStuffRun();
            sellerStuffRun.setStuffs(stuff);
            sellerStuffRun.setSellers(seller);
            qingYunService.saveSellerStuffRun(sellerStuffRun);
            return Result.success();
        }else{
            return Result.failure("添加失败");
        }


    }


    @RequestMapping(value = "/sys_run/modify")
    @ResponseBody
    public Result update(@ModelAttribute("id") String id,
                         @ModelAttribute("sid") String sid,
                         @ModelAttribute("seid") String seid) {

        if (id!=null&&!id.equals(" ")) {
            SellerStuffRun sellerStuffRun = new SellerStuffRun();
            sellerStuffRun.setId(Integer.parseInt(id));

            Sellers seller = qingYunService.findSellerById(Integer.parseInt(seid));
            Stuffs stuff = qingYunService.findStuffById(Integer.parseInt(sid));

//            System.out.println("商品" + stuff);
//            System.out.println("商户" + seller);


            sellerStuffRun.setStuffs(stuff);
            sellerStuffRun.setSellers(seller);
            qingYunService.modifySellerStuffRun(sellerStuffRun);
            Result result = Result.success();
            return Result.success();
        }else {
            return Result.failure("id为空");
        }

    }


    //删除经营关系
    @RequestMapping(value = "/sys_run/delete")
    @ResponseBody
    public Result delete(String ids) {
        try {

            qingYunService.deleteSellerStuffRunById(Integer.parseInt(ids));
        } catch(ExceptionMsg e) {
            return Result.failure(e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
            return Result.failure(e.getMessage());
        }
        return Result.success();
    }
}
