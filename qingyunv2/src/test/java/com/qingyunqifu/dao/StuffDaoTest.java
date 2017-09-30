package com.qingyunqifu.dao;

import com.qingyunqifu.domain.LittleTypes;
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

public class StuffDaoTest {


    @Autowired
    private StuffDao stuffDao;

    @Test
    public void findAllSellersByStuffById() throws Exception {
        Stuffs stuffs  = stuffDao.findAllSellersByStuffById(9);
        System.out.println(stuffs.toString());
        List<Sellers> sellersList = stuffs.getSellersList();
        for (Sellers sellers : sellersList) {
            System.out.println(sellers.toString());
        }
    }


    @Test
    public void findAllStuffs() throws Exception {
    }

    @Test
    public void findStuffById() throws Exception {
    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void findStuffsByLittleTypeById() throws Exception {
        List<Stuffs> stuffsList = stuffDao.findStuffsByLittleTypeId(10);
        for (Stuffs stuffs : stuffsList) {
            System.out.println(stuffs.toString());
        }
    }

    @Test
    public void selectById() throws Exception {
        Stuffs stuffs = stuffDao.findAllSellersByStuffById(12);
        System.out.println(stuffs.toString());
    }

}