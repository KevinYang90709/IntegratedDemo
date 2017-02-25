package com.kevinyang.integrateddemo.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kevinyang.integrateddemo.bean.TabInfo;

import java.util.List;

/*
    PagerAdapter-->view
    FramgentPagerAdapter-->Fragment-->会缓存Framgent
    FragmentStatePagerAdapter-->Fragment-->会缓存FragmentState
 */
public class MyTabPagerAdapter extends FragmentPagerAdapter {

    List<TabInfo> mTabInfos;
    Context mContext;

    public MyTabPagerAdapter(FragmentManager fm, List<TabInfo> smartTabInfos, Context context) {
        super(fm);
        mTabInfos = smartTabInfos;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        TabInfo smartTabInfo = mTabInfos.get(position);
        Class clz = smartTabInfo.clz;
        Bundle args = smartTabInfo.args;
        
        Fragment fragment = Fragment.instantiate(mContext, clz.getName(), args);

        return fragment;
    }

    @Override
    public int getCount() {
        if (mTabInfos != null) {
            return mTabInfos.size();
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        TabInfo smartTabInfo = mTabInfos.get(position);
        return smartTabInfo.title;
    }
}