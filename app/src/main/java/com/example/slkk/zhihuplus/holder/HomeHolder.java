package com.example.slkk.zhihuplus.holder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.example.slkk.zhihuplus.R;
import com.example.slkk.zhihuplus.api.Url;
import com.example.slkk.zhihuplus.bean.Home;
import com.example.slkk.zhihuplus.bean.Stories;
import com.example.slkk.zhihuplus.global.ZhihuApp;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;


public class HomeHolder extends BaseHolder<Stories> {

    private TextView tv;
    private ImageView iv;

    protected View initHolderView() {
        View view = View.inflate(ZhihuApp.context, R.layout.adapter_home, null);
        tv = (TextView) view.findViewById(R.id.home_desc);
        iv = (ImageView) view.findViewById(R.id.home_iv);
        return view;
    }

    @Override
    public void bindData(Stories stories) {
        tv.setText(stories.getTitle());
        //加载图片
        ImageLoader.getInstance().displayImage(stories.getImages().get(0),
                iv, com.example.slkk.zhihuplus.global.ImageLoaderOptions.options);
    }
}
