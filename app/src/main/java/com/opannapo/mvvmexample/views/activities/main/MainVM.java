package com.opannapo.mvvmexample.views.activities.main;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.opannapo.core.layer.application.domain.Owner;
import com.opannapo.core.layer.application.presenter.view.BaseViewModel;
import com.opannapo.mvvmexample.usecases.main.MainUseCase;
import com.opannapo.mvvmexample.usecases.main.MainUseCaseImpl;

/**
 * Created by napouser on 05,August,2020
 */
public class MainVM extends BaseViewModel<MainUseCaseImpl> implements MainUseCase.View {
    public MutableLiveData<Integer> liveLoadingState = new MutableLiveData<>(); //1 loading
    public MutableLiveData<String> liveLoadingMessage = new MutableLiveData<>();
    public MutableLiveData<Owner> liveOwner = new MutableLiveData<>();


    @Override
    protected MainUseCaseImpl initUseCase() {
        return new MainUseCaseImpl(this);
    }

    @Override
    public void getMyProfile(Context context) {
        liveLoadingState.postValue(1);
        useCase.doGetMyProfile(context);
    }

    @Override
    public void onProcessing(String msg) {
        liveLoadingMessage.postValue(msg);
    }

    @Override
    public void onUserResult(Owner owner) {
        liveLoadingState.postValue(0);
        liveOwner.postValue(owner);
    }
}