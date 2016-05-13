package com.nventex.core.views;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;

public class ButtonManager {

    /* renamed from: com.nventex.core.views.ButtonManager.1 */
    static class C00031 implements OnClickListener {
        final /* synthetic */ ICommand val$command;
        final /* synthetic */ ICommandHandler val$commandHandler;
        final /* synthetic */ Fragment val$fragment;

        C00031(ICommand iCommand, ICommandHandler iCommandHandler, Fragment fragment) {
            this.val$command = iCommand;
            this.val$commandHandler = iCommandHandler;
            this.val$fragment = fragment;
        }

        public void onClick(View v) {
            ButtonManager.setClickListener(v, this.val$command, this.val$commandHandler, this.val$fragment);
        }
    }

    /* renamed from: com.nventex.core.views.ButtonManager.2 */
    static class C00042 implements OnClickListener {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ ICommand val$command;
        final /* synthetic */ ICommandHandler val$commandHandler;

        C00042(ICommand iCommand, ICommandHandler iCommandHandler, Activity activity) {
            this.val$command = iCommand;
            this.val$commandHandler = iCommandHandler;
            this.val$activity = activity;
        }

        public void onClick(View v) {
            ButtonManager.setClickListener(v, this.val$command, this.val$commandHandler, this.val$activity);
        }
    }

    public static <T extends View> T setButtonCommand(View view, int id, ICommand command, ICommandHandler commandHandler, Fragment fragment) {
        View button = ViewHelper.getView(view, id);
        button.setOnClickListener(new C00031(command, commandHandler, fragment));
        return button;
    }

    public static <T extends View> T setButtonCommand(Activity activity, int id, ICommand command, ICommandHandler commandHandler) {
        View button = ViewHelper.getView(activity, id);
        button.setOnClickListener(new C00042(command, commandHandler, activity));
        return button;
    }

    private static <T> void setClickListener(View view, ICommand command, ICommandHandler commandHandler, T fragmentActivity) {
        command.setView(view);
        commandHandler.Execute(command);
        ((IActivityCore) fragmentActivity).OnEventCompleted(commandHandler.getCommandResult(), commandHandler.getClass().getSimpleName());
    }
}
