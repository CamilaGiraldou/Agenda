package com.camilagiraldo.agenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 31/10/2017.
 */

public class Datos extends SQLiteOpenHelper {
    private String DataBaseName = "Agenda";
    private int DATAVERSION = 1;
    private String sqlCreate = "CREATE TABLE contactos("+
            "id         INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "libro     TEXT,"+
            "usuario   TEXT,"+
            "telefono     TEXT)";

    public Datos (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super (context, name , factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Contactos");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
