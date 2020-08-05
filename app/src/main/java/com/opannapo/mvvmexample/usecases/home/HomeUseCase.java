package com.opannapo.mvvmexample.usecases.home;

import android.content.Context;

import com.opannapo.core.layer.application.domain.Owner;
import com.opannapo.core.layer.application.domain.User;

import java.util.List;

/**
 * Created by napouser on 06,August,2020
 */
public interface HomeUseCase {
    interface Action {
        void doGetMyProfile(Context context);

        void doGetAllUsers(Context context);
    }

    interface View {
        void getMyProfile(Context context);

        void getAllUsers(Context context);

        void onProcessing(String msg);

        void onUsersResult(List<User> users);

        void onMyProfileResult(Owner owner);
    }
}

