package com.nventex.cubbywords;

import android.view.View;
import com.nventex.core.views.ICommand;
import com.nventex.core.views.UnitType;

public class StartGameCommand implements ICommand<UnitType> {
    private View view;

    public View getView() {
        return this.view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
