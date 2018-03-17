package com.wl.tabguidance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.wl.tabguidance.R;
import com.wl.tabguidance.TabEntity;
import com.wl.tabguidance.fragments.Fragment_Two;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lei on 2016/11/7 0007.
 *
 */

public class ActivitySeven extends AppCompatActivity {

    private CommonTabLayout tabLayout;
    private FrameLayout frameLayout;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] mTitles = {"首页", "消息", "联系人", "更多"};



    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);


        for (int i = 0; i < mTitles.length; i++) {
//            mTabEntities.add(new TabEntity(mTitles[i],mIconSelectIds[i],mIconUnselectIds[i]));
            fragments.add(Fragment_Two.getInstance(i));
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }




        tabLayout = (CommonTabLayout) findViewById(R.id.tab_activity_seven);
        frameLayout = (FrameLayout) findViewById(R.id.container_seven);
        tabLayout.setTabData(mTabEntities);

        //* 设置title
        tabLayout.setTabData(mTabEntities,this,R.id.container_seven,fragments);


        tabLayout.showMsg(1,10);

    }



}
