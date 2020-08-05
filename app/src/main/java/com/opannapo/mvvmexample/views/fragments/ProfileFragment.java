package com.opannapo.mvvmexample.views.fragments;

import android.os.Bundle;
import android.view.View;

import com.opannapo.core.layer.application.presenter.view.BaseFragment;
import com.opannapo.mvvmexample.R;

/**
 * Created by napouser on 05,August,2020
 */
public class ProfileFragment extends BaseFragment {
    @Override
    protected int initLayout() {
        return R.layout.profile_fragment;
    }

    @Override
    protected void onCreated(Bundle savedInstanceState, View view) {

    }

    @Override
    public void onAction(String tag, Object... args) {

    }

}
