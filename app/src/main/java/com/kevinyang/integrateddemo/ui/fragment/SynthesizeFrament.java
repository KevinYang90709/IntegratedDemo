package com.kevinyang.integrateddemo.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.kevinyang.integrateddemo.R;
import com.kevinyang.integrateddemo.adapter.SynthesizeAdapter;
import com.kevinyang.integrateddemo.base.BaseFragment;
import com.kevinyang.integrateddemo.bean.SynthesizeBean;
import com.kevinyang.integrateddemo.ui.activity.BottomGroupAvticity;
import com.kevinyang.integrateddemo.ui.activity.BottomNavigationAvtivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/25.
 */
public class SynthesizeFrament extends BaseFragment  {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private List<SynthesizeBean> mDataList;
    private SynthesizeAdapter mAdapter;

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_synthesize, null);
        return view;
    }

   

    @Override
    public void initListener() {
        super.initListener();
        
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SynthesizeAdapter(R.layout.synthelist_item_view, mDataList);
        
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                
                Intent intent = new Intent(getContext(),mDataList.get(position).clz);
                startActivity(intent);    
            }
        });
    }


    @Override
    public void initData() {
        super.initData();
        mDataList = new ArrayList<>();
        mDataList.add(new SynthesizeBean(R.drawable.dog,"FragmentTabHost+Viewpager","实现底部导航栏", BottomNavigationAvtivity.class));
        mDataList.add(new SynthesizeBean(R.drawable.cat_lovely,"RadioGroup+FrameLayout","实现底部导航栏", BottomGroupAvticity.class));
    }

    
}
