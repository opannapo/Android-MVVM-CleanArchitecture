package com.opannapo.core.layer.application.presenter.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by napouser on 04,August,2020
 */
public abstract class BaseFragment extends Fragment {
    public BaseFragmentListener listener;
    private int visibilityCount;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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

    public abstract void notifyAction(String tag, Object... args);
}


