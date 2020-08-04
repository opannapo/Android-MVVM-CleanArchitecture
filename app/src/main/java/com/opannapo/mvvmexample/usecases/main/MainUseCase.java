package com.opannapo.mvvmexample.usecases.main;

import com.opannapo.mvvmexample.entities.User;

/**
 * Created by napouser on 04,August,2020
 */
public interface MainUseCase {
    interface Action {
        void doGetUser(String val);
    }

    interface View {
        void getUser(String val);

        void onProcessing();

        void onUserResult(User val);
    }
}
