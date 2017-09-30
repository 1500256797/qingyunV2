package com.qingyunqifu.dao;

import com.qingyunqifu.domain.LittleTypes;
import com.qingyunqifu.domain.SellerStuffRun;
import com.qingyunqifu.domain.Sellers;
import com.qingyunqifu.domain.Stuffs;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class SellerStuffRunDynalSqlProvider {
    //动态插入
    public String insert(SellerStuffRun sellerStuffRun) {
        return new SQL(){
            {
                INSERT_INTO("seller_stuff_run");
                if (sellerStuffRun.getStuffs()!=null&&!sellerStuffRun.equals(" ")) {
                    VALUES("stuff_id", "#{stuffs.id}");
                }
                if (sellerStuffRun.getSellers() != null && !sellerStuffRun.equals(" ")) {
                    VALUES("seller_id", "#{sellers.id}");

                }
            }
        }.toString();
    }

    //动态更新
    public String updata(SellerStuffRun sellerStuffRun) {

        return new SQL() {
            {
                UPDATE("seller_stuff_run");
                if (sellerStuffRun.getStuffs() != null) {

                    SET("stuff_id = #{stuffs.id}");
                }
                if (sellerStuffRun.getSellers() != null) {
                    SET("seller_id = #{sellers.id}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
