package com.qingyunqifu.dao;

import com.qingyunqifu.domain.LittleTypes;
import com.qingyunqifu.domain.Stuffs;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */
@Mapper
public interface StuffDao {
    @Select(" Select * from stuffs ")
    @Results(
            value = {
                    @Result(column = "name",property = "name"),
                    @Result(column = "little_type",property = "littleTypes",one = @One(select = "com.qingyunqifu.dao.LittleTypeDao.findLittleTypeById",fetchType = FetchType.EAGER))
            }
    )
    List<Stuffs> findAllStuffs();


    @Select(" select * from stuffs where id = #{id} ")
    @Results(
            value = {
                    @Result(column = "name",property = "name"),
                    @Result(column = "little_type",property = "littleTypes",one = @One(select = "com.qingyunqifu.dao.LittleTypeDao.findLittleTypeById",fetchType = FetchType.EAGER))


            }
    )
    Stuffs findStuffById(Integer id);

    //动态插入
    @InsertProvider(type = StuffDynalSqlProvider.class,method = "insertStuff")
    void save(Stuffs stuffs);


    //动态更新
    @UpdateProvider(type = StuffDynalSqlProvider.class, method = "updateStuff")
    void update(Stuffs stuffs);


    //根据id删除
    @Delete("delete from   stuffs   where id =#{id}")
    void deleteById(Integer id);

    //根据类别查询stuff
    @Select(" select * from stuffs where little_type = #{id}")
    @Results({
            @Result(column = "name",property = "name"),
            @Result(column = "little_type",property = "littleTypes",one = @One(select = "com.qingyunqifu.dao.LittleTypeDao.findLittleTypeById",fetchType = FetchType.EAGER))

    })
    List<Stuffs> findStuffsByLittleTypeId(Integer id);


    //根据商品查商家（多对多关系）
    @Select(" select * from stuffs where id = #{id} ")
    @Results({
            @Result(id = true , column = "id" ,property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "little_type",property = "littleTypes", one = @One(select = "com.qingyunqifu.dao.LittleTypeDao.findLittleTypeById",fetchType = FetchType.EAGER)),
            //这里取得商品id后，再去经营表里取得商家id。。。。
            @Result(column = "id",property = "sellersList", many = @Many(select = "com.qingyunqifu.dao.SellerDao.findAllSellersByStuffById",fetchType = FetchType.LAZY))
    })
    Stuffs findAllSellersByStuffById(Integer id);


    //根据商家id查询全部商品
    @Select(" select * from stuffs where id in ( select stuff_id from seller_stuff_run where seller_id = #{seller_id} ) ")
    @Results({
            @Result(column = "name",property = "name"),
            @Result(column = "little_type",property = "littleTypes",one = @One(select = "com.qingyunqifu.dao.SellerDao.findAllStuffsBySellerId",fetchType = FetchType.EAGER))

    })
    List<Stuffs> findAllStuffsBySellerId(Integer seller_id);

}
