package com.example.slkk.zhihuplus.ui.actiivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.slkk.zhihuplus.R;
import com.example.slkk.zhihuplus.adapter.MainPageAdapter;
import com.example.slkk.zhihuplus.bean.PageInfo;
import com.example.slkk.zhihuplus.ui.fragment.HomeFragent;
import com.example.slkk.zhihuplus.ui.view.PagerSlidingTab;
import com.example.slkk.zhihuplus.utils.LogUtil;
import com.example.slkk.zhihuplus.utils.Util;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private PagerSlidingTab tab;
    private ViewPager viewPager;
    private ArrayList<PageInfo> pageInfoList ;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab = (PagerSlidingTab) findViewById(R.id.pagerSlidingTab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);

        setActionBar();
        pageInfoList = paparePageData();

        viewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager(),pageInfoList));
        tab.setViewPager(viewPager);
    }

    private void setActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,0,0);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
    }

    private ArrayList<PageInfo> paparePageData() {
        ArrayList<PageInfo> infos = new ArrayList<>();
        String[] title = Util.getStringArray(R.array.tab_names);
        infos.add(new PageInfo(title[0],new HomeFragent()));
        infos.add(new PageInfo(title[1],new HomeFragent()));
        infos.add(new PageInfo(title[2],new HomeFragent()));
        infos.add(new PageInfo(title[3],new HomeFragent()));
        infos.add(new PageInfo(title[4],new HomeFragent()));
        LogUtil.d(this,infos.size()+"");


        return infos;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        toggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }
}
