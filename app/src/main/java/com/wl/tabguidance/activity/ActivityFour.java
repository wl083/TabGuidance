package com.wl.tabguidance.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wl.tabguidance.R;
import com.wl.tabguidance.fragments.Fragment_Three;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wl on 2016/10/3.
 */
public class ActivityFour extends AppCompatActivity{

    private HorizontalScrollView mScrollView;
    private ViewPager mPager;
    private LinearLayout mTabLayout;
    private String[] tabTitles;
    private TextView[] tabViews;
    private List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        initView();
        initData();

        initPager();
    }

    private void initPager() {
        mPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < tabViews.length; i++) {
                    tabViews[i].setTextColor(Color.BLACK);
                    tabViews[i].setEnabled(true);
                }
                tabViews[position].setEnabled(false);
                tabViews[position].setTextColor(Color.RED);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        //
        tabTitles = getResources().getStringArray(R.array.string_tab_title);
        tabViews = new TextView[tabTitles.length];
        for (int i = 0; i < tabTitles.length; i++) {
            TextView tab = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_items,null);
            tab.setText(tabTitles[i]);

            if (i == 0){
                tab.setTextColor(Color.RED);
                tab.setEnabled(false);
            }

            tab.setTag(i);
            tab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int) view.getTag();


                    mPager.setCurrentItem(position);
                }
            });

            tabViews[i] = tab;
            mTabLayout.addView(tab);
        }



        //************************
        initFragment();

    }

    private void initFragment() {
        for (int i = 0; i < tabTitles.length; i++) {
            Fragment_Three fragmentThree = Fragment_Three.getInstance("第-" + i + "-页");
            fragments.add(fragmentThree);
        }
    }

    private void initView() {
        mScrollView = (HorizontalScrollView) findViewById(R.id.hrscrollview);
        mTabLayout = (LinearLayout) findViewById(R.id.tab_title);
        mPager = (ViewPager) findViewById(R.id.viewpager_four);
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
    }
}
