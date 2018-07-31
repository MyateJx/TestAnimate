package com.myatejx.animatetest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.animatetest.aty_trans.TestAtyTransActivity;
import com.myatejx.animatetest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setClickProxy(new ClickProxy());
    }

    public class ClickProxy {

        //补间动画
        public void toTween() {
            startActivity(new Intent(MainActivity.this, TestTweenActivity.class));
        }

        //逐帧动画
        public void toFrame() {
            startActivity(new Intent(MainActivity.this, TestFrameActivity.class));
        }

        //属性动画
        public void toProperty() {
            startActivity(new Intent(MainActivity.this, TestPropertyActivity.class));
        }

        //acitivity转场动画
        public void toActivity() {
            startActivity(new Intent(MainActivity.this, TestAtyTransActivity.class));
        }

        //fragment转场动画
        public void toFragment() {
            startActivity(new Intent(MainActivity.this, TestFragTransActivity.class));
        }

        //view出场动画
        public void toView() {
            startActivity(new Intent(MainActivity.this, TestViewShowActivity.class));
        }

        //子view加载动画
        public void toChildView() {
            startActivity(new Intent(MainActivity.this, TestChildLoadActivity.class));
        }

        //viewGroup容纳变化动画
        public void toViewGroupChange() {
            startActivity(new Intent(MainActivity.this, TestLayoutChangeActivity.class));
        }
    }

}
