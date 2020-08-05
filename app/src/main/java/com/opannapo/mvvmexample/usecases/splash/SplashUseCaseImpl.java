package com.opannapo.mvvmexample.usecases.splash;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.opannapo.core.layer.application.domain.Owner;
import com.opannapo.core.layer.application.domain.User;
import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;
import com.opannapo.core.layer.enterprise.business.local.room.OwnerRulesImpl;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.business.rest.UserRulesImpl;
import com.opannapo.core.layer.enterprise.business.rest.callbacks.EndpointGetManyCallback;
import com.opannapo.core.layer.enterprise.utils.Log;
import com.opannapo.core.layer.interfaces.local.OwnerRules;
import com.opannapo.core.layer.interfaces.rest.UserRules;

import java.util.List;

/**
 * Created by napouser on 04,August,2020
 */
public class SplashUseCaseImpl extends BaseUseCase<SplashUseCase.View> implements SplashUseCase.Action {
    com.opannapo.core.layer.interfaces.local.UserRules<User> userLocal = new com.opannapo.core.layer.enterprise.business.local.room.UserRulesImpl();
    OwnerRules<Owner> ownerLocal = new OwnerRulesImpl();
    UserRules<JsonObject> userRemote = new UserRulesImpl();

    public SplashUseCaseImpl(SplashUseCase.View view) {
        super(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void doSync(Context context) {
        view.onProcessing("Prepare Sync");
        userRemote.getAll(new EndpointGetManyCallback<JsonObject>() {
            @Override
            public void onProgress(String msg) {
                view.onProcessing("Request Data");
            }

            @Override
            public void onComplete(Boolean isSuccess, JsonObject data, String error) {
                Log.d("User data " + data);

                if (isSuccess) {
                    if (data.has("data") && data.get("data") instanceof JsonArray) {
                        Gson gson = new Gson();
                        List<User> users = gson.fromJson(data.getAsJsonArray("data"), new TypeToken<List<User>>() {
                        }.getType());

                        userLocal.insertAll(context, users, new RoomTransactionalCallback() {
                            @Override
                            public void onProgress(String msg) {
                                view.onProcessing("Insert Data");
                            }

                            @Override
                            public void onComplete(Boolean isSuccess, String error) {
                                /*userLocal.getAll(context, new RoomGetManyCallback<User>() {

                                    @Override
                                    public void onProgress(String msg) {

                                    }

                                    @Override
                                    public void onComplete(Boolean isSuccess, List<User> data, String error) {
                                        for (User datum : data) {
                                            Log.d("User data from DB " + datum.toString());
                                        }
                                        view.onSyncResult("Completed");
                                    }
                                });*/

                                view.onSyncResult("Completed");
                            }
                        });
                    } else {
                        Log.d("User data NO " + data);
                        view.onSyncResult("Completed");
                    }
                }
            }
        });
    }
}
