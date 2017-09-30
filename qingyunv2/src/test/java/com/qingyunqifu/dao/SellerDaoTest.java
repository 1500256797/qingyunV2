package com.qingyunqifu.dao;

import com.qingyunqifu.domain.Sellers;
import com.qingyunqifu.domain.Stuffs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by qqqqqqq on 17-9-9.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SellerDaoTest {

    @Autowired
    private SellerDao sellerDao;
    @Test
    public void findAllSellersByStuffById() throws Exception {
        List<Sellers> sellersList = sellerDao.findAllSellersByStuffById(12);
        for (Sellers sellers : sellersList) {
            System.out.println(sellers.toString());
        }

    }

    //查询商家的所有商品
    @Test
    public void findAllStuffsBySellerId() throws Exception {
        Sellers sellers = sellerDao.findAllStuffsBySellerId(2);
        List<Stuffs> stuffs = sellers.getStuffsList();
        for (Stuffs stuffs1 : stuffs) {
            System.out.println(stuffs1.toString());
        }
    }

    @Test
    public void findAllSellers() throws Exception {
        List<Sellers> sellersList = sellerDao.findAllSellers();
        for (Sellers sellers : sellersList) {

            System.out.println(sellers.toString());
        }
    }

    @Test
    public void findSellerById() throws Exception {
    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void update() throws Exception {
        Sellers sellers = new Sellers();
        sellers.setId(1);
        sellers.setName("陕西西部汽配");
        sellers.setManagerName("孙经理");
        sellerDao.update(sellers);
    }

    @Test
    public void deleteById() throws Exception {
    }

}