package com.qingyunqifu.domain;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class Sellers {
    Integer id;
    String name;
    String managerName;
    String tel;
    String phone;
    String qqNum;
    String address;
    String remark;
    String sellArrange;

    //一个商家可以经营多个产品
    List<Stuffs> stuffsList;
    public Sellers() {
    }

    public List<Stuffs> getStuffsList() {
        return stuffsList;
    }

    public void setStuffsList(List<Stuffs> stuffsList) {
        this.stuffsList = stuffsList;
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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSellArrange() {
        return sellArrange;
    }

    public void setSellArrange(String sellArrange) {
        this.sellArrange = sellArrange;
    }


    @Override
    public String toString() {
        return "Sellers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", tel='" + tel + '\'' +
                ", phone='" + phone + '\'' +
                ", qqNum='" + qqNum + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", sellArrange='" + sellArrange + '\'' +
                '}';
    }
}
