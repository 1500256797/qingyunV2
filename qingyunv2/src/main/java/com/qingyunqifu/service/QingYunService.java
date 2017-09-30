package com.qingyunqifu.service;

import com.qingyunqifu.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */
@Service("QingYunService")
public interface QingYunService {

    //查询所有大类
    List<MainTypes> findAllMainType();

    //查询指定大类下的小类
    List<LittleTypes> findAllLittleTypeByMainTypeId(Integer mainId);

    //根据id查询大类
    MainTypes findMainTypeById(Integer id);

    //增加大类
    void saveMainType(MainTypes mainType);

    //修改大类
    void modifyMainType(MainTypes mainType);

    //根据id删除大类
    void deleteMainTypeById(Integer mainId);


    //获取所有小类型
    List<LittleTypes> findAllLittleType();

    //根据id查寻小类型
    LittleTypes findLittleTypeById(Integer littleId);


    //新增小类型
    void saveLittleType(LittleTypes littleType);

    //修改小类型
    void modifyLittleType(LittleTypes littleType);

    //删除小类型
    void deleteLittleTypeById(Integer id);

    //查询小类型下的全部商品
    List<Stuffs> findAllStuffsByLittleId(Integer id);


    List<Stuffs> findAllStuffs();


    Stuffs findStuffById(Integer id);

    //新增
    void saveStuff(Stuffs stuff);

    //更新商品信息
    void modifyStuff(Stuffs stuff);

    void deleteStuffById(Integer id);



    //找到经营同一产品的所有商家
    List<Sellers> findAllSellersByStuffId(Integer id);

    //找到一家商家的全部商品
    List<Stuffs> findAllStuffsBySellerId(Integer id);


    List<Sellers> findAllSellers();

    Sellers findSellerById(Integer id);

    void saveSeller(Sellers seller );

    void modifySeller(Sellers seller);

    void deleteSellerById(Integer id);


    //查询所有商品卖家对应表
    List<SellerStuffRun> findAllSellerStuffRun();

    //新增商品卖家对应表
    void saveSellerStuffRun(SellerStuffRun sellerStuffRun);

    //修改商品商家中间表
    void modifySellerStuffRun(SellerStuffRun sellerStuffRun);

    //删除
    void deleteSellerStuffRunById(Integer id);

    //根据id查询经营关系
    SellerStuffRun findSellerStuffRunById(Integer id);



}


