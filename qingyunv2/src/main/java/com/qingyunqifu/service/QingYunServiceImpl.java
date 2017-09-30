package com.qingyunqifu.service;

import com.qingyunqifu.dao.*;
import com.qingyunqifu.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */
@Service("QingYunService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class QingYunServiceImpl implements QingYunService {


    @Autowired
    private MainTypeDao mainTypeDao;


    @Autowired
    private LittleTypeDao littleTypeDao;

    @Autowired
    private StuffDao stuffDao;

    @Autowired
    private SellerStuffRunDao sellerStuffRunDao;


    @Autowired
    private SellerDao sellerDao;


    //主类型服务层编写开始
    @Override
    @Transactional(readOnly = true)
    public List<MainTypes> findAllMainType() {
        List<MainTypes> mainTypes = mainTypeDao.findAllMainType();
        return mainTypes;
    }



    @Override
    @Transactional(readOnly = true)
    public MainTypes findMainTypeById(Integer id) {
        return mainTypeDao.findMainTypeById(id);
    }

    @Override
    public void saveMainType(MainTypes mainType) {
        mainTypeDao.save(mainType);
    }

    @Override
    public void modifyMainType(MainTypes mainType) {
        mainTypeDao.update(mainType);
    }

    @Override
    public void deleteMainTypeById(Integer mainId) {
         mainTypeDao.deleteById(mainId);
    }

    //主类型服务层编写完成
    @Override
    @Transactional(readOnly = true)
    public List<LittleTypes> findAllLittleType() {
        return littleTypeDao.findAllLittleType();
    }

    @Override
    @Transactional(readOnly = true)
    public LittleTypes findLittleTypeById(Integer littleId) {
        return littleTypeDao.findLittleTypeById(littleId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LittleTypes> findAllLittleTypeByMainTypeId(Integer mainId) {
        MainTypes mainType = mainTypeDao.findAllLittleTypeByMainTypeId(mainId);
        return mainType.getLittleTypesList();
    }


    @Override
    public void saveLittleType(LittleTypes littleType) {
        littleTypeDao.save(littleType);
    }

    @Override
    public void modifyLittleType(LittleTypes littleType) {
         littleTypeDao.update(littleType);
    }

    @Override
    public void deleteLittleTypeById(Integer id) {
        littleTypeDao.deleteById(id);
    }

    //根据小类型查询商品大全
    @Override
    @Transactional(readOnly = true)
    public List<Stuffs> findAllStuffsByLittleId(Integer id) {
        LittleTypes littleType = littleTypeDao.findStuffsById(id);
        return littleType.getStuffsList();
    }

    //小类型服务层编写完成




    @Override
    @Transactional(readOnly = true)
    public List<Stuffs> findAllStuffs() {
        return stuffDao.findAllStuffs();
    }

    @Override
    @Transactional(readOnly = true)
    public Stuffs findStuffById(Integer id) {
        return stuffDao.findStuffById(id);
    }


    //新增
    @Override
    public void saveStuff(Stuffs stuff) {
       stuffDao.save(stuff);
    }


    //修改
    @Override
    public void modifyStuff(Stuffs stuff) {
         stuffDao.update(stuff);
    }

    @Override
    public void deleteStuffById(Integer id) {
        stuffDao.deleteById(id);
    }


    //商品服务层编写完成

    @Override
    @Transactional(readOnly = true)
    public List<Sellers> findAllSellersByStuffId(Integer id) {
        return stuffDao.findAllSellersByStuffById(id).getSellersList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Stuffs> findAllStuffsBySellerId(Integer id) {
        return sellerDao.findAllStuffsBySellerId(id).getStuffsList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sellers> findAllSellers() {
        return sellerDao.findAllSellers();
    }

    @Override
    public Sellers findSellerById(Integer id) {
        return sellerDao.findSellerById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public void saveSeller(Sellers seller) {
        sellerDao.save(seller);
    }

    @Override
    public void modifySeller(Sellers seller) {
         sellerDao.update(seller);
    }

    @Override
    public void deleteSellerById(Integer id) {
        sellerDao.deleteById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public List<SellerStuffRun> findAllSellerStuffRun() {
        return sellerStuffRunDao.findAllSellerStuffRun();
    }

    @Override
    public void saveSellerStuffRun(SellerStuffRun sellerStuffRun) {
        sellerStuffRunDao.save(sellerStuffRun);
    }

    @Override
    public void modifySellerStuffRun(SellerStuffRun sellerStuffRun) {
        sellerStuffRunDao.update(sellerStuffRun);
    }


    @Override
    public void deleteSellerStuffRunById(Integer id) {
        sellerStuffRunDao.deleteById(id);
    }

    @Override
    public SellerStuffRun findSellerStuffRunById(Integer id) {
        return sellerStuffRunDao.findSellerStuffRunById(id);
    }

    //所有服务层代码编写结束

}
