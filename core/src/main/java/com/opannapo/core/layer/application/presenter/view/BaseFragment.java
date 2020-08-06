package com.opannapo.core.layer.application.presenter.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by napouser on 04,August,2020
 */
public abstract class BaseFragment<VM extends BaseViewModel<?>> extends Fragment {
    public VM vm;
    public BaseFragmentListener listener;
    private int visibilityCount;

    protected abstract Class<VM> initVM();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (initVM() != null) vm = (VM) new ViewModelProvider(this).get(initVM());

        View view = inflater.inflate(initLayout(), container, false);
        onCreated(savedInstanceState, view);
        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) visibilityCount++;
    }

    public boolean isFirstVisibile() {
        System.out.println("BaseFragment::" + this.getClass().getSimpleName() + " --> isFirstVisibile --> visibilityCount : " + visibilityCount);
        return visibilityCount == 1;
    }

    public int getVisibilityCount() {
        return visibilityCount;
    }

    public void setListener(BaseFragmentListener listener) {
        this.listener = listener;
    }

    public BaseFragmentListener getListener() {
        return listener;
    }

    protected abstract int initLayout();

    protected abstract void onCreated(Bundle savedInstanceState, View view);

    public abstract void onAction(String tag, Object... args);
}


