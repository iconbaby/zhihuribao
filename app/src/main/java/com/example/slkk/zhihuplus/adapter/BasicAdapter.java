package com.example.slkk.zhihuplus.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.example.slkk.zhihuplus.holder.BaseHolder;

import java.util.ArrayList;


public abstract class BasicAdapter<T> extends BaseAdapter {

    protected ArrayList<T> list;
    public BasicAdapter(ArrayList<T> list) {
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder<T> baseHolder = null;
        if (convertView == null) {
            baseHolder = getHolder(position);//获取一个holder，子类返回不同的holder
        }else {
            //直接从tag取出holder
            baseHolder = (BaseHolder) convertView.getTag();
        }

        //获取数据
        T t = list.get(position);
        //绑定数据
        baseHolder.bindData(t);

        //返回的时候就需要返回holder内部的convertView
        return baseHolder.getHolderView();
    }

    protected abstract BaseHolder<T> getHolder(int position);
}
