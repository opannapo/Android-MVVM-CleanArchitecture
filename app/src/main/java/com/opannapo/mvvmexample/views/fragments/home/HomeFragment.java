package com.opannapo.mvvmexample.views.fragments.home;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.opannapo.core.layer.application.domain.User;
import com.opannapo.core.layer.application.presenter.view.BaseFragment;
import com.opannapo.core.layer.enterprise.utils.Log;
import com.opannapo.mvvmexample.R;
import com.opannapo.mvvmexample.views.adapter.UsersAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by napouser on 05,August,2020
 */
public class HomeFragment extends BaseFragment {
    HomeVM vm;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    UsersAdapter adapter;

    @Override
    protected int initLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void onCreated(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);

        vm = new ViewModelProvider(this).get(HomeVM.class);

        vm.liveUsers.observe(this, liveUsers);
        vm.liveLoadingState.observe(this, liveLoadingState);

        vm.getAllUsers(requireContext());

        adapter = new UsersAdapter(requireContext(), new ArrayList<>(), (i, user) -> {

        });
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAction(String tag, Object... args) {

    }

    final Observer<List<User>> liveUsers = data -> {
        new Thread(() -> {
            for (User user : data) {
                try {
                    Log.d("live liveUsers user " + user);
                    requireActivity().runOnUiThread(() -> adapter.notifyAddMoreData(user));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DUMMY_PROCESSING_THREAD").start();
    };

    final Observer<Integer> liveLoadingState = data -> {
        Log.d("live liveLoadingState " + data);
    };
}
