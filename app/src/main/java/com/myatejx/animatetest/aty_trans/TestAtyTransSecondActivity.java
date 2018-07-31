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

    public static final String ANIM_ENTER_WHEN_BACK = "animEnterWhenBack";
    public static final String ANIM_EXIT_WHEN_BACK = "animExitWhenBack";

    private int animEnterWhenBack;
    private int animExitWhenBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animEnterWhenBack = getIntent().getIntExtra(ANIM_ENTER_WHEN_BACK, R.anim.anim_keep_on);
        animExitWhenBack = getIntent().getIntExtra(ANIM_EXIT_WHEN_BACK, R.anim.anim_keep_on);
        setContentView(R.layout.activity_aty_trans_second);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(animEnterWhenBack, animExitWhenBack);
    }
}
