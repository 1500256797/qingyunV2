package com.qingyunqifu.dao;

import com.qingyunqifu.domain.LittleTypes;
import com.qingyunqifu.domain.MainTypes;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */
@Mapper
public interface LittleTypeDao {
    @Select(" Select * from little_types ")
    @Results(
            value = {
                    @Result(column = "id",property = "id"),
                    @Result(column = "type_name",property = "typeName"),
                    @Result(column = "main_type",property = "mainTypes",one = @One(select = "com.qingyunqifu.dao.MainTypeDao.findMainTypeById",fetchType = FetchType.EAGER))
            }
    )
    List<LittleTypes> findAllLittleType();


    @Select(" select * from little_types where id = #{id} ")
    @Results(
            value = {
                    @Result(column = "id",property = "id"),
                    @Result(column = "type_name",property = "typeName"),
                    //用main_type（id）当作参数传到findMainTypeById中进行查询，然后将查询结果赋值给mainTypes
                    @Result(column = "main_type",property = "mainTypes",one = @One(select = "com.qingyunqifu.dao.MainTypeDao.findMainTypeById",fetchType = FetchType.EAGER))

            }
    )
    LittleTypes findLittleTypeById(Integer id);

    @Select(" select * from little_types where main_type = #{id} ")
    @Results(
            value = {
                    @Result(column = "id",property = "id"),
                    @Result(column = "type_name",property = "typeName"),
                    //用main_type（id）当作参数传到findMainTypeById中进行查询，然后将查询结果赋值给mainTypes
                    @Result(column = "main_type",property = "mainTypes",one = @One(select = "com.qingyunqifu.dao.MainTypeDao.findMainTypeById",fetchType = FetchType.EAGER))

            }
    )
    LittleTypes findLittleTypeByMainTypeId(Integer id);

    //动态插入
    @InsertProvider(type = LittleTypeDynalSqlProvider.class,method = "insertLittleType")
    void save(LittleTypes littleTypes);


    //动态更新
    @UpdateProvider(type = LittleTypeDynalSqlProvider.class, method = "updateLittleType")
    void update(LittleTypes littleTypes);


    //根据id删除
    @Delete("delete from   little_types   where id =#{id}")
    void deleteById(Integer id);

    //根据小类别下的所有商品
    @Select(" select * from little_types where id = #{id} ")
    @Results(
            value = {
                    @Result(column = "id",property = "id"),
                    @Result(column = "type_name",property = "typeName"),
                    @Result(column = "main_type",property = "mainTypes",one = @One(select = "com.qingyunqifu.dao.MainTypeDao.findMainTypeById",fetchType = FetchType.EAGER)),
                    @Result(column = "id",property = "stuffsList",
                    many = @Many(
                            select = "com.qingyunqifu.dao.StuffDao.findStuffsByLittleTypeId",
                            fetchType = FetchType.LAZY
                    ))
            }
    )
    LittleTypes findStuffsById(Integer id);

}
