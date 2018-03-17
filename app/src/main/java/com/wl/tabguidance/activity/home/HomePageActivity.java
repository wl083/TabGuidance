package com.wl.tabguidance.activity.home;

import android.view.View;

import com.wl.tabguidance.R;
import com.wl.tabguidance.activity.BaseActivity;

/**
 * Created by wl
 * On 2018/3/12
 * Describe:
 */

public class HomePageActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected int setActivityLayout() {
        return R.layout.activity_homepage;
    }

    protected void initView() {
        findViewById(R.id.btn_home_page_tablayout).setOnClickListener(this);
        findViewById(R.id.btn_home_page_tabtitlestring).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_home_page_tablayout:
                startActivity(TabLayoutHomePageActivity.class);
                break;
            case R.id.btn_home_page_tabtitlestring:
                startActivity(TabLayoutHomePageActivity.class);
                break;
        }
    }
}
