package com.example.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.example.myapp.R;
import com.example.myapp.adapter.MyPagerAdapter;
import com.example.myapp.entity.TabEntity;
import com.example.myapp.fragment.HomeFragment;
import com.example.myapp.fragment.MyFragment;
import com.example.myapp.fragment.NewsFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    // 定义标签标题数组
    private String[] mTitles = {"首页", "资讯", "我的"};
    // 未选中状态下的图标资源ID数组
    private int[] mIconUnselectIds = {
            R.mipmap.home_unselect, R.mipmap.collect_unselect,
            R.mipmap.my_unselect};
    // 选中状态下的图标资源ID数组
    private int[] mIconSelectIds = {
            R.mipmap.home_selected, R.mipmap.collect_selected,
            R.mipmap.my_selected};
    // 存储Fragment实例的列表
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    // 存储自定义Tab实体的列表
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ViewPager viewPager; // 视图翻页器
    private CommonTabLayout commonTabLayout; // 底部导航标签布局

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // 设置布局文件

        initView(); // 初始化视图组件
        initData(); // 初始化数据
    }

    /**
     * 初始化视图组件
     */
    private void initView() {
        // 查找并初始化ViewPager和CommonTabLayout
        viewPager = findViewById(R.id.viewpager);
        commonTabLayout = findViewById(R.id.commonTabLayout);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        // 添加Fragment到列表中
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(NewsFragment.newInstance());
        mFragments.add(MyFragment.newInstance());

        // 创建TabEntity对象并添加到mTabEntities列表中
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        // 设置Tab数据
        commonTabLayout.setTabData(mTabEntities);

        // 设置Tab选择监听器
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                // 当某个Tab被选中时，切换ViewPager页面
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
                // 当某个Tab被重新点击时（已选中的状态下），可以在这里处理事件
            }
        });

        // 设置ViewPager预加载页面数量，避免频繁销毁重建Fragment
        viewPager.setOffscreenPageLimit(mFragments.size());

        // 设置ViewPager页面改变监听器
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 页面滚动时调用
            }

            @Override
            public void onPageSelected(int position) {
                // 页面被选中时调用，更新底部标签选中状态
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // 页面滚动状态改变时调用
            }
        });

        // 使用 getSupportFragmentManager() 初始化适配器，并设置给ViewPager
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));
    }
}