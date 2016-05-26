package com.example.slkk.zhihuplus.api;


public interface Url {
    //服务器主机
    String SERVER_HOST = "http://127.0.0.1:8090/";
//    String SERVER_HOST = "http://117.2.2.3:8090/";//外网主机
    //图片URL前缀
    String IMAGE_PREFIX = SERVER_HOST + "image?name=";

    //首页的接口地址
    String Home = SERVER_HOST + "home?index=";
    //专题的接口地址
    String Subject = SERVER_HOST + "subject?index=";
    //推荐界面的接口地址
    String Recommend = SERVER_HOST + "recommend?index=0";
    //分类界面的接口地址
    String Category = SERVER_HOST + "category?index=0";
    //热门标签界面的接口地址
    String Hot = SERVER_HOST + "hot?index=0";
}
