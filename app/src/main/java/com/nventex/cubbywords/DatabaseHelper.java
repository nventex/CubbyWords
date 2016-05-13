package com.nventex.cubbywords;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_NAME;
    private static String DB_PATH;
    private final Context myContext;

    static {
        DB_PATH = "/data/data/com.nventex.cubbywords/databases/";
        DB_NAME = "CubbyWords.db";
    }

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    public void createDatabase() throws IOException {
        if (!checkDatabase()) {
            getReadableDatabase();
            try {
                copyDatabase();
            } catch (IOException e) {
                throw new Error(e.getMessage());
            }
        }
    }

    private boolean checkDatabase() {
        return new File(DB_PATH + DB_NAME).exists();
    }

    private void copyDatabase() throws IOException {
        InputStream myInput = this.myContext.getAssets().open(DB_NAME);
        OutputStream myOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] buffer = new byte[1024];
        while (true) {
            int length = myInput.read(buffer);
            if (length > 0) {
                myOutput.write(buffer, 0, length);
            } else {
                myOutput.flush();
                myOutput.close();
                myInput.close();
                return;
            }
        }
    }

    public synchronized void close() {
        super.close();
    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
