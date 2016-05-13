package com.nventex.core.views;

import android.view.Menu;
import android.view.MenuItem;

public interface IActionBar {
    boolean onCreateOptionsMenu(Menu menu);

    boolean onOptionsItemSelected(MenuItem menuItem);
}
