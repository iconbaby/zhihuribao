package com.example.slkk.zhihuplus.bean;


import android.support.v4.app.Fragment;

/**
 * Created by slkk on 2016/5/26.
 */
public class PageInfo {
    public String title;
    public Fragment fragment;

    public PageInfo(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }
}
