package com.qingyunqifu.domain;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class LittleTypes {
    Integer id;
    String typeName;
    MainTypes mainTypes;

    //一个小分类下面有很多商品
    List<Stuffs> stuffsList;


    public LittleTypes() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public MainTypes getMainTypes() {
        return mainTypes;
    }

    public void setMainTypes(MainTypes mainTypes) {
        this.mainTypes = mainTypes;
    }

    public List<Stuffs> getStuffsList() {
        return stuffsList;
    }

    public void setStuffsList(List<Stuffs> stuffsList) {
        this.stuffsList = stuffsList;
    }

    @Override
    public String toString() {
        return "LittleTypes{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", mainTypes=" + mainTypes +
                '}';
    }
}
