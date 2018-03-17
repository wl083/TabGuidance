package com.wl.tabguidance.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wl on 2016/10/2.
 */
public class Fragment_Three extends Fragment{

    private static Fragment_Three fragment;
    String msg;

    public static Fragment_Three getInstance(String str){
        //* 如果复用此fragment，则不能进行下面判断
//        if (fragment == null)
        fragment = new Fragment_Three();
        Bundle bundle = new Bundle();
        bundle.putString("msg",str);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        msg = getArguments().getString("msg");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(msg);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setWidth(200);
        textView.setHeight(200);
        return textView;
    }
}
