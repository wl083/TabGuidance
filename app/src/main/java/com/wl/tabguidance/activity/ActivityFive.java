package com.wl.tabguidance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.wl.tabguidance.R;
import com.wl.tabguidance.fragments.Fragment_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wl on 2016/10/4.
 * * 使用TabLayout需要添加依赖包：compile 'com.android.support:design:24.0.0'
 */
public class ActivityFive extends AppCompatActivity{

    private TabLayout mTablayout;
    private ViewPager mPager;
    private String[] titles;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        mTablayout = (TabLayout) findViewById(R.id.tablayout_five);
        mPager = (ViewPager) findViewById(R.id.viewpager_five);

        initData();

        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTablayout.setupWithViewPager(mPager);
    }

    private void initData() {
        titles = getResources().getStringArray(R.array.string_tab_title);
        for (int i = 0; i < titles.length; i++) {
            fragments.add(Fragment_test.getInstance(i));
        }
    }


    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
