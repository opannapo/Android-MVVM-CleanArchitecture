package com.opannapo.mvvmexample.usecases.main;


import android.content.Context;

import com.opannapo.core.layer.application.domain.Owner;

/**
 * Created by napouser on 05,August,2020
 */
public interface MainUseCase {
    interface Action {
        void doGetMyProfile(Context context);
    }

    interface View {
        void getMyProfile(Context context);

        void onProcessing(String msg);

        void onUserResult(Owner owner);
    }
}
