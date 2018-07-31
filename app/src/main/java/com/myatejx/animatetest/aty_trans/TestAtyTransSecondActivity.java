package com.myatejx.animatetest.aty_trans;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.animatetest.R;

/**
 * @author xmj
 * @date 2018/7/31
 */
public class TestAtyTransSecondActivity extends AppCompatActivity {

    private int animEnter;
    private int animLeave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animEnter = getIntent().getIntExtra("animEnter", R.anim.anim_left_to_right_in);
        animLeave = getIntent().getIntExtra("animLeave", R.anim.anim_right_to_left_out);
        setContentView(R.layout.activity_aty_trans_second);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(animEnter, animLeave);
    }
}
