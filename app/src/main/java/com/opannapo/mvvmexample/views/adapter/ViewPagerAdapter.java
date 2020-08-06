package com.opannapo.mvvmexample.views.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.opannapo.core.layer.application.presenter.view.BaseFragment;

/**
 * Created by napouser on 05,August,2020
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final BaseFragment<?>[] fragments = new BaseFragment[2];

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public BaseFragment<?> getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    public void addFragment(int idx, BaseFragment<?> val) {
        fragments[idx] = val;
    }
}