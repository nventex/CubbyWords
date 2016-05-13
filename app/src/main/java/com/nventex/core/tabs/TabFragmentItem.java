package com.nventex.core.tabs;

import android.app.Fragment;

public class TabFragmentItem {
    private final Fragment fragment;
    private final String tabLabel;

    public String getTabLabel() {
        return this.tabLabel;
    }

    public TabFragmentItem(Fragment fragment, String tabLabel) {
        this.fragment = fragment;
        this.tabLabel = tabLabel;
    }

    public Fragment getFragment() {
        return this.fragment;
    }
}
