package com.wl.tabguidance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wl.tabguidance.R;
import com.wl.tabguidance.fragments.Fragment_Two;
import com.wl.tabguidance.fragments.Fragment_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wl on 2016/10/2.
 * TabLayout 是 Android Support Design库，使用时需要在在build.gradle中加入compile 'com.android.support:design:22.2.0'
 *使用 app:tabIndicatorColor="#f00" 设置tab标签的下划线的颜色
 */
public class ActivityTwo extends AppCompatActivity{

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private String[] titles;
    private List<Fragment> fragments = new ArrayList<>();
    private String TAG = "wl";

    private MyAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        getSupportActionBar().hide();

        initView();
        initData();
        inidAdapter();

//        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void inidAdapter() {
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initData() {
        titles = getResources().getStringArray(R.array.string_tab_title);
        Log.i(TAG, "title length is: " + titles.length);

        for (int i = 0; i < titles.length; i++) {
            fragments.add(Fragment_Two.getInstance(i));
//            mTabLayout.addTab(mTabLayout.newTab().setText(titles[i]));

        }
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tablayout_two);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_two);

    }


    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size() == 0 ? 0 : fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];

        }
    }


}
