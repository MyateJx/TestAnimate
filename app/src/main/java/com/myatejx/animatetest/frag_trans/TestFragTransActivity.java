package com.myatejx.animatetest.frag_trans;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.animatetest.R;
import com.myatejx.animatetest.databinding.ActivityFragTransBinding;

/**
 * @author xmj
 * @date 2018/7/31
 */
public class TestFragTransActivity extends AppCompatActivity {

    private ActivityFragTransBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_frag_trans);
        mBinding.setClickProxy(new ClickProxy());

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(R.id.frag_container, TestTransOneFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public class ClickProxy {

    }
}
