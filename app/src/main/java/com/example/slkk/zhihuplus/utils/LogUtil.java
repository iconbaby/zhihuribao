package com.example.slkk.zhihuplus.utils;

import android.content.Context;
import android.util.Log;

import com.example.slkk.zhihuplus.global.ZhihuApp;

/**
 * Created by slkk on 2016/5/26.
 */
public class LogUtil {
    private static boolean isDug = true;

    public static void d(String tag, String s) {
        if (isDug) {

            Log.d(tag, s);
        }
    }

    public static void e(String tag, String s) {
        if (isDug) {

            Log.e(tag, s);
        }
    }

    public static void d(Object object, String s) {
        if (isDug) {

            Log.d(object.getClass().getSimpleName(), s);
        }
    }

    public static void e(Object object, String s) {
        if (isDug) {

            Log.e(object.getClass().getSimpleName(), s);
        }
    }
}
