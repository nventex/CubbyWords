package com.nventex.cubbywords;

import android.app.Activity;
import android.os.Bundle;
import com.nventex.core.views.FragmentActivityManager;

public class MainActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0005R.layout.activity_main);
        FragmentActivityManager.Initialize(this);
        FragmentActivityManager.AddFragment(C0005R.id.mainContainer, savedInstanceState, new FragmentMenu());
    }
}
