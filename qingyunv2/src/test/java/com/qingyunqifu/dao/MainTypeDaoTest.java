package com.qingyunqifu.dao;

import com.qingyunqifu.domain.LittleTypes;
import com.qingyunqifu.domain.MainTypes;
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
public class MainTypeDaoTest {


    @Autowired
    private MainTypeDao mainTypeDao;
    @Test
    public void findAllMainType() throws Exception {
        List<MainTypes> mainTypes = mainTypeDao.findAllMainType();
        for (MainTypes mainTypes1 : mainTypes) {
            System.out.println(mainTypes1.toString());
            System.out.println("---------------------------------");
        }

    }
    @Test
    public void findAllLittleTypeByMainTypeId() throws Exception {
        MainTypes mainTypes = mainTypeDao.findAllLittleTypeByMainTypeId(1);
        List<LittleTypes> littleTypes = mainTypes.getLittleTypesList();
        for (LittleTypes littleTypes1 : littleTypes) {
            System.out.println(littleTypes1.toString());
        }
    }

    @Test
    public void findMainTypeById() throws Exception {
        MainTypes mainTypes = mainTypeDao.findMainTypeById(1);
        System.out.println(mainTypes.toString());

    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void update() throws Exception {
        MainTypes mainTypes = mainTypeDao.findMainTypeById(6);
        mainTypes.setTypeName("dao");
        mainTypeDao.update(mainTypes);

    }

    @Test
    public void deleteById() throws Exception {
    }


}