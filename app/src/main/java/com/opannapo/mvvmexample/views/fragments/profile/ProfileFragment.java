package com.opannapo.mvvmexample.views.fragments.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.opannapo.core.layer.application.domain.Owner;
import com.opannapo.core.layer.application.presenter.view.BaseFragment;
import com.opannapo.mvvmexample.R;
import com.opannapo.mvvmexample.views.activities.main.MainVM;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by napouser on 05,August,2020
 */
public class ProfileFragment extends BaseFragment {
    MainVM sharedVm;
    ProfileVM vm;

    @BindView(R.id.btnCreateProfile)
    Button btnCreateProfile;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtFirstName)
    EditText edtFirstName;
    @BindView(R.id.edtLastName)
    EditText edtLastName;
    @BindView(R.id.btnSaveProfile)
    Button btnSaveProfile;
    @BindView(R.id.layContent)
    LinearLayout layContent;

    @Override
    protected int initLayout() {
        return R.layout.profile_fragment;
    }

    @Override
    protected void onCreated(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);

        sharedVm = new ViewModelProvider(requireActivity()).get(MainVM.class);
        vm = new ViewModelProvider(this).get(ProfileVM.class);

        vm.liveOwner.observe(this, liveOwner);

        vm.getMyProfile(requireContext());
    }

    @Override
    public void onAction(String tag, Object... args) {

    }

    @OnClick({R.id.btnCreateProfile, R.id.btnSaveProfile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnCreateProfile:
                btnCreateProfile.setVisibility(View.GONE);
                layContent.setVisibility(View.VISIBLE);
                break;
            case R.id.btnSaveProfile:
                if (vm.liveOwner.getValue() != null) {
                    Owner owner = vm.liveOwner.getValue();
                    owner.setEmail(edtEmail.getText().toString());
                    owner.setFirstName(edtFirstName.getText().toString());
                    owner.setLastName(edtLastName.getText().toString());
                    vm.updateMyProfile(requireContext(), owner);
                } else {
                    Owner owner = new Owner();
                    owner.setEmail(edtEmail.getText().toString());
                    owner.setFirstName(edtFirstName.getText().toString());
                    owner.setLastName(edtLastName.getText().toString());
                    vm.createMyProfile(requireContext(), owner);
                }
                break;
        }
    }


    final Observer<Owner> liveOwner = data -> {
        if (data == null) {
            btnCreateProfile.setVisibility(View.VISIBLE);
            layContent.setVisibility(View.GONE);
        } else {
            btnCreateProfile.setVisibility(View.GONE);
            layContent.setVisibility(View.VISIBLE);
            btnSaveProfile.setText("Update Profile");
            edtEmail.setText(data.getEmail());
            edtFirstName.setText(data.getFirstName());
            edtLastName.setText(data.getLastName());

            sharedVm.liveOwner.postValue(data);
        }
    };
}
