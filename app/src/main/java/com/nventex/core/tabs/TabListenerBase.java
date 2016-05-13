package com.nventex.core.tabs;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class TabListenerBase implements TabListener {
    private final Fragment fragment;
    private final int fragmentContainerId;

    public TabListenerBase(Fragment fragment, int fragmentContainerId) {
        this.fragment = fragment;
        this.fragmentContainerId = fragmentContainerId;
    }

    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        ft.replace(this.fragmentContainerId, this.fragment);
    }

    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        ft.remove(this.fragment);
    }

    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
}
