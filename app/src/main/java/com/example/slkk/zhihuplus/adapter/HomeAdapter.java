package com.example.slkk.zhihuplus.adapter;


import com.example.slkk.zhihuplus.bean.Home;
import com.example.slkk.zhihuplus.bean.Stories;
import com.example.slkk.zhihuplus.holder.BaseHolder;
import com.example.slkk.zhihuplus.holder.HomeHolder;

import java.util.ArrayList;


public class HomeAdapter extends BasicAdapter<Stories> {
    public HomeAdapter(ArrayList<Stories> list) {
        super(list);
    }

    @Override
    protected BaseHolder<Stories> getHolder(int position) {
        return new HomeHolder();
    }

}
