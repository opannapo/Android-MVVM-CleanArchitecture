package com.opannapo.mvvmexample.views.fragments.profile;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.opannapo.core.layer.application.domain.Owner;
import com.opannapo.core.layer.application.presenter.view.BaseViewModel;
import com.opannapo.mvvmexample.usecases.profile.ProfileUseCase;
import com.opannapo.mvvmexample.usecases.profile.ProfileUseCaseImpl;

/**
 * Created by napouser on 06,August,2020
 */
public class ProfileVM extends BaseViewModel<ProfileUseCaseImpl> implements ProfileUseCase.View {
    public MutableLiveData<Integer> liveLoadingState = new MutableLiveData<>(); //1 loading
    public MutableLiveData<Owner> liveOwner = new MutableLiveData<>();

    @Override
    protected ProfileUseCaseImpl initUseCase() {
        return new ProfileUseCaseImpl(this);
    }

    @Override
    public void getMyProfile(Context context) {
        useCase.doGetMyProfile(context);
    }

    @Override
    public void createMyProfile(Context context, Owner owner) {
        useCase.doCreateMyProfile(context, owner);
    }

    @Override
    public void updateMyProfile(Context context, Owner owner) {
        useCase.doUpdateMyProfile(context, owner);
    }

    @Override
    public void onProcessing(String msg) {
        liveLoadingState.postValue(1);
    }

    @Override
    public void onMyProfileResult(Owner owner) {
        liveLoadingState.postValue(0);
        liveOwner.postValue(owner);
    }
}
