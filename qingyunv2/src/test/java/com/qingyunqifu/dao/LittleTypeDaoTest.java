package com.qingyunqifu.dao;

import com.qingyunqifu.domain.LittleTypes;
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
public class LittleTypeDaoTest {


    @Autowired
    private LittleTypeDao littleTypeDao;

    @Autowired
    private MainTypeDao mainTypeDao;

    @Test
    public void findAllLittleType() throws Exception {
    }

    @Test
    public void findLittleTypeById() throws Exception {
    }

    @Test
    public void save() throws Exception {
        LittleTypes littleTypes = new LittleTypes();
        littleTypes.setMainTypes(mainTypeDao.findMainTypeById(2));
        littleTypes.setTypeName("转向系统");
        littleTypeDao.save(littleTypes);


    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void findStuffsById() throws Exception {
        LittleTypes littleTypes = littleTypeDao.findStuffsById(10);
        System.out.println(littleTypes.toString());
        littleTypes.getStuffsList().forEach(stuffs -> System.out.println(stuffs));
    }

}