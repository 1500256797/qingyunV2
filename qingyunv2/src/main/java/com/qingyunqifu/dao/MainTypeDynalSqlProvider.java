package com.qingyunqifu.dao;

import com.qingyunqifu.domain.MainTypes;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class MainTypeDynalSqlProvider {
    //动态插入
    public String insertMainType(MainTypes mainTypes) {
        return new SQL(){
            {
                INSERT_INTO("main_types");
                if (mainTypes.getTypeName()!=null&&!mainTypes.equals(" ")) {
                    VALUES("type_name", "#{typeName}");
                }
            }
        }.toString();
    }

    //动态更新
    public String updateMainType(MainTypes mainTypes) {
        return new SQL() {
            {
                UPDATE("main_types");
                if (mainTypes.getTypeName() != null) {

                    SET("type_name =#{typeName}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
