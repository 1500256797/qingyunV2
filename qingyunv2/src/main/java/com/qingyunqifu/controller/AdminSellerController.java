package com.qingyunqifu.controller;

import com.qingyunqifu.base.utils.Result;
import com.qingyunqifu.base.utils.exception.ExceptionMsg;
import com.qingyunqifu.domain.Sellers;
import com.qingyunqifu.service.QingYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-12.
 */
@Controller
public class AdminSellerController {
    @Autowired
    @Qualifier("QingYunService")
    private QingYunService qingYunService;


    //新增或修改商户
    @RequestMapping(value = "/sys_seller/edit")
    public String editSeller(Integer id, Model model) {
        if (id == null) {
            Sellers seller = new Sellers();
        }
        Sellers seller = qingYunService.findSellerById(id);
        model.addAttribute("seller", seller);
        return "addsellers";
    }

    //获取所有商家数据
    @RequestMapping("/sys_seller/find")
    public String findAllSellers(Model model) {
        List<Sellers> sellers = qingYunService.findAllSellers();
        model.addAttribute("sellers", sellers);
        return "seller";
    }




    //删除商家数据
    @RequestMapping(value = "/sys_seller/delete")
    @ResponseBody
    public Result delete(String ids) {
        try {

            qingYunService.deleteSellerById(Integer.parseInt(ids));
        } catch(ExceptionMsg e) {
            return Result.failure(e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
            return Result.failure(e.getMessage());
        }
        return Result.success();
    }
}
