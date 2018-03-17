package com.wl.tabguidance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wl
 * On 2018/3/12
 * Describe: 基类 activity
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 设置 layout
     * @return
     */
    @LayoutRes
    protected abstract int setActivityLayout();
    protected abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setActivityLayout());
        initView();
    }

    protected void startActivity(Class<?> cls){
        startActivity(new Intent(this,cls));
    }
}
