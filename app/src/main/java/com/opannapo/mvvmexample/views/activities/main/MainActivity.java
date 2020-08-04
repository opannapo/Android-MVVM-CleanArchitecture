package com.opannapo.mvvmexample.views.activities.main;

import android.os.Bundle;
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
public class MainActivity extends BaseActivity {
    MainVM vm;
    @BindView(R.id.text)
    TextView text;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreated(Bundle savedInstanceState) {
        ButterKnife.bind(this);

        vm = new ViewModelProvider(this).get(MainVM.class);
        final Observer<User> liveUser = data -> {
            /*toolbarTransformer.setOnlineOrderCount(count);
            txtTotalOnlineOrder.setText(String.valueOf(count));*/
        };
        vm.liveUser.observe(this, liveUser);
    }
}
