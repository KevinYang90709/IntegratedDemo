package com.kevinyang.integrateddemo.bean;

import android.os.Bundle;

/**
 * Created by Administrator on 2017/2/25.
 */

public class TabInfo {

    public Class  clz;
    public String title;
    public Bundle args;

    public TabInfo(Class clz, String title, Bundle args) {
        this.clz = clz;
        this.title = title;
        this.args = args;
    }
}
