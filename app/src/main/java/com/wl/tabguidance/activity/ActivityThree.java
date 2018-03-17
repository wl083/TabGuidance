package com.wl.tabguidance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wl.tabguidance.R;
import com.wl.tabguidance.fragments.Fragment_Three;
import com.wl.tabguidance.fragments.Fragment_Two;

 import java.util.ArrayList;
 import java.util.List;

 /**
 * Created by wl on 2016/10/2.
 * **给RadioButton添加中状态选择
  *
 */
public class ActivityThree extends AppCompatActivity{

    private ViewPager mViewPager;
    private FrameLayout mFrameLayout;
    private RadioGroup mRadioGroup;
    private RadioButton rbOne,rbTwo;
    private List<Fragment> fragments = new ArrayList<>();

    private String TAG = "wl";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        initView();
        inidFragments();
        //* 默认显示第一个fragment
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout_three,fragments.get(0)).commit();

//        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//                 RadioButton rbCheck = (RadioButton) radioGroup.findViewById(i);
//                int num = Integer.parseInt(rbCheck.getTag().toString());
//                Log.i(TAG, "tag is: " + num);
//                manager.beginTransaction().replace(R.id.framelayout_three,fragments.get(num)).commit();
//            }
//        });
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkRadioButton = (RadioButton) group.findViewById(checkedId);
                int position = Integer.parseInt(checkRadioButton.getTag().toString());
                Fragment currentFragment = fragments.get(position);

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                if (!currentFragment.isAdded()){
                    transaction.add(R.id.framelayout_three,currentFragment);
                }

                for (Fragment fragment : fragments){
                    if (fragment == currentFragment){
                        transaction.show(fragment);
                    }else if (!fragment.isHidden()){
                        transaction.hide(fragment);
                    }
                }

                transaction.commit();
            }
        });
    }

    private void inidFragments() {
        fragments.add(Fragment_Three.getInstance("第一页"));
        fragments.add(Fragment_Three.getInstance("第二个页面"));
//        Fragment_Three fragment1 = Fragment_Three.getInstance("第一页");
//        Fragment_Three fragment2 = Fragment_Three.getInstance("第二页");
//        fragments.add(fragment1);
//        fragments.add(fragment2);
    }


    private void initView() {
        mFrameLayout = (FrameLayout) findViewById(R.id.framelayout_three);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_three);
    }

}
