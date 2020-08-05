package com.opannapo.mvvmexample.views.activities.main;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.opannapo.core.layer.application.presenter.view.BaseActivity;
import com.opannapo.mvvmexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by napouser on 05,August,2020
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.imgProfile)
    ImageView imgProfile;
    @BindView(R.id.txtProfileName)
    TextView txtProfileName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbarRoot)
    AppBarLayout toolbarRoot;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreated(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

}
