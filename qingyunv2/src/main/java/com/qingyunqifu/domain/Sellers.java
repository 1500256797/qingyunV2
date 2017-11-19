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
    String province ;
    String city;
    String address;
    String remark;
    String sellArrange;
    Integer vip;
    String imgurl;
    //一个商家可以经营多个产品
    List<Stuffs> stuffsList;
    public Sellers() {
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public List<Stuffs> getStuffsList() {
        return stuffsList;
    }

    public void setStuffsList(List<Stuffs> stuffsList) {
        this.stuffsList = stuffsList;
    }

    @Override
    public String toString() {
        return "Sellers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", tel='" + tel + '\'' +
                ", phone='" + phone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", sellArrange='" + sellArrange + '\'' +
                ", vip=" + vip +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}
