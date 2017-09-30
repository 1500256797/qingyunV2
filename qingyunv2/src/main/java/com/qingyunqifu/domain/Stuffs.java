package com.qingyunqifu.domain;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class Stuffs {
    Integer id;
    String name;
    //一种商品只属于一种类别
    LittleTypes littleTypes;


    //一种商品可以被多家经营
    List<Sellers> sellersList;

    public Stuffs() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LittleTypes getLittleTypes() {
        return littleTypes;
    }

    public void setLittleTypes(LittleTypes littleTypes) {
        this.littleTypes = littleTypes;
    }


    public List<Sellers> getSellersList() {
        return sellersList;
    }

    public void setSellersList(List<Sellers> sellersList) {
        this.sellersList = sellersList;
    }

    @Override
    public String toString() {
        return "Stuffs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", littleTypes=" + littleTypes +
                '}';
    }
}
