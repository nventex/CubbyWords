package com.nventex.core.views;

import android.app.DialogFragment;
import android.app.FragmentManager;

public abstract class DialogFragmentCommandHandlerBase {
    private DialogFragment dialogFragment;
    private FragmentManager fragmentManager;

    public DialogFragment getDialogFragment() {
        return this.dialogFragment;
    }

    public void setDialogFragment(DialogFragment dialogFragment) {
        this.dialogFragment = dialogFragment;
    }

    private void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public DialogFragmentCommandHandlerBase(FragmentManager fragmentManager, DialogFragment dialogFragment) {
        setFragmentManager(fragmentManager);
        setDialogFragment(dialogFragment);
    }
}
