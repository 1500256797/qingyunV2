package com.qingyunqifu.dao;

import com.qingyunqifu.domain.SellerStuffRun;
import com.qingyunqifu.domain.Sellers;
import com.qingyunqifu.domain.Stuffs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by qqqqqqq on 17-9-9.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SellerStuffRunDaoTest {

    @Autowired
    private SellerStuffRunDao sellerStuffRunDao;

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private StuffDao stuffDao;
    @Test
    public void findAllSellerStuffRun() throws Exception {

    }

    @Test
    public void save() throws Exception {
        SellerStuffRun sellerStuffRun = new SellerStuffRun();
        Stuffs stuff = stuffDao.findStuffById(2);
        Sellers seller = sellerDao.findSellerById(1);
        sellerStuffRun.setSellers(seller);
        sellerStuffRun.setStuffs(stuff);
        sellerStuffRunDao.save(sellerStuffRun);

    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

}