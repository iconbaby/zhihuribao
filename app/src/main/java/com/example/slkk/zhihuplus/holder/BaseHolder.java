package com.example.slkk.zhihuplus.holder;

import android.view.View;

import butterknife.ButterKnife;


public abstract class BaseHolder<T> {
    View convertView;

    public BaseHolder(){
        //1.初始化convertView
        //2.初始化控件
        convertView = initHolderView();
        //绑定View
        ButterKnife.bind(this,convertView);

        //3.设置tag
        convertView.setTag(this);
    }

    /**
     * 初始化holderView
     * @return
     */
    protected abstract View initHolderView();

    /**
     * 绑定数据
     * @param data
     */
    public abstract void bindData(T data);

    /**
     * 获取convertView
     * @return
     */
    public View getHolderView(){
        return convertView;
    }
}
