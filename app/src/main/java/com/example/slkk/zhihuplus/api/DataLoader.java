package com.example.slkk.zhihuplus.api;

import android.util.Log;

import com.example.slkk.zhihuplus.utils.GsonUtil;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by slkk on 2016/5/26.
 */
public class DataLoader {

    public static final String TAG = "DataLoader";

    private DataLoader() {
    }

    private static DataLoader mInstance = new DataLoader();

    public static DataLoader getInstance() {

        return mInstance;
    }

    public <T> T loadBeanData(String url, Class<T> clazz) {
        //优先从网络加载
        String result = HttpLoader.getInstance().excuteGet(url);
        if (result == null) {
            result = CacheLoader.getInstance().getCacheData(url);
        } else {
            CacheLoader.getInstance().saveCacheData(url, result);

        }

        if (result != null) {
            return GsonUtil.parseJsonToBean(result, clazz);
        } else {

            return null;
        }

    }


    /**
     * 加载bean类型数据
     * @param url
     * @return
     */
    public List<?> loadListData(String url, Type type){
        //1.优先从网络加载数据
        String result = HttpLoader.getInstance().excuteGet(url);
        //2.如果网络为空，则尝试加载本地缓存数据
        if(result==null){
            result = CacheLoader.getInstance().getCacheData(url);
            Log.e(TAG, "loadBeanData: 从缓存取出数据");
        }else {
            //3.如果网络数据不为空，则将数据更新至本地缓存;
            CacheLoader.getInstance().saveCacheData(url,result);
            Log.e(TAG, "loadBeanData: 将数据存入缓存");
        }

        //4.如果result的json数据不是空，则进行解析后返回
        if(result!=null){
            //使用Gson解析json,解析为一个集合
            return GsonUtil.parseJsonToList(result,type);
        }else {
            return null;
        }
    }
}
