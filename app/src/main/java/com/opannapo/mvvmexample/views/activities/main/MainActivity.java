package com.opannapo.mvvmexample.views.activities.main;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.opannapo.core.layer.application.presenter.view.BaseActivity;
import com.opannapo.core.layer.application.presenter.view.BaseFragment;
import com.opannapo.core.layer.enterprise.utils.Log;
import com.opannapo.mvvmexample.R;
import com.opannapo.mvvmexample.views.adapter.ViewPagerAdapter;
import com.opannapo.mvvmexample.views.fragments.HomeFragment;
import com.opannapo.mvvmexample.views.fragments.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.opannapo.mvvmexample.R2.string.appbar_scrolling_view_behavior;

/**
 * Created by napouser on 05,August,2020
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.imgProfile)
    ImageView imgProfile;
    @BindView(R.id.txtProfileName)
    TextView txtProfileName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bottomNavigation)
    BottomNavigationView bottomNavigation;
    @BindView(R.id.vpPages)
    ViewPager vpPages;

    HomeFragment homeFragment;
    ProfileFragment profileFragment;
    ViewPagerAdapter vpAdapter;
    BaseFragment currentFragment;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreated(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        initialFragmentMember();
        initialNavigation();
    }

    private void initialNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navPageHome:
                    if (currentFragment == homeFragment) return false;
                    vpPages.setCurrentItem(0, true);
                    return true;
                case R.id.navPageProfile:
                    if (currentFragment == profileFragment) return false;
                    vpPages.setCurrentItem(1, true);
                    return true;
                default:
                    return false;
            }
        });
    }

    private void initialFragmentMember() {
        vpAdapter = new ViewPagerAdapter(this.getSupportFragmentManager(), appbar_scrolling_view_behavior);
        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();

        vpAdapter.addFragment(0, homeFragment);
        vpAdapter.addFragment(1, profileFragment);
        vpPages.setAdapter(vpAdapter);
        vpPages.setOffscreenPageLimit(2);
        vpPages.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i("ViewPager onPageScrolled, position: " + position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.i("ViewPager onPageSelected, position: " + position);
                switch (position) {
                    case 0:
                        currentFragment = homeFragment;
                        //bottomNavigation.setSelectedItemId(R.id.navPageHome);
                        bottomNavigation.getMenu().getItem(0).setChecked(true);
                        break;
                    case 1:
                        currentFragment = profileFragment;
                        //bottomNavigation.setSelectedItemId(R.id.navPageProfile);
                        bottomNavigation.getMenu().getItem(1).setChecked(true);
                        break;
                }
                currentFragment.onHiddenChanged(false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("ViewPager onPageScrollStateChanged, state: " + state);
            }
        });


    }
}
