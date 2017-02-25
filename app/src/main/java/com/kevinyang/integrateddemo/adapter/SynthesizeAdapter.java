package com.kevinyang.integrateddemo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kevinyang.integrateddemo.R;
import com.kevinyang.integrateddemo.bean.SynthesizeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */
public class SynthesizeAdapter extends BaseQuickAdapter<SynthesizeBean,BaseViewHolder>{
    
    public SynthesizeAdapter(int layoutResId, List<SynthesizeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SynthesizeBean item) {
        helper.setText(R.id.title,item.title);
        helper.setText(R.id.des,item.des);
        helper.setImageResource(R.id.icon,item.icon);
    }
}
