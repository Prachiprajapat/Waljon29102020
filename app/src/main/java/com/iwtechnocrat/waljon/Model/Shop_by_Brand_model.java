package com.iwtechnocrat.waljon.Model;

public class Shop_by_Brand_model {
    String userimage;
    String price,sample,name,key_id,fav_status,providerId,status;
    int image;


    public Shop_by_Brand_model(String userimage, String price, String sample, String name, String key_id, String fav_status, String providerId, String status, int image) {
        this.userimage = userimage;
        this.price = price;
        this.sample = sample;
        this.name = name;
        this.key_id = key_id;
        this.fav_status = fav_status;
        this.providerId = providerId;
        this.status = status;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUserimage() {
        return userimage;
    }

    public void setUserimage(String userimage) {
        this.userimage = userimage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFav_status() {
        return fav_status;
    }

    public void setFav_status(String fav_status) {
        this.fav_status = fav_status;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}