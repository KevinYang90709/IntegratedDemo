package com.kevinyang.integrateddemo.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kevinyang.integrateddemo.R;
import com.kevinyang.integrateddemo.base.BaseActivity;
import com.kevinyang.integrateddemo.ui.fragment.TestFrament;

import java.util.ArrayList;

import butterknife.BindView;

public class BottomGroupAvticity extends BaseActivity {

    @BindView(R.id.frameLayout)
    FrameLayout mFrameLayout;
    @BindView(R.id.content_rb_home)
    RadioButton mContentRbHome;
    @BindView(R.id.content_rb_tweet)
    RadioButton mContentRbTweet;
    @BindView(R.id.content_rb_quickoption)
    RadioButton mContentRbQuickoption;
    @BindView(R.id.content_rb_explore)
    RadioButton mContentRbExplore;
    @BindView(R.id.content_rb_me)
    RadioButton mContentRbMe;
    @BindView(R.id.content_rg)
    RadioGroup mContentRg;


    private int position; //当前选中的位置
    private ArrayList<Fragment> mFragmentList;
    private Fragment mFragment;//刚显示的Fragment
    
    @Override
    public int getLayoutResId() {
        return R.layout.activity_bottom_group_avticity;
    }

    @Override
    protected void init() {
        super.init();


        mFragmentList = new ArrayList<>();

        mFragmentList.add(new TestFrament());
        mFragmentList.add(new TestFrament());
        mFragmentList.add(new TestFrament());
        mFragmentList.add(new TestFrament());

        mContentRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.content_rb_home://选中了 首页
                        position = 0;
                        break;
                    case R.id.content_rb_tweet://选中了 动弹
                        position = 1;
                        break;
                    case R.id.content_rb_explore://选中了 发现
                        position = 2;
                        break;
                    case R.id.content_rb_me://选中了 我的
                        position = 3;
                        break;
                    default:
                        position = 0;
                        break;
                }
                //根据位置得到对应的Fragment
                Fragment currentFragment = getFragment();

                replaceFragment(mFragment, currentFragment);
            }
        });
        //默认选中首页
        mContentRg.check(R.id.content_rb_home);
    }


    /**
     * @param lastFragment
     * @param currentFragment
     */
    private void replaceFragment(Fragment lastFragment, Fragment currentFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        //如果两个不相等,说明切换了Fragment
        if (lastFragment != currentFragment) {
            mFragment = currentFragment;

            //隐藏刚显示的Fragment
            if (lastFragment != null) {
                transaction.hide(lastFragment);
            }
            /**
             * 显示 或者 添加当前要显示的Fragment
             *
             * 如果当前要显示的Fragment没添加过 则 添加
             * 如果当前要显示的Fragment被添加过 则 隐藏
             */
            if (!currentFragment.isAdded()) {
                if (currentFragment != null) {
                    transaction.add(R.id.frameLayout, currentFragment).commit();
                }
            } else {
                if (currentFragment != null) {
                    transaction.show(currentFragment).commit();
                }
            }
        }
    }

    /**
     * 根据返回到对应的Fragment
     *
     * @return
     */
    private Fragment getFragment() {
        return mFragmentList.get(position);
    }


}
