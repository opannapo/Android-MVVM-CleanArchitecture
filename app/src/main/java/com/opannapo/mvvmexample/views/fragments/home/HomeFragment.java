package com.opannapo.mvvmexample.views.fragments.home;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.opannapo.core.layer.application.domain.Owner;
import com.opannapo.core.layer.application.domain.User;
import com.opannapo.core.layer.application.presenter.view.BaseFragment;
import com.opannapo.core.layer.enterprise.utils.Log;
import com.opannapo.mvvmexample.R;

import java.util.List;

/**
 * Created by napouser on 05,August,2020
 */
public class HomeFragment extends BaseFragment {
    HomeVM vm;

    final Observer<List<User>> liveUsers = data -> {
        for (User user : data) {
            Log.d("live liveUsers user " + user);
        }
    };

    final Observer<Owner> liveOwner = data -> {
        Log.d("live liveOwner owner " + data);
    };

    final Observer<Integer> liveLoadingState = data -> {
        Log.d("live liveLoadingState " + data);
    };

    @Override
    protected int initLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void onCreated(Bundle savedInstanceState, View view) {
        vm = new ViewModelProvider(this).get(HomeVM.class);

        vm.liveUsers.observe(this, liveUsers);
        vm.liveLoadingState.observe(this, liveLoadingState);
        vm.liveOwner.observe(this, liveOwner);

        vm.getAllUsers(requireContext());
    }

    @Override
    public void onAction(String tag, Object... args) {

    }
}
