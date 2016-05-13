package com.nventex.core.views;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class FragmentActivityManager<TFragmentInterface> {
    protected static Activity activity;

    public static void Initialize(Activity activity) {
        activity = activity;
    }

    public static void AddFragment(int fragmentContainer, Bundle bundle, Fragment fragmentToAdd) {
        if (activity.findViewById(fragmentContainer) != null && bundle == null) {
            fragmentToAdd.setArguments(bundle);
            activity.getFragmentManager().beginTransaction().add(fragmentContainer, fragmentToAdd).commit();
        }
    }

    public static void ReplaceFragment(int fragmentContainer, Fragment newFragment, boolean addToBackStack) {
        Replace(fragmentContainer, newFragment, addToBackStack);
    }

    public static void ReplaceFragment(int fragmentContainer, Fragment newFragment) {
        Replace(fragmentContainer, newFragment, true);
    }

    private static void Replace(int fragmentContainer, Fragment newFragment, boolean addToBackStack) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        transaction.replace(fragmentContainer, newFragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    public static <T extends Fragment> T getFragment(int id) {
        return activity.getFragmentManager().findFragmentById(id);
    }
}
