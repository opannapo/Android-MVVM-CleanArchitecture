package com.opannapo.mvvmexample.usecases.main;

import android.content.Context;
import android.os.Handler;

import com.opannapo.core.layer.application.domain.Owner;
import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;
import com.opannapo.core.layer.enterprise.business.local.room.OwnerRulesImpl;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.utils.Log;
import com.opannapo.core.layer.interfaces.local.OwnerRules;


/**
 * Created by napouser on 05,August,2020
 */
public class MainUseCaseImpl extends BaseUseCase<MainUseCase.View> implements MainUseCase.Action {
    OwnerRules<Owner> ownerLocal = new OwnerRulesImpl();

    public MainUseCaseImpl(MainUseCase.View view) {
        super(view);
    }

    @Override
    public void doGetMyProfile(Context context) {
        view.onProcessing("Loading");

        new Handler().postDelayed(() -> {
            ownerLocal.get(context, new RoomGetOneCallback<Owner>() {
                @Override
                public void onProgress(String msg) {
                    view.onProcessing(msg);
                }

                @Override
                public void onComplete(Boolean isSuccess, Owner data, String error) {
                    if (data != null) Log.d("Owner data from DB " + data.toString());
                    view.onUserResult(data);
                }
            });
        }, 2000);

    }
}
