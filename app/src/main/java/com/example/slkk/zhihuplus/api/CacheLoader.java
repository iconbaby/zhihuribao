package com.example.slkk.zhihuplus.api;

import android.os.Environment;

import com.example.slkk.zhihuplus.global.ZhihuApp;
import com.example.slkk.zhihuplus.utils.MD5Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by slkk on 2016/5/26.
 */
public class CacheLoader {
    private static String CACHE_DIR = Environment
            .getExternalStorageDirectory()
            .getAbsolutePath()
            + File.separator + ZhihuApp.context
            .getPackageName() + File.separator
            + "cache";
    private CacheLoader() {
        File cacheDir = new File(CACHE_DIR);
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
    }

    private static CacheLoader cacheLoader = new CacheLoader();
    public static CacheLoader getInstance() {
        return cacheLoader;
    }

    public String getCacheData(String url) {
        File file = buidCacheFile(url);
        StringBuilder builder = new StringBuilder();
        if (file.exists()) {
            try {

                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }

    public void saveCacheData(String url, String result) {
        File file = buidCacheFile(url);
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write(result);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public File buidCacheFile(String url){

        return new File(CACHE_DIR, MD5Util.digest(url));
    }
}
