package com.nventex.cubbywords;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;
import java.io.IOException;

public class CubbyApplication extends Application {
    public void onCreate() {
        try {
            new DatabaseHelper(this).createDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
