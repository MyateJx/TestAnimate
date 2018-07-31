package com.myatejx.animatetest.frag_trans;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myatejx.animatetest.R;
import com.myatejx.animatetest.databinding.FragmentTransOneBinding;

/**
 * @author xmj
 * @date 2018/7/31
 */
public class TestTransOneFragment extends Fragment {

    private FragmentTransOneBinding mBinding;

    public static TestTransOneFragment newInstance() {
        TestTransOneFragment fragment = new TestTransOneFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trans_one, container, false);
        mBinding = FragmentTransOneBinding.bind(view);
        mBinding.setClickProxy(new ClickProxy());
        return view;
    }

    public void toSecondFragment(int animEnter, int animExit, int animEnterPop, int animExitPop) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(animEnter, animExit, animEnterPop, animExitPop);
        transaction.replace(R.id.frag_container, TestTransTwoFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();

        /*Intent intent = new Intent(TestAtyTransActivity.this, TestAtyTransSecondActivity.class);
        intent.putExtra(TestAtyTransSecondActivity.ANIM_ENTER_WHEN_BACK, animEnterWhenBack);
        intent.putExtra(TestAtyTransSecondActivity.ANIM_EXIT_WHEN_BACK, animExitWhenBack);
        startActivity(intent);
        overridePendingTransition(animEnter, animLeave);*/
    }

    public class ClickProxy {

        //TODO 退出有效果，但进入的时候没效果，为什么
        //从右往左进入
        public void rightToLeftIn() {
            toSecondFragment(R.anim.anim_right_to_left, R.anim.anim_keep_on,
                    R.anim.anim_keep_on, R.anim.anim_left_to_right);
        }

        //从下往上进入
        public void bottomToTopIn() {
            toSecondFragment(R.anim.anim_bottom_to_top, R.anim.anim_keep_on,
                    R.anim.anim_keep_on, R.anim.anim_top_to_bottom);
        }

        //渐变进入
        public void alphaIn() {
            toSecondFragment(R.anim.anim_fade_in, R.anim.anim_keep_on,
                    //TODO 退出时似乎无效
                    R.anim.anim_keep_on, R.anim.anim_fade_out);
        }

        //从左往右进入
        public void leftToRightIn() {
            toSecondFragment(R.anim.anim_left_to_right, R.anim.anim_keep_on,
                    R.anim.anim_keep_on, R.anim.anim_right_to_left);
        }

        //从上往下进入
        public void topToBottomIn() {
            toSecondFragment(R.anim.anim_top_to_bottom, R.anim.anim_keep_on,
                    R.anim.anim_keep_on, R.anim.anim_bottom_to_top);
        }

        //伸缩进入
        public void scaleIn() {
//            toSecondFragment(R.anim.anim_left_to_right_exit, R.anim.anim_left_to_right_enter);
        }

        //旋转进入
        public void rotateIn() {
            //TODO 旋转进入
            toSecondFragment(R.anim.anim_span_from_right, R.anim.anim_keep_on,
                    R.anim.anim_keep_on, R.anim.anim_span_back_to_right);
        }

        //组合效果进入
        public void setIn() {
//            toSecondFragment(R.anim.anim_left_to_right_exit, R.anim.anim_left_to_right_enter);
        }
    }
}
