package com.example.slkk.zhihuplus.ui.fragment;


import android.view.View;
import android.widget.ListView;

import com.example.slkk.zhihuplus.R;
import com.example.slkk.zhihuplus.adapter.HomeAdapter;
import com.example.slkk.zhihuplus.api.DataLoader;
import com.example.slkk.zhihuplus.api.Url;
import com.example.slkk.zhihuplus.bean.Home;
import com.example.slkk.zhihuplus.bean.Stories;
import com.example.slkk.zhihuplus.utils.Util;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;


import java.util.ArrayList;

/**
 * Created by slkk on 2016/5/26.
 */
public class HomeFragent extends BaseFragment implements PullToRefreshBase.OnRefreshListener {

    private PullToRefreshListView refreshListView;
    private ListView listView;
    private ArrayList<Stories> list = new ArrayList<>();
    private HomeAdapter homeAdapter;

    @Override
    protected View getSuccessView() {
//        listView = (ListView) View.inflate(getActivity(), R.layout.listview,null);
        //1.初始化下拉刷新listview
        refreshListView = (PullToRefreshListView) View.inflate(getActivity(), R.layout.ptr_listview, null);
        //2.设置刷新模式，默认是Mode.Pull_FROM_START
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);//上拉和下拉都有
        //3.设置刷新监听器
        refreshListView.setOnRefreshListener((PullToRefreshBase.OnRefreshListener<ListView>) this);

        //4.获取其中包裹的listview，
        listView = refreshListView.getRefreshableView();

        //去掉listview默认的状态选择器
        listView.setSelector(android.R.color.transparent);
        //去掉listview的默认的分割线
        listView.setDivider(null);

        //给listview设置adapter
        homeAdapter = new HomeAdapter(list);
        listView.setAdapter(homeAdapter);

        return refreshListView;
    }

    @Override
    protected Object getData() {
        //如果是下拉刷新则清空集合数据
        if (refreshListView.getCurrentMode() == PullToRefreshBase.Mode.PULL_FROM_START)
            list.clear();

        final Home home = DataLoader.getInstance().loadBeanData(Url.lastNews, Home.class);
        if (home != null) {
            Util.runOnUIThread(new Runnable() {
                @Override
                public void run() {
                    //将列表数据放入list中
                    list.addAll(home.getStories());
                    //更新adapter
                    homeAdapter.notifyDataSetChanged();
                    //完成刷新状态
                    refreshListView.onRefreshComplete();
                }
            });
        }
        return home;
    }

    @Override
    public void onRefresh(PullToRefreshBase refreshView) {
//        onLoad();
        loadPage.loadData();
    }
}
