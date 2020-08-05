package com.opannapo.mvvmexample.usecases.splash;

import android.annotation.SuppressLint;
import android.content.Context;

import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;
import com.opannapo.core.layer.enterprise.business.local.room.OwnerRulesImpl;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.business.local.room.entities.Owner;
import com.opannapo.core.layer.enterprise.utils.Log;
import com.opannapo.core.layer.interfaces.local.OwnerRules;

/**
 * Created by napouser on 04,August,2020
 */
public class SplashUseCaseImpl extends BaseUseCase<SplashUseCase.View> implements SplashUseCase.Action {
    OwnerRules<Owner> ownerRules = new OwnerRulesImpl();

    public SplashUseCaseImpl(SplashUseCase.View view) {
        super(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void doSync(Context context) {
        /*new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(50);
                    if (i == 100 - 1) {
                        view.onSyncResult("Completed");
                    } else {
                        view.onProcessing(String.format("%d of %d", i, 100));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "THREAD_DUMMY_SYNC"
        ).start();*/


        Owner owner = new Owner();
        owner.setId(1);
        owner.setEmail("taufan.alfazri@gmail.com");
        owner.setFirstName("Opan");
        owner.setLastName("napo");
        ownerRules.insert(context, owner, new RoomTransactionalCallback() {
            @Override
            public void onProgress(String msg) {
                view.onProcessing("Insert Data");
            }

            @Override
            public void onComplete(Boolean isSuccess, String error) {
                //view.onSyncResult("Completed");
                ownerRules.get(context, new RoomGetOneCallback<Owner>() {
                    @Override
                    public void onProgress(String msg) {

                    }

                    @Override
                    public void onComplete(Boolean isSuccess, Owner data, String error) {
                        Log.d("Owner data " + data);
                        view.onSyncResult("Completed");
                    }
                });
            }
        });
    }
}
