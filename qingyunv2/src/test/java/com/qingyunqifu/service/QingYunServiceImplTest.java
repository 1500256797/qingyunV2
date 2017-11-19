package com.qingyunqifu.service;

import com.qingyunqifu.dao.LittleTypeDao;
import com.qingyunqifu.dao.MainTypeDao;
import com.qingyunqifu.dao.StuffDao;
import com.qingyunqifu.domain.LittleTypes;
import com.qingyunqifu.domain.MainTypes;
import com.qingyunqifu.domain.Stuffs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by qqqqqqq on 17-9-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class QingYunServiceImplTest {

    @Autowired
    private StuffDao stuffDao;

    @Autowired
    private LittleTypeDao littleTypeDao;

    @Autowired
    private MainTypeDao mainTypeDao;

    @Test
    public void findAllMainType() throws Exception {
    }

    @Test
    public void findMainTypeById() throws Exception {
    }

    @Test
    public void saveMainType() throws Exception {
    }

    @Test
    public void modifyMainType() throws Exception {
    }

    @Test
    public void deleteMainTypeById() throws Exception {
    }

    @Test
    public void findAllLittleType() throws Exception {
    }

    @Test
    public void findLittleTypeById() throws Exception {
    }

    @Test
    public void findAllLittleTypeByMainTypeId() throws Exception {
    }

    @Test
    public void saveLittleType() throws Exception {
    }

    @Test
    public void modifyLittleType() throws Exception {
    }

    @Test
    public void deleteLittleTypeById() throws Exception {
    }

    @Test
    public void findAllStuffsByLittleId() throws Exception {
    }

    @Test
    public void findAllStuffs() throws Exception {
    }

    @Test
    public void findStuffById() throws Exception {
    }


    //保存 商品
    @Test
    public void saveStuff() throws Exception {
        LittleTypes littleTypes = littleTypeDao.findLittleTypeById(8);
//        MainTypes mainTypes = mainTypeDao.findMainTypeById(2);
        Stuffs stuffs = new Stuffs();
        stuffs.setName("优优优");
        stuffs.setLittleTypes(littleTypes);
        stuffDao.save(stuffs);
    }

    @Test
    public void modifyStuff() throws Exception {
        Stuffs stuff = stuffDao.findStuffById(16);
        stuff.setName("第二次修改");
        stuffDao.update(stuff);
    }

    @Test
    public void deleteStuffById() throws Exception {
    }

    @Test
    public void findAllSellersByStuffId() throws Exception {
    }

    @Test
    public void findAllStuffsBySellerId() throws Exception {
    }

    @Test
    public void findAllSellers() throws Exception {
    }

    @Test
    public void findSellerById() throws Exception {
    }

    @Test
    public void saveSeller() throws Exception {
    }

    @Test
    public void modifySeller() throws Exception {
    }

    @Test
    public void deleteSellerById() throws Exception {
    }

    @Test
    public void findAllSellerStuffRun() throws Exception {
    }

    @Test
    public void saveSellerStuffRun() throws Exception {
    }

    @Test
    public void modifySellerStuffRun() throws Exception {
    }

    @Test
    public void deleteSellerStuffRunById() throws Exception {
    }

}