package com.qingyunqifu.domain;

/**
 * Created by qqqqqqq on 17-9-9.
 */
public class SellerStuffRun {
    Integer id;
    Stuffs stuffs;
    Sellers sellers;

    public SellerStuffRun() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stuffs getStuffs() {
        return stuffs;
    }

    public void setStuffs(Stuffs stuffs) {
        this.stuffs = stuffs;
    }

    public Sellers getSellers() {
        return sellers;
    }

    public void setSellers(Sellers sellers) {
        this.sellers = sellers;
    }


    @Override
    public String toString() {
        return "SellerStuffRun{" +
                "id=" + id +
                ", stuffs=" + stuffs +
                ", sellers=" + sellers +
                '}';
    }
}
