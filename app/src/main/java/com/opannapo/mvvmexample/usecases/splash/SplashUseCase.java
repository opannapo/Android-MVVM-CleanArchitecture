package com.opannapo.mvvmexample.usecases.splash;

/**
 * Created by napouser on 04,August,2020
 */
public interface SplashUseCase {
    interface Action {
        void doSync();
    }

    interface View {
        void firstSync();

        void onProcessing(String msg);

        void onSyncResult(String val);
    }
}
