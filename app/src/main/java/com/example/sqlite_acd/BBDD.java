package com.example.sqlite_acd;

import androidx.annotation.Nullable;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BBDD extends SQLiteOpenHelper {

    public BBDD(@Nullable Context context,@Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE LIDERESPOLITICOS (" +
                " NOMBRE TEXT PRIMARY KEY," +
                "EDAD INT," +
                "ESTUDIOS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
