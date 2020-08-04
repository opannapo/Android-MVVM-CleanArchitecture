package com.opannapo.core.layer.interfaces.constants;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by napouser on 04,August,2020
 */
@Retention(SOURCE)
@IntDef({
        FragmentState.ON_ATTACH,
        FragmentState.ON_CREATE,
        FragmentState.ON_CREATE_VIEW,
        FragmentState.ON_ACTIVITY_CREATED,
        FragmentState.ON_VIEW_STATE_RESTORED,
        FragmentState.ON_START,
        FragmentState.ON_RESUME,
        FragmentState.ON_PAUSE,
        FragmentState.ON_STOP,
        FragmentState.ON_DESTROY_VIEW,
        FragmentState.ON_DESTROY,
        FragmentState.ON_DETACH,
        FragmentState.ON_VISIBLE,
        FragmentState.ON_HIDEN,
})
public @interface FragmentState {
    int ON_ATTACH = 1;
    int ON_CREATE = 2;
    int ON_CREATE_VIEW = 3;
    int ON_ACTIVITY_CREATED = 4;
    int ON_VIEW_STATE_RESTORED = 5;
    int ON_START = 6;
    int ON_RESUME = 7;
    int ON_PAUSE = 8;
    int ON_STOP = 9;
    int ON_DESTROY_VIEW = 10;
    int ON_DESTROY = 11;
    int ON_DETACH = 12;
    int ON_VISIBLE = 13;
    int ON_HIDEN = 14;
}
















