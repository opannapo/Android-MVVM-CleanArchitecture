package com.opannapo.core.layer.application.presenter.view;

import com.opannapo.core.layer.interfaces.constants.FragmentState;

/**
 * Created by napouser on 04,August,2020
 */
public interface BaseFragmentListener {
    void onFragmentState(String tag, @FragmentState int state);

    void onFragmentAction(String tag, Object... args);
}