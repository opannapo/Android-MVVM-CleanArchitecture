package com.opannapo.mvvmexample.views.activities.main;

import androidx.lifecycle.MutableLiveData;

import com.opannapo.core.layer.application.presenter.view.BaseViewModel;
import com.opannapo.mvvmexample.entities.User;
import com.opannapo.mvvmexample.usecases.main.MainUseCase;
import com.opannapo.mvvmexample.usecases.main.MainUseCaseImpl;

/**
 * Created by napouser on 05,August,2020
 */
public class MainVM extends BaseViewModel<MainUseCaseImpl> implements MainUseCase.View {
    protected MutableLiveData<Integer> liveLoadingState = new MutableLiveData<>(); //1 loading
    protected MutableLiveData<String> liveLoadingMessage = new MutableLiveData<>();
    protected MutableLiveData<User> liveUser = new MutableLiveData<>();


    @Override
    protected MainUseCaseImpl initUseCase() {
        return new MainUseCaseImpl(this);
    }

    @Override
    public void getMyProfile() {
        liveLoadingState.postValue(1);
        useCase.doGetMyProfile();
    }

    @Override
    public void onProcessing(String msg) {
        liveLoadingMessage.postValue(msg);
    }

    @Override
    public void onUserResult(User user) {
        liveLoadingState.postValue(0);
        liveUser.postValue(user);
    }
}