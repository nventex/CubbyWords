package com.nventex.core.views;

import android.view.View;

public interface ICommand<T> {
    View getView();

    void setView(View view);
}
