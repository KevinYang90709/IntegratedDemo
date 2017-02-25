package com.kevinyang.integrateddemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * ClassName:BaseFragment
 * Author   :伍碧林
 * Email    :wubilin@itcast.cn
 * Date     :2017/2/25 10:06
 * Description:
 */
public abstract class BaseFragment extends Fragment {

    protected String mArgs;
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //接收参数
        Bundle arguments = getArguments();
        if (arguments != null) {
            mArgs = (String) arguments.get("args");
        }
        //放置一个上下文
        mContext = getActivity();

        init();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //完成butterKnife的绑定操作
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initListener();
    }

    /**
     * 完成初始化,比如接收参数
     * 在BaseFramgent里面不知道init方法的具体实现,交给子类
     * 该方法选择性实现
     */
    public void init() {

    }

    /**
     * 决定Fragment里面展示的视图是什么
     * 在BaseFramgent里面不知道initView方法的具体实现,交给子类
     * 该方法必须实现
     *
     * @return
     */
    public abstract View initView();

    /**
     * 初始化数据
     * 在BaseFramgent里面不知道initData方法的具体实现,交给子类
     * 该方法选择性实现
     */
    public void initData() {

    }

    /**
     * 初始化监听器
     * 在BaseFramgent里面不知道initListener方法的具体实现,交给子类
     * 该方法选择性实现
     */
    public void initListener() {

    }
}
