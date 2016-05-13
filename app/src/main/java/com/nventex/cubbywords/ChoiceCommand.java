package com.nventex.cubbywords;

import android.view.View;
import com.nventex.core.views.ICommand;

public class ChoiceCommand implements ICommand<Integer> {
    private View view;

    public View getView() {
        return this.view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
