package com.qingyunqifu.dao;

import com.qingyunqifu.domain.MainTypes;
import com.qingyunqifu.domain.Sellers;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class SellerBynalSqlProvider {
    //动态插入

    public String insertSeller(Sellers seller) {
        return new SQL() {
            {
                INSERT_INTO("sellers");
                if (seller.getName() != null && !seller.getName().equals("")) {
                    VALUES("name", "#{name}");
                }
                if (seller.getManagerName() != null && !seller.getManagerName().equals(" ")) {
                    VALUES("manager_name", "#{managerName}");
                }
                if (seller.getTel() != null && !seller.getTel().equals(" ")) {
                    VALUES("tel", "#{tel}");
                }
                if (seller.getPhone() != null && !seller.getPhone().equals(" ")) {
                    VALUES("phone", "#{phone}");
                }
                if (seller.getQqNum() != null && !seller.getQqNum().equals(" ")) {
                    VALUES("qq_num", "#{qqNum}");
                }
                if (seller.getAddress() != null && !seller.getAddress().equals(" ")) {
                    VALUES("address", "#{address}");
                }

                if (seller.getRemark() != null && !seller.getRemark().equals(" ")) {
                    VALUES("remark", "#{remark}");
                }
                if (seller.getSellArrange() != null && !seller.getSellArrange().equals(" ")) {
                    VALUES("sell_arrange", "#{sellArrange}");
                }
            }
        }.toString();
    }


    //动态更新
    public String updateSeller(Sellers seller) {
        return new SQL() {
            {
                UPDATE("sellers");

                //if begin

                if (seller.getName() != null) {
                    SET("name = #{name}");
                }
                if (seller.getManagerName() != null) {
                    SET("manager_name = #{managerName}");
                }
                if (seller.getTel() != null ) {
                    SET("tel = #{tel}");
                }
                if (seller.getPhone() != null ) {
                    SET("phone = #{phone}");
                }
                if (seller.getQqNum() != null) {
                    SET("qq_num = #{qqNum}");
                }
                if (seller.getAddress() != null ) {
                    SET("address = #{address}");
                }

                if (seller.getRemark() != null ) {
                    SET("remark = #{remark}");
                }
                if (seller.getSellArrange() != null ) {
                    SET("sell_arrange  = #{sellArrange}");
                }

                //if end
                WHERE("id=#{id}");
            }
        }.toString();
    }

}
