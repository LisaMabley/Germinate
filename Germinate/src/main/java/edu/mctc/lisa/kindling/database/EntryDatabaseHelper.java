package edu.mctc.lisa.kindling.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import edu.mctc.lisa.kindling.database.EntryDbSchema.EntryTable;

/**
 * Created by lisa on 11/19/15.
 * Adapted from Big Nerd Ranch Guide to Android Programming, 2nd Edition
 *
 */

public class EntryDatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "entryDatabase.db";

    public EntryDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + EntryTable.DBNAME + "(" +
                        " _id integer primary key autoincrement, " +
                        EntryTable.Columns.UUID + ", " +
                        EntryTable.Columns.DATE + ", " +
                        EntryTable.Columns.TEXT + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
