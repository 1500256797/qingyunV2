package com.qingyunqifu.dao;

import com.qingyunqifu.domain.MainTypes;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */
@Mapper
public interface MainTypeDao {

    @Select(" Select * from main_types ")
    @Results(
            value = {
                    @Result(column = "type_name",property = "typeName")
            }
    )
    List<MainTypes> findAllMainType();



    @Select(" select * from main_types where id = #{id} ")
    @Results({
            @Result(column = "type_name",property = "typeName")
    })
    MainTypes findMainTypeById(Integer id);

    //动态插入
    @InsertProvider(type = MainTypeDynalSqlProvider.class,method = "insertMainType")
    void save(MainTypes mainTypes);


    //动态更新
    @UpdateProvider(type = MainTypeDynalSqlProvider.class, method = "updateMainType")
    void update(MainTypes mainTypes);


    //根据id删除
    @Delete("delete from   main_types   where id =#{id}")
    void deleteById(Integer id);

    //查询大类型下的小类型
    @Select(" select * from main_types where id = #{id} ")
    @Results(
            value = {
                    @Result(column = "id",property = "id"),
                    @Result(column = "type_name",property = "typeName"),
                    @Result(column = "id",property = "littleTypesList",
                            many = @Many(
                                    select = "com.qingyunqifu.dao.LittleTypeDao.findLittleTypeByMainTypeId",
                                    fetchType = FetchType.LAZY
                            ))
            }
    )
    MainTypes findAllLittleTypeByMainTypeId(Integer id);

}
