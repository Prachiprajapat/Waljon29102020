package com.iwtechnocrat.waljon.Model;

public class OrderCompleteModel {
    String id,delivery_status,date,productname,description, size;
    int image;

    public OrderCompleteModel(String id, String delivery_status, String date, String productname, String description, String size, int image) {
        this.id = id;
        this.delivery_status = delivery_status;
        this.date = date;
        this.productname = productname;
        this.description = description;
        this.size = size;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
