package com.example.slkk.zhihuplus.bean;

import java.util.ArrayList;

public class Home {
    private ArrayList<String> picture;//首页的ViewPager的图片
    private ArrayList<AppInfo> list;//列表数据

    public ArrayList<String> getPicture() {
        return picture;
    }

    public void setPicture(ArrayList<String> picture) {
        this.picture = picture;
    }

    public ArrayList<AppInfo> getList() {
        return list;
    }

    public void setList(ArrayList<AppInfo> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Home{" +
                "picture=" + picture.size() +
                ", list=" + list.size() +
                '}';
    }
}
