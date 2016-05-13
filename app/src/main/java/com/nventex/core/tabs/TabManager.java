package com.nventex.core.tabs;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import java.util.List;

public class TabManager {
    private final ActionBar actionBar;
    private final int fragmentContainerId;
    private final List<TabFragmentItem> tabFragmentItems;

    public TabManager(List<TabFragmentItem> tabFragmentItems, ActionBar actionBar, int fragmentContainerId) {
        this.tabFragmentItems = tabFragmentItems;
        this.actionBar = actionBar;
        this.fragmentContainerId = fragmentContainerId;
        Initialize();
    }

    private void Initialize() {
        this.actionBar.setNavigationMode(2);
        for (TabFragmentItem item : this.tabFragmentItems) {
            Fragment fragment = item.getFragment();
            Tab tab = this.actionBar.newTab().setText(item.getTabLabel());
            tab.setTabListener(new TabListenerBase(fragment, this.fragmentContainerId));
            this.actionBar.addTab(tab);
        }
    }
}
