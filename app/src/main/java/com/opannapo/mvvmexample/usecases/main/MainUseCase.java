package com.opannapo.mvvmexample.usecases.main;

import com.opannapo.mvvmexample.entities.User;

/**
 * Created by napouser on 05,August,2020
 */
public interface MainUseCase {
    interface Action {
        void doGetMyProfile();
    }

    interface View {
        void getMyProfile();

        void onProcessing(String msg);

        void onUserResult(User user);
    }
}
