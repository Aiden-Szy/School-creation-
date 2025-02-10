package com.example.myapp.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.example.myapp.R;
import com.example.myapp.adapter.HomeAdapter;
import com.example.myapp.api.Api;
import com.example.myapp.api.ApiConfig;
import com.example.myapp.api.TtitCallback;
import com.example.myapp.entity.CategoryEntity;
import com.example.myapp.entity.VideoCategoryResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * HomeFragment 是应用主页的主要片段，用于展示视频分类和相关的内容。
 */
public class HomeFragment extends com.example.myapp.fragment.BaseFragment {
    // 存储所有子片段的列表
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    // 标签标题数组
    private String[] mTitles;
    // ViewPager 实例，用于页面滑动切换
    private ViewPager viewPager;
    // SlidingTabLayout 实例，用于顶部标签导航
    private SlidingTabLayout slidingTabLayout;

    /**
     * 默认构造函数
     */
    public HomeFragment() {
    }

    /**
     * 创建新的 HomeFragment 实例的方法
     *
     * @return 新的 HomeFragment 实例
     */
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    /**
     * 初始化布局资源ID
     *
     * @return 布局资源ID
     */
    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    /**
     * 初始化视图组件
     */
    @Override
    protected void initView() {
        viewPager = mRootView.findViewById(R.id.fixedViewPager);
        slidingTabLayout = mRootView.findViewById(R.id.slidingTabLayout);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        getVideoCategoryList();
    }

    /**
     * 获取视频分类列表，并根据返回的数据初始化视图
     */
    private void getVideoCategoryList() {
        HashMap<String, Object> params = new HashMap<>();
        Api.config(ApiConfig.VIDEO_CATEGORY_LIST, params).getRequest(getActivity(), new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 使用 Gson 解析服务器返回的 JSON 数据
                        VideoCategoryResponse response = new Gson().fromJson(res, VideoCategoryResponse.class);
                        if (response != null && response.getCode() == 0) {
                            List<CategoryEntity> list = response.getPage().getList();
                            if (list != null && list.size() > 0) {
                                // 初始化标题数组
                                mTitles = new String[list.size()];
                                for (int i = 0; i < list.size(); i++) {
                                    mTitles[i] = list.get(i).getCategoryName();
                                    // 添加对应的视频片段
                                    mFragments.add(VideoFragment.newInstance(list.get(i).getCategoryId()));
                                }
                                // 设置 ViewPager 的缓存页面数量
                                viewPager.setOffscreenPageLimit(mFragments.size());
                                // 设置适配器
                                viewPager.setAdapter(new HomeAdapter(getFragmentManager(), mTitles, mFragments));
                                // 将 SlidingTabLayout 和 ViewPager 关联起来
                                slidingTabLayout.setViewPager(viewPager);
                            }
                        }
                    }
                });
            }

            @Override
            public void onFailure(Exception e) {
                // 请求失败时处理
            }
        });
    }
}