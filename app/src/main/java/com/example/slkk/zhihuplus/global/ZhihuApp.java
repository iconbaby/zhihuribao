package com.example.slkk.zhihuplus.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by slkk on 2016/5/26.
 */
public class ZhihuApp extends Application{
    public static Context context;
    public static Handler handler;



    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        this.handler = new Handler();
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));

    }
}
