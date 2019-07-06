package com.cn.springboot04web.entities;

import java.util.ArrayList;

public class Series<T> {
    //String stack
    String name;
    String type;
    ArrayList<T> data;

    public Series(String name, String type, ArrayList<T> data) {
        this.name=name;
        this.type=type;
        this.data=data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public ArrayList<T> getData() {
        return data;
    }
}
