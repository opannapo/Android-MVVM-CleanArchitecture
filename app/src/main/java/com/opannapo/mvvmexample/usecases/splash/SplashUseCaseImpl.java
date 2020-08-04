package com.opannapo.mvvmexample.usecases.splash;

import android.annotation.SuppressLint;

import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;

/**
 * Created by napouser on 04,August,2020
 */
public class SplashUseCaseImpl extends BaseUseCase<SplashUseCase.View> implements SplashUseCase.Action {

    public SplashUseCaseImpl(SplashUseCase.View view) {
        super(view);
    }


    @SuppressLint("DefaultLocale")
    @Override
    public void doSync() {
        new Thread(() -> {
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
        ).start();
    }
}
