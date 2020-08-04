package com.opannapo.mvvmexample.views.activities.splash;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.opannapo.core.layer.application.presenter.view.BaseActivity;
import com.opannapo.mvvmexample.R;
import com.opannapo.mvvmexample.entities.User;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by napouser on 04,August,2020
 */
public class SplashActivity extends BaseActivity {
    SplashVM vm;

    @BindView(R.id.txtLoadingMsg)
    TextView txtLoadingMsg;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    final Observer<User> liveUser = data -> {
        txtLoadingMsg.setText(data.getName());
        progressBar.setVisibility(View.GONE);
    };

    final Observer<Integer> liveLoadingState = data -> progressBar.setVisibility(data == 1 ? View.VISIBLE : View.GONE);

    final Observer<String> liveLoadingMessage = data -> txtLoadingMsg.setText(data);

    @Override
    protected int initLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreated(Bundle savedInstanceState) {
        ButterKnife.bind(this);

        vm = new ViewModelProvider(this).get(SplashVM.class);

        vm.liveUser.observe(this, liveUser);
        vm.liveLoadingState.observe(this, liveLoadingState);
        vm.liveLoadingMessage.observe(this, liveLoadingMessage);

        vm.getUser("opannapo");
    }
}
