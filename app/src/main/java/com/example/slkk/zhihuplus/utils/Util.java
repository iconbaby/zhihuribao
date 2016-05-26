package com.example.slkk.zhihuplus.utils;

import android.util.Log;

import com.example.slkk.zhihuplus.global.ZhihuApp;



/**
 * Created by slkk on 2016/5/26.
 */
public class Util {

    public static String[] getStringArray(int id) {
        return ZhihuApp.context.getResources().getStringArray(id);
    }

    public static void runOnUIThread(Runnable runnable){
        ZhihuApp.handler.post(runnable);
    }
}
