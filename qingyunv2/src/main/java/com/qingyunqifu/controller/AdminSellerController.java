package com.qingyunqifu.controller;

import com.qingyunqifu.base.utils.Result;
import com.qingyunqifu.base.utils.exception.ExceptionMsg;
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
public class AdminSellerController {
    @Autowired
    @Qualifier("QingYunService")
    private QingYunService qingYunService;


    //新增或修改商户
    @RequestMapping(value = "/sys_seller/edit")
    public String editSeller(Integer id, Model model) {
        if (id == null) {
            System.out.println("id为空，所以这是新增事件");
            return "seller/addsellers";
        }else {
            Sellers seller = qingYunService.findSellerById(id);
            model.addAttribute("seller", seller);
            return "seller/addsellers";
        }

    }


    @RequestMapping("/sys_seller/add")
    @ResponseBody
    public Result add(@ModelAttribute("name") String name ,
                      @ModelAttribute("managername") String managername,
                      @ModelAttribute("phone") String phone,
                      @ModelAttribute("tel") String tel,
                      @ModelAttribute("remark") String remark,
                      @ModelAttribute("sellarrange") String sellarrange,
                      @ModelAttribute("address") String address
                      ) {


        System.out.println("正在调用添加商户方法");
        Sellers seller = new Sellers();
        seller.setName(name);
        seller.setManagerName(managername);
        seller.setPhone(phone);
        seller.setTel(tel);
        seller.setRemark(remark);
        seller.setSellArrange(sellarrange);
        seller.setAddress(address);
        qingYunService.saveSeller(seller);

        return Result.success();


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
