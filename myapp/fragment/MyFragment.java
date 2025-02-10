package com.example.myapp.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.myapp.R;
import com.example.myapp.activity.LoginActivity;
import com.example.myapp.activity.MyCollectActivity;

import butterknife.BindView;
import butterknife.OnClick;
import skin.support.SkinCompatManager;


public class MyFragment extends com.example.myapp.fragment.BaseFragment {

    @BindView(R.id.img_header)
    ImageView imgHeader;
    private ImageView img_header;
    private ImageView img_collect;
    private RelativeLayout rl_collect;
    private ImageView img_skin;
    private RelativeLayout rl_skin;
    private ImageView img_logout;
    private RelativeLayout rl_logout;

    public MyFragment() {
    }

    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    protected int initLayout(){
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {

        img_header = findViewById(R.id.img_header);
        img_collect = findViewById(R.id.img_collect);
        rl_collect = findViewById(R.id.rl_collect);
        img_skin = findViewById(R.id.img_skin);
        rl_skin = findViewById(R.id.rl_skin);
        img_logout = findViewById(R.id.img_logout);
        rl_logout = findViewById(R.id.rl_logout);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.img_header, R.id.rl_collect, R.id.rl_skin, R.id.rl_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_header:

                break;
            case R.id.rl_collect:
                navigateTo(MyCollectActivity.class);
                break;
            case R.id.rl_skin:
                String skin = findByKey("skin");
                if (skin.equals("night")) {
                    // 恢复应用默认皮肤
                    SkinCompatManager.getInstance().restoreDefaultTheme();
                    insertVal("skin", "default");
                } else {
                    SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
                    insertVal("skin", "night");
                }
                break;
            case R.id.rl_logout:
                removeByKey("token");
                navigateToWithFlag(LoginActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                break;
        }
    }
}