package com.example.slkk.zhihuplus.api;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by slkk on 2016/5/26.
 */
public class HttpLoader {
    private OkHttpClient okHttpClient;
    private HttpLoader (){
        okHttpClient = new OkHttpClient();
    }

    private static HttpLoader instance = new HttpLoader();
    public static HttpLoader getInstance() {
        return instance;
    }

    public String excuteGet(String url) {
        Request requset = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(requset);
        Response response = null;
        ResponseBody body = null;
        String result = null;
        try {
            response = call.execute();
            if (response.isSuccessful()) {
                body = response.body();
                result = body.string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 异步执行get请求
     */
    public void executeGet(String url, Callback callback){
        //Request是请求数据的封装体
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);//创建http请求对象
        //执行异步请求
        call.enqueue(callback);
    }
}
