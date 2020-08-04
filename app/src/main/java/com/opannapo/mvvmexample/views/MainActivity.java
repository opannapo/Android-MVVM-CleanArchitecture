package com.opannapo.mvvmexample.views;

import android.os.Bundle;

import com.opannapo.core.layer.application.presenter.view.BaseActivity;
import com.opannapo.mvvmexample.R;

/**
 * Created by napouser on 04,August,2020
 */
class MainActivity extends BaseActivity {

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreated(Bundle savedInstanceState) {

    }
}
