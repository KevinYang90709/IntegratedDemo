package com.kevinyang.integrateddemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kevinyang.integrateddemo.R;
import com.kevinyang.integrateddemo.adapter.MyTabPagerAdapter;
import com.kevinyang.integrateddemo.bean.TabInfo;
import com.kevinyang.integrateddemo.ui.fragment.SynthesizeFrament;
import com.kevinyang.integrateddemo.ui.fragment.TestFrament;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initActionBar();

        //设置Adapter
        if (mViewpager != null) {
            setupViewPager(mViewpager);
        }

        //tablayout滚动模式,要标签数量够多,不然标签会靠左显示
        //mTabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        
        mNavView.setNavigationItemSelectedListener(this);
    }


    private void setupViewPager(ViewPager viewPager) {
        //创建Fragment的集合,和tatlyout的title的名称集合
        List<TabInfo> tabInfos = new ArrayList<>();

        //Bundle bundle = new Bundle();
        //bundle.putString("args","哈哈");
        tabInfos.add(new TabInfo(SynthesizeFrament.class,"组合控件",null));
        tabInfos.add(new TabInfo(TestFrament.class,"标签一",null));
        tabInfos.add(new TabInfo(TestFrament.class,"标签一",null));
        tabInfos.add(new TabInfo(TestFrament.class,"标签一",null));

        
        
        MyTabPagerAdapter adapter = new MyTabPagerAdapter(getSupportFragmentManager(), tabInfos, this);
        viewPager.setAdapter(adapter);
        //设置tablayout的viewpager
        mTabs.setupWithViewPager(mViewpager);
    }

    

    private void initActionBar() {
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
