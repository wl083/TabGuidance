package com.wl.tabguidance.activity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wl.tabguidance.R;
import com.wl.tabguidance.fragments.homepage.GridViewFragment;
import com.wl.tabguidance.fragments.homepage.ListViewFragment;
import com.wl.tabguidance.fragments.homepage.RecyclerViewFragment;
import com.wl.tabguidance.fragments.homepage.ScrollViewFragment;
import com.wl.tabguidance.fragments.homepage.WebViewFragment;
import com.wl.tabguidance.utils.TabLayoutTitleStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wl
 * On 2018/3/28
 * Describe:
 * Note: 使用此方式有弊端
 */

public class CustomTabHomePageActivity extends HomePageBaseActivity {

    public List<HeaderViewPagerFragment> fragments;
    private HeaderViewPager scrollableLayout;
    RelativeLayout imgHeader;
    private View titleBar_Bg;
    private TextView titleBar_title;
    private View status_bar_fix;
    private View titleBar;

//    private TabLayout mTabLayout;
    private ViewPager viewPager ;

    private TabLayoutTitleStrip tabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tab_home_page);

        initView();
    }

    protected void initView() {

//        mTabLayout = (TabLayout) findViewById(R.id.tablayout_two);
        tabs = (TabLayoutTitleStrip) findViewById(R.id.tabs);
        //内容的fragment
        fragments = new ArrayList<>();
        fragments.add(ScrollViewFragment.newInstance());
        fragments.add(ListViewFragment.newInstance());
//        fragments.add(GridViewFragment.newInstance());
//        fragments.add(RecyclerViewFragment.newInstance());
        fragments.add(WebViewFragment.newInstance());

        scrollableLayout = (HeaderViewPager) findViewById(R.id.scrollableLayout);
        titleBar = findViewById(R.id.titleBar);
        titleBar_Bg = titleBar.findViewById(R.id.bg);
        //当状态栏透明后，内容布局会上移，这里使用一个和状态栏高度相同的view来修正内容区域
        status_bar_fix = titleBar.findViewById(R.id.status_bar_fix);
        status_bar_fix.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utils.getStatusHeight(this)));
        titleBar_title = (TextView) titleBar.findViewById(R.id.title);
        titleBar_Bg.setAlpha(0);
        status_bar_fix.setAlpha(0);
        titleBar_title.setText("标题栏透明度(0%)");
        imgHeader = ((RelativeLayout) findViewById(R.id.img_header));

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomTabHomePageActivity.this,"kdklas",Toast.LENGTH_SHORT).show();
                setPager();
            }
        });

        //tab标签和内容viewpager
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                scrollableLayout.setCurrentScrollableContainer(fragments.get(position));
            }
        });
        scrollableLayout.setOnScrollListener(new HeaderViewPager.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                //让头部具有差速动画,如果不需要,可以不用设置
//                pagerHeader.setTranslationY(currentY / 2);
                imgHeader.setTranslationY(currentY / 2);
                //动态改变标题栏的透明度,注意转化为浮点型
                float alpha = 1.0f * currentY / maxY;
                titleBar_Bg.setAlpha(alpha);
                //注意头部局的颜色也需要改变
                status_bar_fix.setAlpha(alpha);
                titleBar_title.setText("标题栏透明度(" + (int) (alpha * 100) + "%)");
            }
        });
    }

    private void setPager() {

//        viewPager.setAdapter(new ContentAdapter(getSupportFragmentManager()));
//        mTabLayout.setupWithViewPager(viewPager);
//        scrollableLayout.setCurrentScrollableContainer(fragments.get(0));
//
//        viewPager.setCurrentItem(0);

        //@@@

        tabs.setTitles(titles);

        viewPager.setAdapter(new ContentAdapter(getSupportFragmentManager()));
        tabs.setViewPager(viewPager);
        scrollableLayout.setCurrentScrollableContainer(fragments.get(0));
        tabs.setTabIndex(0);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //当前窗口获取焦点时，才能正真拿到titlebar的高度，此时将需要固定的偏移量设置给scrollableLayout即可
        scrollableLayout.setTopOffset(titleBar.getHeight());
    }

//    public String[] titles = new String[]{"ScrollView", "ListView", "GridView", "RecyclerView", "WebView"};
    public String[] titles = new String[]{"ScrollView", "ListView", "WebView"};

    /**
     * 内容页的适配器
     */
    private class ContentAdapter extends FragmentPagerAdapter {

        public ContentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
