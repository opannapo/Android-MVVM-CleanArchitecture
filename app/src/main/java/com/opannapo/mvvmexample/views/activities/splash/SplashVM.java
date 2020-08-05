package com.opannapo.mvvmexample.views.activities.splash;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.opannapo.core.layer.application.presenter.view.BaseViewModel;
import com.opannapo.mvvmexample.usecases.splash.SplashUseCase;
import com.opannapo.mvvmexample.usecases.splash.SplashUseCaseImpl;

/**
 * Created by napouser on 04,August,2020
 */
public class SplashVM extends BaseViewModel<SplashUseCaseImpl> implements SplashUseCase.View {
    protected MutableLiveData<Integer> liveLoadingState = new MutableLiveData<>(); //1 loading
    protected MutableLiveData<String> liveLoadingMessage = new MutableLiveData<>();
    protected MutableLiveData<String> liveSync = new MutableLiveData<>();

    @Override
    protected SplashUseCaseImpl initUseCase() {
        return new SplashUseCaseImpl(this);
    }

    @Override
    public void firstSync(Context context) {
        useCase.doSync(context);
    }

    @Override
    public void onProcessing(String msg) {
        liveLoadingState.postValue(1);//Is Loading
        liveLoadingMessage.postValue(msg);
    }

    @Override
    public void onSyncResult(String val) {
        liveSync.postValue(val);
        liveLoadingState.postValue(0);//Is Completed
    }
}
