package com.opannapo.mvvmexample.views.fragments.home;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.opannapo.core.layer.application.domain.User;
import com.opannapo.core.layer.application.presenter.view.BaseViewModel;
import com.opannapo.mvvmexample.usecases.home.HomeUseCase;
import com.opannapo.mvvmexample.usecases.home.HomeUseCaseImpl;

import java.util.List;

/**
 * Created by napouser on 06,August,2020
 */
public class HomeVM extends BaseViewModel<HomeUseCaseImpl> implements HomeUseCase.View {
    public MutableLiveData<Integer> liveLoadingState = new MutableLiveData<>(); //1 loading
    public MutableLiveData<List<User>> liveUsers = new MutableLiveData<>();

    @Override
    protected HomeUseCaseImpl initUseCase() {
        return new HomeUseCaseImpl(this);
    }

    @Override
    public void getAllUsers(Context context) {
        useCase.doGetAllUsers(context);
    }

    @Override
    public void onProcessing(String msg) {
        liveLoadingState.postValue(1);
    }

    @Override
    public void onUsersResult(List<User> users) {
        liveLoadingState.postValue(0);
        liveUsers.postValue(users);
    }

}
