package com.qingyunqifu.domain;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class MainTypes {
    Integer id;
    String typeName;

    List<LittleTypes> littleTypesList;

    public MainTypes() {
    }


    public List<LittleTypes> getLittleTypesList() {
        return littleTypesList;
    }

    public void setLittleTypesList(List<LittleTypes> littleTypesList) {
        this.littleTypesList = littleTypesList;
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

    @Override
    public String toString() {
        return "MainTypes{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
