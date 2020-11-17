package com.iwtechnocrat.waljon.Model;

import org.json.JSONArray;

public class HomeCatModel {
    String name,id,detail;



    JSONArray sub_array = new JSONArray();

    public JSONArray getSub_array() {
        return sub_array;
    }

    public void setSub_array(JSONArray sub_array) {
        this.sub_array = sub_array;
    }
    public HomeCatModel(String name, String id, String detail) {
        this.name = name;
        this.id = id;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
