package com.opannapo.mvvmexample.usecases.splash;

import android.content.Context;

/**
 * Created by napouser on 04,August,2020
 */
public interface SplashUseCase {
    interface Action {
        void doSync(Context context);
    }

    interface View {
        void firstSync(Context context);

        void onProcessing(String msg);

        void onSyncResult(String val);
    }
}
