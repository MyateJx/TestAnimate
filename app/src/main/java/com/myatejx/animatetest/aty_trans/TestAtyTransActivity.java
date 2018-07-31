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

    public void toSecondActivity(int animEnter, int animLeave) {
        Intent intent = new Intent(TestAtyTransActivity.this, TestAtyTransSecondActivity.class);
        intent.putExtra("animEnter", animEnter);
        intent.putExtra("animLeave", animLeave);
        startActivity(new Intent(TestAtyTransActivity.this, TestAtyTransSecondActivity.class));
        overridePendingTransition(animEnter, animLeave);
    }

    public class ClickProxy {
        //从左往右进入
        public void leftToRightIn() {
            toSecondActivity(R.anim.anim_left_to_right_in, R.anim.anim_right_to_left_out);
        }

        //从下往上进入
        public void bottomToTopIn() {
            toSecondActivity(R.anim.anim_right_to_left_out, R.anim.anim_left_to_right_in);
        }

        //从右往左进入
        public void rightToLeftIn() {
            toSecondActivity(R.anim.anim_right_to_left_out, R.anim.anim_left_to_right_in);
        }

        //从上往下进入
        public void topToBottomIn() {
            toSecondActivity(R.anim.anim_right_to_left_out, R.anim.anim_left_to_right_in);
        }

        //渐变进入
        public void alphaIn() {
            toSecondActivity(R.anim.anim_right_to_left_out, R.anim.anim_left_to_right_in);
        }

        //伸缩进入
        public void scaleIn() {
            toSecondActivity(R.anim.anim_right_to_left_out, R.anim.anim_left_to_right_in);
        }

        //旋转进入
        public void rotateIn() {
            toSecondActivity(R.anim.anim_right_to_left_out, R.anim.anim_left_to_right_in);
        }

        //组合效果进入
        public void setIn() {
            toSecondActivity(R.anim.anim_right_to_left_out, R.anim.anim_left_to_right_in);
        }
    }
}
