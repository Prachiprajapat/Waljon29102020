package com.iwtechnocrat.waljon.Model;

public class TopCategoriesModel {
    int image;
    String id,name;

    public TopCategoriesModel(int image, String id, String name) {
        this.image = image;
        this.id = id;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
