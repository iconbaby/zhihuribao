package com.example.slkk.zhihuplus.holder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.example.slkk.zhihuplus.R;
import com.example.slkk.zhihuplus.api.Url;
import com.example.slkk.zhihuplus.bean.AppInfo;
import com.example.slkk.zhihuplus.global.ZhihuApp;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;


public class HomeHolder extends BaseHolder<AppInfo> {
    @Bind(R.id.iv_icon)
    ImageView ivIcon;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.rb_star)
    RatingBar rbStar;
    @Bind(R.id.tv_size)
    TextView tvSize;
    @Bind(R.id.tv_des)
    TextView tvDes;
    @Override
    protected View initHolderView() {
        View view = View.inflate(ZhihuApp.context, R.layout.adapter_home, null);
        return view;
    }

    @Override
    public void bindData(AppInfo appInfo) {
        tvName.setText(appInfo.getName());
        tvSize.setText(Formatter.formatFileSize(ZhihuApp.context, appInfo.getSize()));
        tvDes.setText(appInfo.getDes());
        rbStar.setRating(appInfo.getStars());

        //加载图片
        ImageLoader.getInstance().displayImage(Url.IMAGE_PREFIX + appInfo.getIconUrl(),
                ivIcon, com.example.slkk.zhihuplus.global.ImageLoaderOptions.round_options);
    }
}
