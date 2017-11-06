package com.qingyunqifu.Restful;


import com.qingyunqifu.domain.Sellers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SellerController {

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    public List<Sellers> query() {
        System.out.println("11111111");
        List<Sellers> sellersList = new ArrayList<>();
        Sellers seller1 = new Sellers();
        seller1.setName("1");
        Sellers seller2 = new Sellers();
        seller2.setName("2");
        Sellers seller3 = new Sellers();
        seller3.setName("3");

        sellersList.add(seller1);
        sellersList.add(seller2);
        sellersList.add(seller3);
        return sellersList;
    }

}
