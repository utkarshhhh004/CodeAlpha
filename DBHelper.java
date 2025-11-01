package com.example.languagelearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "LanguageDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE words(id INTEGER PRIMARY KEY AUTOINCREMENT, english TEXT, translated TEXT)");
        db.execSQL("INSERT INTO words(english, translated) VALUES('Hello', 'Hola'), ('Thank you', 'Gracias'), ('Good morning', 'Buenos días'), ('Water', 'Agua'), ('Food', 'Comida')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS words");
        onCreate(db);
    }

    public Cursor getAllWords() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM words", null);
    }
}
