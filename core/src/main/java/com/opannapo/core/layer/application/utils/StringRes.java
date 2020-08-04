package com.opannapo.core.layer.application.utils;

import com.opannapo.core.layer.application.presenter.view.BaseActivity;

/**
 * Created by napouser on 04,August,2020
 */
public class StringRes {
    public static String of(BaseActivity activity, int resId) {
        return activity.getResources().getString(resId);
    }

    public static String inject(BaseActivity activity, int res, Object... value) {
        return String.format(activity.getResources().getString(res), value);
    }

}
