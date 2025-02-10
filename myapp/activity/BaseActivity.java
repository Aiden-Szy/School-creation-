package com.example.myapp.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import xyz.doikki.videoplayer.player.VideoViewManager;

/**
 * BaseActivity 是所有活动的基类，提供了通用的方法和属性。
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 上下文对象，用于在活动中访问应用程序环境。
     */
    public Context mContext;

    /**
     * 当活动被创建时调用。
     * 初始化布局、视图和数据。
     *
     * @param savedInstanceState 如果该活动正在重新初始化，则可能包含之前保存的状态信息。
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 将当前上下文赋值给 mContext 变量
        mContext = this;
        // 设置布局文件
        setContentView(initLayout());
        // 初始化视图组件
        initView();
        // 初始化数据
        initData();
    }

    /**
     * 子类必须实现此方法来返回布局资源 ID。
     *
     * @return 布局资源 ID
     */
    protected abstract int initLayout();

    /**
     * 子类必须实现此方法来初始化视图组件。
     */
    protected abstract void initView();

    /**
     * 子类必须实现此方法来初始化数据。
     */
    protected abstract void initData();

    /**
     * 显示一个短时间的 Toast 消息。
     *
     * @param msg 要显示的消息文本
     */
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 在非主线程中显示一个短时间的 Toast 消息。
     * 使用 Looper.prepare() 和 Looper.loop() 来确保可以在非UI线程中显示Toast。
     *
     * @param msg 要显示的消息文本
     */
    public void showToastSync(String msg) {
        Looper.prepare();
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    /**
     * 启动一个新的活动。
     *
     * @param cls 要启动的活动类
     */
    public void navigateTo(Class cls) {
        Intent in = new Intent(mContext, cls);
        startActivity(in);
    }

    /**
     * 使用指定的标志启动一个新的活动。
     *
     * @param cls   要启动的活动类
     * @param flags 启动活动时使用的标志
     */
    public void navigateToWithFlag(Class cls, int flags) {
        Intent in = new Intent(mContext, cls);
        in.setFlags(flags);
        startActivity(in);
    }

    /**
     * 插入或更新SharedPreferences中的键值对。
     *
     * @param key 键名
     * @param val 键对应的值
     */
    protected void insertVal(String key, String val) {
        SharedPreferences sp = getSharedPreferences("sp_ttit", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, val);
        editor.commit();  // 提交更改
    }

    /**
     * 根据键名从SharedPreferences中获取对应的值。
     *
     * @param key 键名
     * @return 键对应的值，如果不存在则返回空字符串
     */
    protected String findByKey(String key) {
        SharedPreferences sp = getSharedPreferences("sp_ttit", MODE_PRIVATE);
        return sp.getString(key, "");
    }

    /**
     * 获取VideoViewManager实例，用于管理视频播放器。
     *
     * @return VideoViewManager 实例
     */
    protected VideoViewManager getVideoViewManager() {
        return VideoViewManager.instance();
    }

    /**
     * 返回AppCompatDelegate实例，用于支持AppCompat特性。
     *
     * @return AppCompatDelegate 实例
     */
    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        return super.getDelegate();
    }
}