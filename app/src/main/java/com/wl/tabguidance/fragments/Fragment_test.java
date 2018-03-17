package com.wl.tabguidance.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wl on 2016/10/4.
 */
public class Fragment_test extends Fragment{

    private int msg;
    private static String TAG = "wl";
    public static Fragment_test getInstance(int sendMsg){
        Fragment_test fragment = new Fragment_test();

        Bundle bundle = new Bundle();
        bundle.putInt("msg",sendMsg);
        fragment.setArguments(bundle);
        Log.i(TAG, "set bundle is: " + sendMsg);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        msg = getArguments().getInt("msg");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView tv = new TextView(getContext());
        //* 测试时出错，错误类型为：
        tv.setText(msg+"");
        tv.setGravity(Gravity.CENTER);

        return tv;

    }
}
