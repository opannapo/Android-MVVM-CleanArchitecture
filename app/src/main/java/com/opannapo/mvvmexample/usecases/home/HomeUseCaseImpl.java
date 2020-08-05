package com.opannapo.mvvmexample.usecases.home;

import android.content.Context;

import com.opannapo.core.layer.application.domain.Owner;
import com.opannapo.core.layer.application.domain.User;
import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;
import com.opannapo.core.layer.enterprise.business.local.room.OwnerRulesImpl;
import com.opannapo.core.layer.enterprise.business.local.room.UserRulesImpl;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetManyCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.utils.Log;
import com.opannapo.core.layer.interfaces.local.OwnerRules;
import com.opannapo.core.layer.interfaces.local.UserRules;

import java.util.List;

/**
 * Created by napouser on 06,August,2020
 */
public class HomeUseCaseImpl extends BaseUseCase<HomeUseCase.View> implements HomeUseCase.Action {
    UserRules<User> userLocal = new UserRulesImpl();
    OwnerRules<Owner> ownerLocal = new OwnerRulesImpl();

    public HomeUseCaseImpl(HomeUseCase.View view) {
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
                Log.d("Owner data from DB " + data.toString());
                view.onMyProfileResult(data);
            }
        });
    }

    @Override
    public void doGetAllUsers(Context context) {
        userLocal.getAll(context, new RoomGetManyCallback<User>() {
            @Override
            public void onProgress(String msg) {
                view.onProcessing(msg);
            }

            @Override
            public void onComplete(Boolean isSuccess, List<User> data, String error) {
                for (User datum : data) {
                    Log.d("User data from DB " + datum.toString());
                }
                view.onUsersResult(data);
            }
        });
    }
}
