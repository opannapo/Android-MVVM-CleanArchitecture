package com.opannapo.mvvmexample.usecases.profile;

import android.content.Context;

import com.opannapo.core.layer.application.domain.Owner;
import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;
import com.opannapo.core.layer.enterprise.business.local.room.OwnerRulesImpl;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.utils.Log;
import com.opannapo.core.layer.interfaces.local.OwnerRules;

/**
 * Created by napouser on 06,August,2020
 */
public class ProfileUseCaseImpl extends BaseUseCase<ProfileUseCase.View> implements ProfileUseCase.Action {
    OwnerRules<Owner> ownerLocal = new OwnerRulesImpl();

    public ProfileUseCaseImpl(ProfileUseCase.View view) {
        super(view);
    }

    @Override
    public void doGetMyProfile(Context context) {
        ownerLocal.get(context, new RoomGetOneCallback<Owner>() {
            @Override
            public void onProgress(String msg) {
                view.onProcessing(msg);
            }

            @Override
            public void onComplete(Boolean isSuccess, Owner data, String error) {
                if (data != null) Log.d("Owner data from DB " + data.toString());
                view.onMyProfileResult(data);
            }
        });
    }

    @Override
    public void doCreateMyProfile(Context context, Owner owner) {
        ownerLocal.insert(context, owner, new RoomTransactionalCallback() {
            @Override
            public void onProgress(String msg) {
                view.onProcessing(msg);
            }

            @Override
            public void onComplete(Boolean isSuccess, String error) {
                doGetMyProfile(context);
            }
        });
    }

    @Override
    public void doUpdateMyProfile(Context context, Owner owner) {
        ownerLocal.update(context, owner, new RoomTransactionalCallback() {
            @Override
            public void onProgress(String msg) {
                view.onProcessing(msg);
            }

            @Override
            public void onComplete(Boolean isSuccess, String error) {
                doGetMyProfile(context);
            }
        });
    }

}
