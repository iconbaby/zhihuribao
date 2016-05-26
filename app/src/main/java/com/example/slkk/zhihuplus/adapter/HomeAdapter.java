package com.example.slkk.zhihuplus.adapter;


import com.example.slkk.zhihuplus.holder.BaseHolder;
import com.example.slkk.zhihuplus.bean.AppInfo;
import com.example.slkk.zhihuplus.holder.HomeHolder;

import java.util.ArrayList;


public class HomeAdapter extends BasicAdapter<AppInfo> {
    public HomeAdapter(ArrayList<AppInfo> list) {
        super(list);
    }

    @Override
    protected BaseHolder<AppInfo> getHolder(int position) {
        return new HomeHolder();
    }

}
