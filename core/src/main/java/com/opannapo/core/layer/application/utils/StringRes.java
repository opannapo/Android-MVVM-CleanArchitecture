package com.opannapo.core.layer.application.utils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by napouser on 04,August,2020
 */
public class StringRes {
    public static String of(AppCompatActivity activity, int resId) {
        return activity.getResources().getString(resId);
    }

    public static String inject(AppCompatActivity activity, int res, Object... value) {
        return String.format(activity.getResources().getString(res), value);
    }

}
