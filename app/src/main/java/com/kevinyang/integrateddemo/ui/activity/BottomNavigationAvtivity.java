package com.kevinyang.integrateddemo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;

import com.kevinyang.integrateddemo.R;
import com.kevinyang.integrateddemo.base.BaseActivity;
import com.kevinyang.integrateddemo.ui.fragment.TestFrament;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/2/25.
 */

public class BottomNavigationAvtivity extends BaseActivity {
    @BindView(R.id.flContentContainer)
    FrameLayout mFlContentContainer;
    @BindView(R.id.fragmentTabHost)
    FragmentTabHost mFragmentTabHost;
    @BindView(R.id.ibQuickOption)
    ImageButton mIbQuickOption;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_button_navigation;
    }

    @Override
    protected void init() {
        super.init();

        //最基本初始化
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.flContentContainer);

        if (android.os.Build.VERSION.SDK_INT > 10) {
            // 去除分割线
            mFragmentTabHost.getTabWidget().setShowDividers(0);
        }
        
    
        /*--------------- 循环的方式创建TabSpec_数组循环---------------*/
        String[] mainTitleArr = {"一只", "两只", "", "三只", "四只"};
        int[] topResIdArr = {
                R.drawable.dog_48px,
                R.drawable.dog_48px,
                R.drawable.dog_48px,
                R.drawable.dog_48px,
                R.drawable.dog_48px};

        /*--------------- 循环的方式创建TabSpec_集合循环---------------*/
        List<BottomTabInfo> bottomTabInfos = new ArrayList<>();
        bottomTabInfos.add(new BottomTabInfo("一只", R.drawable.dog_48px, TestFrament.class));
        bottomTabInfos.add(new BottomTabInfo("两只", R.drawable.dog_48px, TestFrament.class));
        bottomTabInfos.add(new BottomTabInfo("", R.drawable.dog_48px, TestFrament.class));
        bottomTabInfos.add(new BottomTabInfo("三只", R.drawable.dog_48px, TestFrament.class));
        bottomTabInfos.add(new BottomTabInfo("四只", R.drawable.dog_48px, TestFrament.class));

        /*--------------- 循环的方式创建TabSpec_枚举循环---------------*/

        for (int i = 0; i < EBOTTOMTABINFO.values().length; i++) {
            //数组
            //            String title = mainTitleArr[i];
            //            int topResId = topResIdArr[i];
            
            //集合
            //            String title = bottomTabInfos.get(i).title;
            //            int topResId = bottomTabInfos.get(i).topResId;
            //            Class clz = bottomTabInfos.get(i).clz;
            
            //枚举
            EBOTTOMTABINFO[] values = EBOTTOMTABINFO.values();
            EBOTTOMTABINFO bottomTabinfo = values[i];
            String title = bottomTabinfo.title;
            int topResId = bottomTabinfo.topResId;
            Class clz = bottomTabinfo.clz;

            //添加tab标签
            TabHost.TabSpec tabSpec = mFragmentTabHost.newTabSpec(title);
            //创建indicatorView1
            View indicatorView = View.inflate(this, R.layout.inflate_indicatorview, null);
            TextView tabTitle = (TextView) indicatorView.findViewById(R.id.tab_title);
            tabTitle.setText(title);
            tabTitle.setCompoundDrawablesWithIntrinsicBounds(0, topResId, 0, 0);

            //设置tabSpec的样式
            tabSpec.setIndicator(indicatorView);
            Bundle args = new Bundle();
            args.putString("args", "我是参数" + i);

            mFragmentTabHost.addTab(tabSpec, clz, args);
            //隐藏中间的IndicatorView
            if (i == 2) {
                indicatorView.setVisibility(View.INVISIBLE);
            }
        }
    }

    @OnClick(R.id.ibQuickOption)
    public void onClick() {

    }

    class BottomTabInfo {
        public String title;
        public int    topResId;
        public Class  clz;

        public BottomTabInfo(String title, int topResId, Class clz) {
            this.title = title;
            this.topResId = topResId;
            this.clz = clz;
        }
    }

    public enum EBOTTOMTABINFO {
        NEW("一只", R.drawable.dog_48px, TestFrament.class),
        TWEET("两只", R.drawable.dog_48px, TestFrament.class),
        QUICKOPTION("", R.drawable.dog_48px, TestFrament.class),
        EXPLORE("三只", R.drawable.dog_48px, TestFrament.class),
        ME("四只", R.drawable.dog_48px, TestFrament.class);

        public String title;
        public int    topResId;
        public Class  clz;

        EBOTTOMTABINFO(String title, int topResId, Class clz) {
            this.title = title;
            this.topResId = topResId;
            this.clz = clz;
        }
    }

    
}
