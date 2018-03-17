package com.wl.tabguidance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wl.tabguidance.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wl on 2016/10/2.
 *  ViewPager and title
 */
public class ActivityOne extends AppCompatActivity{

    private ViewPager mViewPager;
    private List<View> views = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_one);
        getSupportActionBar().hide();

        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {

        mViewPager.setAdapter(new MyAdapterOne());
    }

    private void initData() {
        // *
        TextView textView = new TextView(this);
        textView.setText("文本信息");
        textView.setGravity(Gravity.CENTER);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);

        views.add(textView);
        views.add(imageView);
    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.viewpager_one);
//        mViewPager.setAdapter(new MyAdapterOne());
    }

    /**
     * * 创建 adapter
     * 复写instantiateItem和destroyItem方法
     */
    class MyAdapterOne extends PagerAdapter{

        String[] titles = new String[]{"文本","图片"};
        @Override
        public int getCount() {
            return views.size() == 0 ? 0 : views.size();
        }

        /**
         * 系统调用并判断返回的view和object对象是否相等
         * @param view
         * @param object
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * *return the view of current position
         * @param container     把当前显示的数据源添加到此container中
         * @param position      ViewPager's current page
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        /**
         * * viewpager 滚出某一页时，销毁对应position处的页面
         * @param container
         * @param position
         * @param object
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            /**
             * *注释掉此方法的 super.destroyItem(container, position, object); 否则会出错
             * java.lang.UnsupportedOperationException: Required method destroyItem was not overridden
             */
//            super.destroyItem(container, position, object);
            container.removeView(views.get(position));
        }

        /**
         * * 返回当前页的Tab提示信息
         * @param position
         * @return
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
