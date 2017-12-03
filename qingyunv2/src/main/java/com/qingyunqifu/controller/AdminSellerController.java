package com.qingyunqifu.controller;

import com.qingyunqifu.utils.Result;
import com.qingyunqifu.utils.exception.ExceptionMsg;
import com.qingyunqifu.domain.Sellers;
import com.qingyunqifu.service.QingYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public String editSeller(String id, Model model) {

        if (id == null) {
            return "seller/addsellers";
        }else {
            Sellers seller = qingYunService.findSellerById(Integer.parseInt(id));
            model.addAttribute("seller", seller);
            return "seller/modifysellers";
        }

    }


    @RequestMapping(value = "/sys_seller/add")
    @ResponseBody
    public Result add(@RequestParam("name") String name ,
                      @RequestParam("managername") String managername,
                      @RequestParam("phone") String phone,
                      @RequestParam("tel") String tel,
                      @RequestParam("remark") String remark,
                      @RequestParam("sellarrange") String sellarrange,
                      @RequestParam("province") String province,
                      @RequestParam("city") String city,
                      @RequestParam("address") String address,
                      @RequestParam("img") String img
                      ) throws IOException
    {
        Sellers seller = new Sellers();
        seller.setName(name);
        seller.setManagerName(managername);
        seller.setPhone(phone);
        seller.setTel(tel);
        seller.setRemark(remark);
        seller.setSellArrange(sellarrange);
        seller.setProvince(province);
        seller.setCity(city);
        seller.setAddress(address);
        seller.setImgurl(img);
        System.out.println(seller.toString());
        qingYunService.saveSeller(seller);
        return Result.success();
    }


    @RequestMapping(value = "/sys_seller/modify")
    @ResponseBody
    public Result update(@ModelAttribute("name") String name,
                         @ModelAttribute("managername") String managername,
                         @ModelAttribute("phone") String phone,
                         @ModelAttribute("tel") String tel,
                         @ModelAttribute("remark") String remark,
                         @ModelAttribute("sellarrange") String sellarrange,
                         @ModelAttribute("address") String address,
                         @ModelAttribute("sid") String id
    ) {
        if (id != null && !id.equals(" ")) {
            Sellers seller = qingYunService.findSellerById(Integer.parseInt(id));
            seller.setName(name);
            seller.setManagerName(managername);
            seller.setPhone(phone);
            seller.setTel(tel);
            seller.setRemark(remark);
            seller.setSellArrange(sellarrange);
            seller.setAddress(address);
            qingYunService.modifySeller(seller);
            return Result.success();
        } else {
            return Result.failure("id为空,非法操作");
        }

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
