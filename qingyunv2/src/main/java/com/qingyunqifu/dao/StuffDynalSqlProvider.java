package com.qingyunqifu.dao;

import com.qingyunqifu.domain.LittleTypes;
import com.qingyunqifu.domain.Stuffs;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class StuffDynalSqlProvider {
    //动态插入
    public String insertStuff(Stuffs stuffs) {
        return new SQL(){
            {
                INSERT_INTO("stuffs");
                if (stuffs.getName()!=null&&!stuffs.getName().equals(" ")) {
                    VALUES("name", "#{name}");
                }
                if (stuffs.getLittleTypes() != null && !stuffs.getLittleTypes().equals(" ")) {
                    VALUES("little_type", "#{littleTypes.id}");

                }
            }
        }.toString();
    }

    //动态更新
    public String updateStuff(Stuffs stuffs) {

        return new SQL() {
            {
                UPDATE("stuffs");
                if (stuffs.getName() != null) {

                    SET("name = #{name}");
                }
                if (stuffs.getLittleTypes() != null) {
                    SET("little_type = #{littleTypes.id}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
