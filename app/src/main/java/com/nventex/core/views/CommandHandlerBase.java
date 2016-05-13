package com.nventex.core.views;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public abstract class CommandHandlerBase<T> {
    private final Activity activity;
    private final Fragment fragment;
    private final int fragmentContainerId;
    private final Bundle savedInstanceState;

    public abstract ICommandResult<T> getCommandResult();

    public Fragment getFragment() {
        return this.fragment;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public Bundle getSavedInstanceState() {
        return this.savedInstanceState;
    }

    public CommandHandlerBase(Bundle savedInstanceState, Activity activity, Fragment fragment, int fragmentContainerId) {
        this.savedInstanceState = savedInstanceState;
        this.activity = activity;
        this.fragment = fragment;
        this.fragmentContainerId = fragmentContainerId;
    }

    public void Execute(ICommand command) {
    }
}
