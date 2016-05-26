package com.example.slkk.zhihuplus.global;


import com.example.slkk.zhihuplus.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;


public interface ImageLoaderOptions {

    //圆角的显示效果的options
    DisplayImageOptions  round_options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.ic_launcher)//设置加载过程中显示的图片
            .showImageForEmptyUri(R.mipmap.ic_launcher)//url为空显示的图片
            .showImageOnFail(R.mipmap.ic_launcher)//加载失败显示的图片
            .cacheInMemory(true)
            .cacheOnDisk(true)
//              .considerExifParams(true)//会识别图片的方向信息
//              .displayer(new FadeInBitmapDisplayer(1000)).build();//设置渐渐显示的效果
            .displayer(new RoundedBitmapDisplayer(30)).build();//设置圆角的显示效果

    //带有渐渐显示效果的options
    DisplayImageOptions  options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.ic_launcher)//设置加载过程中显示的图片
            .showImageForEmptyUri(R.mipmap.ic_launcher)//url为空显示的图片
            .showImageOnFail(R.mipmap.ic_launcher)//加载失败显示的图片
            .cacheInMemory(true)
            .cacheOnDisk(true)
//          .considerExifParams(true)//会识别图片的方向信息
            .displayer(new FadeInBitmapDisplayer(1000)).build();//设置渐渐显示的效果
//          .displayer(new RoundedBitmapDisplayer(30)).build();//设置圆角的显示效果
}
