package com.qingyunqifu.dao;

import com.qingyunqifu.domain.MainTypes;
import com.qingyunqifu.domain.SellerStuffRun;
import com.qingyunqifu.domain.Sellers;
import com.qingyunqifu.domain.Stuffs;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */
@Mapper
public interface SellerStuffRunDao {
    @Select(" Select * from seller_stuff_run ")
    @Results(
            value = {
                    @Result(column = "stuff_id",property = "stuffs",one = @One(select = "com.qingyunqifu.dao.StuffDao.findStuffById",fetchType = FetchType.EAGER)),
                    @Result(column = "seller_id",property = "sellers",one = @One(select = "com.qingyunqifu.dao.SellerDao.findSellerById",fetchType = FetchType.EAGER))
            }
    )
    List<SellerStuffRun> findAllSellerStuffRun();

    @Select(" select * from seller_stuff_run where id=#{id} ")
    SellerStuffRun findSellerStuffRunById(Integer id);

    //动态插入
    @SelectProvider(type = SellerStuffRunDynalSqlProvider.class,method = "insert")
    void save(SellerStuffRun sellerStuffRun);



    //动态更新
    @SelectProvider(type = SellerStuffRunDynalSqlProvider.class, method = "updata")
    void update(SellerStuffRun sellerStuffRun);


    //根据id删除
    @Delete("delete from   seller_stuff_run   where id =#{id}")
    void deleteById(Integer id);


}
