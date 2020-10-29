package com.iwtechnocrat.waljon.Model;

public class CartModel {
    String id,shopname,gender,size,qnty,total_price,off;
     int image;
    public CartModel(String id, int image, String shopname, String gender, String size, String qnty, String total_price, String off) {
        this.id = id;
        this.image = image;
        this.shopname = shopname;
        this.gender = gender;
        this.size = size;
        this.qnty = qnty;
        this.total_price = total_price;
        this.off = off;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQnty() {
        return qnty;
    }

    public void setQnty(String qnty) {
        this.qnty = qnty;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getOff() {
        return off;
    }

    public void setOff(String off) {
        this.off = off;
    }
}
