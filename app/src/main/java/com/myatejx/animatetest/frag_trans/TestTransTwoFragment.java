package com.myatejx.animatetest.frag_trans;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myatejx.animatetest.R;
import com.myatejx.animatetest.databinding.FragmentTransTwoBinding;

/**
 * @author xmj
 * @date 2018/7/31
 */
public class TestTransTwoFragment extends Fragment {

    private FragmentTransTwoBinding mBinding;

    public static TestTransTwoFragment newInstance() {
        TestTransTwoFragment fragment = new TestTransTwoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trans_two, container, false);
        mBinding = FragmentTransTwoBinding.bind(view);
        return view;
    }


}
