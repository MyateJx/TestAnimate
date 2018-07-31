package com.myatejx.animatetest.aty_trans;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.animatetest.R;
import com.myatejx.animatetest.databinding.ActivityAtyTransBinding;

/**
 * @author xmj
 * @date 2018/7/31
 */
public class TestAtyTransActivity extends AppCompatActivity {

    private ActivityAtyTransBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_aty_trans);
        mBinding.setClickProxy(new ClickProxy());
    }

    public void toSecondActivity(int animEnter, int animLeave, int animEnterWhenBack, int animExitWhenBack) {
        Intent intent = new Intent(TestAtyTransActivity.this, TestAtyTransSecondActivity.class);
        intent.putExtra(TestAtyTransSecondActivity.ANIM_ENTER_WHEN_BACK, animEnterWhenBack);
        intent.putExtra(TestAtyTransSecondActivity.ANIM_EXIT_WHEN_BACK, animExitWhenBack);
        startActivity(intent);
        overridePendingTransition(animEnter, animLeave);
    }

    public class ClickProxy {

        //从右往左进入
        public void rightToLeftIn() {
            toSecondActivity(R.anim.anim_right_to_left, R.anim.anim_keep_on,
                    R.anim.anim_keep_on, R.anim.anim_left_to_right);
        }

        //从下往上进入
        public void bottomToTopIn() {
            toSecondActivity(R.anim.anim_bottom_to_top, R.anim.anim_keep_on,
                    R.anim.anim_keep_on, R.anim.anim_top_to_bottom);
        }

        //渐变进入
        public void alphaIn() {
            toSecondActivity(R.anim.anim_fade_in, R.anim.anim_keep_on,
                    //TODO 退出时似乎无效
                    R.anim.anim_keep_on, R.anim.anim_fade_out);
        }

        //从左往右进入
        public void leftToRightIn() {
            toSecondActivity(R.anim.anim_left_to_right, R.anim.anim_keep_on,
                    R.anim.anim_keep_on, R.anim.anim_right_to_left);
        }

        //从上往下进入
        public void topToBottomIn() {
            toSecondActivity(R.anim.anim_top_to_bottom, R.anim.anim_keep_on,
                    R.anim.anim_keep_on, R.anim.anim_bottom_to_top);
        }

        //伸缩进入
        public void scaleIn() {
//            toSecondFragment(R.anim.anim_left_to_right_exit, R.anim.anim_left_to_right_enter);
        }

        //旋转进入
        public void rotateIn() {
            //TODO 旋转进入
            toSecondActivity(R.anim.anim_span_from_right, R.anim.anim_keep_on,
                    R.anim.anim_keep_on, R.anim.anim_span_back_to_right);
        }

        //组合效果进入
        public void setIn() {
//            toSecondFragment(R.anim.anim_left_to_right_exit, R.anim.anim_left_to_right_enter);
        }
    }
}
