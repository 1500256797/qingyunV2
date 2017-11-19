package com.qingyunqifu.dao;

import com.qingyunqifu.domain.MainTypes;
import com.qingyunqifu.domain.Sellers;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class SellerBynalSqlProvider {
    //根据参数查找
    public String selectSellersWithParam(Map<String ,Object> param){
        return new SQL() {
            {
                SELECT("*");
                FROM("sellers");
                if (param.get("seller") != null) {
                    Sellers seller = (Sellers) param.get("seller");
                    if (seller.getProvince() != null&&!seller.getProvince().equals(" ")) {
                        WHERE("province LIKE CONCAT ('%',#{seller.province},'%')");
                    }

                    if (seller.getCity() != null&&!seller.getCity().equals(" ")) {
                        WHERE("city LIKE CONCAT ('%',#{seller.city},'%')");
                    }

                    if (seller.getVip() != null&&!seller.getVip().equals(" ")) {
                        WHERE("vip = #{seller.vip} ");
                    }



                }
            }
        }.toString();

    }



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
                if (seller.getVip() != null && !seller.getVip().equals(" ")) {
                    VALUES("vip", "#{vip}");
                }
                if (seller.getProvince() != null && !seller.getProvince().equals(" ")) {
                    VALUES("province", "#{province}");
                }
                if (seller.getCity() != null && !seller.getCity().equals(" ")) {
                    VALUES("city", "#{city}");
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
                if (seller.getImgurl() != null && !seller.getImgurl().equals(" ")) {
                    VALUES("img_url", "#{imgurl}");
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
                if (seller.getVip() != null) {
                    SET("vip = #{vip}");
                }
                if (seller.getProvince() != null ) {
                    SET("province = #{province}");
                }
                if (seller.getCity() != null ) {
                    SET("city = #{city}");
                }
                if (seller.getAddress() != null ) {
                    SET("address = #{address}");
                }

                if (seller.getRemark() != null ) {
                    SET("remark = #{remark}");
                }
                if (seller.getImgurl() != null ) {
                    SET("img_url = #{imgurl}");
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
