package com.myatejx.animatetest.layout_trans;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.myatejx.animatetest.R;
import com.myatejx.animatetest.databinding.ActivityLayoutTransBinding;

/**
 * @author xmj
 * @date 2018/7/31
 */
public class TestLayoutChangeActivity extends AppCompatActivity {

    private ActivityLayoutTransBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_layout_trans);
        mBinding.setClickProxy(new ClickProxy());
    }

    public class ClickProxy {
        public void expand() {
            mBinding.calendar.setVisibility(
                    mBinding.calendar.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        }
    }
}
