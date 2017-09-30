package com.qingyunqifu.dao;

import com.qingyunqifu.domain.MainTypes;
import com.qingyunqifu.domain.Sellers;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */


@Mapper
public interface SellerDao {

    @Select(" Select * from sellers ")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "manager_name", property = "managerName"),
            @Result(column = "tel", property = "tel"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "qq_num", property = "qqNum"),
            @Result(column = "address", property = "address"),
            @Result(column = "remark", property = "remark"),
            @Result(column = "sell_arrange", property = "sellArrange")
    })
    List<Sellers> findAllSellers();



    @Select(" select * from sellers where id = #{id} ")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "manager_name", property = "managerName"),
            @Result(column = "tel", property = "tel"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "qq_num", property = "qqNum"),
            @Result(column = "address", property = "address"),
            @Result(column = "remark", property = "remark"),
            @Result(column = "sell_arrange", property = "sellArrange")
    })
    Sellers findSellerById(Integer id);

    //动态插入
    @SelectProvider(type = SellerBynalSqlProvider.class,method = "insertSeller")
    void save(Sellers seller);


    //动态更新
    @SelectProvider(type = SellerBynalSqlProvider.class, method = "updateSeller")
    void update(Sellers seller);


    //根据id删除
    @Delete("delete from   main_types   where id =#{id}")
    void deleteById(Integer id);

    //根据商品id查询商家
    @Select(" select * from sellers where id in ( select seller_id from seller_stuff_run where stuff_id = #{stuff_id} ) ")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "manager_name", property = "managerName"),
            @Result(column = "tel", property = "tel"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "qq_num", property = "qqNum"),
            @Result(column = "address", property = "address"),
            @Result(column = "remark", property = "remark"),
            @Result(column = "sell_arrange", property = "sellArrange")
    })
    List<Sellers> findAllSellersByStuffById(Integer stuff_id);


    //查询商家经营的全部商品
    @Select(" select * from sellers where id=#{id} ")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "manager_name", property = "managerName"),
            @Result(column = "tel", property = "tel"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "qq_num", property = "qqNum"),
            @Result(column = "address", property = "address"),
            @Result(column = "remark", property = "remark"),
            @Result(column = "sell_arrange", property = "sellArrange"),
            @Result(column = "id",property = "stuffsList",many = @Many(select = "com.qingyunqifu.dao.StuffDao.findAllStuffsBySellerId" ,fetchType = FetchType.LAZY))
    })
    Sellers findAllStuffsBySellerId(Integer id);


}
