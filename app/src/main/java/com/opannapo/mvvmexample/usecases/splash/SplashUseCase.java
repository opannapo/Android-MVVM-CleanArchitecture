package com.opannapo.mvvmexample.usecases.splash;

import com.opannapo.mvvmexample.entities.User;

/**
 * Created by napouser on 04,August,2020
 */
public interface SplashUseCase {
    interface Action {
        void doGetUser(String val);
    }

    interface View {
        void getUser(String val);

        void onProcessing(String msg);

        void onUserResult(User val);
    }
}
