package com.qingyunqifu.dao;

import com.qingyunqifu.domain.LittleTypes;
import com.qingyunqifu.domain.MainTypes;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class LittleTypeDynalSqlProvider {
    //动态插入
    public String insertLittleType(LittleTypes littleTypes) {
        return new SQL(){
            {
                INSERT_INTO("little_types");
                if (littleTypes.getTypeName()!=null&&!littleTypes.getTypeName().equals(" ")) {
                    VALUES("type_name", "#{typeName}");
                }
                if (littleTypes.getMainTypes() != null && !littleTypes.getMainTypes().equals(" ")) {
                    VALUES("main_type", "#{mainTypes.id}");

                }
            }
        }.toString();
    }

    //动态更新
    public String updateLittleType(LittleTypes littleTypes) {

        return new SQL() {
            {
                UPDATE("little_types");
                if (littleTypes.getTypeName() != null) {

                    SET("type_name = #{typeName}");
                }
                if (littleTypes.getMainTypes() != null) {
                    SET("main_type = #{mainTypes.id}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
