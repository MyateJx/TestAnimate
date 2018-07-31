package com.myatejx.animatetest.child_trans;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.animatetest.R;
import com.myatejx.animatetest.databinding.ActivityChildTransBinding;
import com.myatejx.animatetest.databinding.AdapterChildTransBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * @author xmj
 * @date 2018/7/31
 */
public class TestChildLoadActivity extends AppCompatActivity {

    private ActivityChildTransBinding mBinding;
    private BaseBindingAdapter<String, AdapterChildTransBinding> mAdapter;
    private List<String> mStrings = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_child_trans);
        mBinding.setClickProxy(new ClickProxy());
        mAdapter = new BaseBindingAdapter<String, AdapterChildTransBinding>(getApplicationContext()) {
            @Override
            protected int getLayoutResId(int viewType) {
                return R.layout.adapter_child_trans;
            }

            @Override
            protected void onBindItem(AdapterChildTransBinding binding, String item, int position) {

            }
        };
        mBinding.rv.setAdapter(mAdapter);
        for (int i = 0; i < 20; i++) {
            mStrings.add("0");
        }
        mAdapter.setList(mStrings);
        mAdapter.notifyDataSetChanged();
    }

    public class ClickProxy {
        public void reload() {
            //TODO 没效果？
            mAdapter.setList(mStrings);
            mAdapter.notifyDataSetChanged();
        }
    }
}
