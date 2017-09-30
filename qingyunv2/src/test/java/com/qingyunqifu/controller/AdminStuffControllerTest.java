package com.qingyunqifu.controller;

import com.qingyunqifu.base.utils.Result;
import com.qingyunqifu.domain.LittleTypes;
import com.qingyunqifu.domain.Stuffs;
import com.qingyunqifu.service.QingYunService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by qqqqqqq on 17-9-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class AdminStuffControllerTest {
    @Autowired
    @Qualifier("QingYunService")
    private QingYunService qingYunService;


    @Test
    public void update() throws Exception {
        Stuffs stuff = qingYunService.findStuffById(16);
        stuff.setName("Test");
        qingYunService.modifyStuff(stuff);
        System.out.println("保存后的商品============>>>>>"+stuff.toString());


    }

}