package com.example.networking;

import com.google.gson.annotations.SerializedName;

public class Mountain {

    private String name;
    private String location;

    @SerializedName("size")
    private int height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

