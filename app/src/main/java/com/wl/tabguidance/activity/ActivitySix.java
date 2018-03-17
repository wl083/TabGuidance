package com.wl.tabguidance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.wl.tabguidance.R;
import com.wl.tabguidance.fragments.Fragment_Two;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lei on 2016/11/6 0006.
 * 使用封装好的tab，用以显示更好的视觉效果，如QQ中的TAB效果，需要添加 FlycoTabLayout_Lib 包
 *
 * 使用步骤：
 * 1、在layout文件中添加 com.flyco.tablayout.SegmentTabLayout 和 ViewPager 控件；
 * 2、MainActivity中：
 *  a、初始化数据，如：ViewPager、tablayout、tab的标题，egc；
 *  b、使用 SegmentTabLayout.setTabData(标题显示内容) 设置标题所要显示的内容；
 *  c、设置adapter；
 *  d、给 tablayout 和 viewpager 设置监听；
 *
 *  Note：如果要修改 Tab 的样式，可以在 layout 文件中作出相应的操作，细节参照本例中的相关设置
 */

public class ActivitySix extends AppCompatActivity {

    private ViewPager mViewPager;
    private SegmentTabLayout mTabLayout;
    private String[] mTitles = {"首页", "消息", "联系人"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_six);
        initView();
        setTabAndPager();
    }

    private void setTabAndPager() {
        mTabLayout.setTabData(mTitles);
        for (int i = 0; i < mTitles.length; i++) {
            fragments.add(Fragment_Two.getInstance(i));
        }
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
//        mViewPager.setAdapter(new MyPagerAdapter());
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
//                fragments.get(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //*设置未读消息提醒，提示类型为小红点
//        mTabLayout.showDot(1);
        /**
         * *设置未读消息提醒
         * 提示类型数字，并设置显示位置
         */
        mTabLayout.showMsg(1,2);
        mTabLayout.setMsgMargin(1,10,10);

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager_activity_six);
        mTabLayout = (SegmentTabLayout) findViewById(R.id.tab_activity_six);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
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
            return mTitles[position];
        }
    }
}
