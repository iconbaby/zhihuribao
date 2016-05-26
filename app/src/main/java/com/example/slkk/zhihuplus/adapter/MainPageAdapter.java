package com.example.slkk.zhihuplus.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.slkk.zhihuplus.bean.PageInfo;

import java.util.List;


public class MainPageAdapter extends FragmentPagerAdapter {
    private List<PageInfo> list;
    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public MainPageAdapter(FragmentManager fm, List<PageInfo> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position).fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).title;
    }
}
