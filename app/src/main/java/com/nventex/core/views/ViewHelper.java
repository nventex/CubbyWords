package com.nventex.core.views;

import android.app.Activity;
import android.view.View;

public class ViewHelper {
    public static <T extends View> T getView(Activity activity, int id) {
        return activity.findViewById(id);
    }

    public static <T extends View> T getView(View parent, int id) {
        return parent.findViewById(id);
    }
}
