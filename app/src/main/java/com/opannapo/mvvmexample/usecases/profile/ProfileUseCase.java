package com.opannapo.mvvmexample.usecases.profile;

import android.content.Context;

import com.opannapo.core.layer.application.domain.Owner;

/**
 * Created by napouser on 06,August,2020
 */
public interface ProfileUseCase {
    interface Action {
        void doGetMyProfile(Context context);

        void doCreateMyProfile(Context context, Owner owner);

        void doUpdateMyProfile(Context context, Owner owner);
    }

    interface View {
        void getMyProfile(Context context);

        void createMyProfile(Context context, Owner owner);

        void updateMyProfile(Context context, Owner owner);

        void onProcessing(String msg);

        void onMyProfileResult(Owner owner);
    }
}

