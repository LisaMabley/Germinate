package edu.mctc.lisa.kindling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.mctc.lisa.kindling.database.EntryCursorWrapper;
import edu.mctc.lisa.kindling.database.EntryDatabaseHelper;
import edu.mctc.lisa.kindling.database.EntryDbSchema.EntryTable;

/**
 * Created by lisa on 11/22/15.
 */

public class EntryManager {
    protected static EntryManager sEntryManager;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private static final String TAG = "GERM.entrymanager";

    public static EntryManager get(Context context) {
        if (sEntryManager == null) {
            sEntryManager = new EntryManager(context);
        }

        return sEntryManager;
    }

    private EntryManager(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new EntryDatabaseHelper(mContext).getWritableDatabase();
    }

    public void addEntry(Entry e) {
        ContentValues values = getContentValues(e);
        Log.d(TAG, values.toString());
        mDatabase.insert(EntryTable.DBNAME, null, values);
    }

    public List<Entry> getEntries() {
        List<Entry> entries = new ArrayList<>();
        EntryCursorWrapper cursor = queryEntries(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                entries.add(cursor.getEntry());
                cursor.moveToNext();
            }

        } finally {
            cursor.close();
        }

        return entries;
    }

    public Entry getEntry(UUID id) {
        EntryCursorWrapper cursor = queryEntries(
                EntryTable.Columns.UUID + " = ?", new String[]{id.toString()}
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getEntry();

        } finally {
            cursor.close();
        }
    }

    public void updateEntry(Entry entry) {
        String uuidString = entry.getId().toString();
        ContentValues values = getContentValues(entry);

        mDatabase.update(EntryTable.DBNAME, values, EntryTable.Columns.UUID + " = ?", new String[] { uuidString});
    }

    private static ContentValues getContentValues(Entry entry) {
        ContentValues values = new ContentValues();
        values.put(EntryTable.Columns.UUID, entry.getId().toString());
        values.put(EntryTable.Columns.DATE, entry.getDate().getTime());
        values.put(EntryTable.Columns.TEXT, entry.getText());

        return values;
    }

    private EntryCursorWrapper queryEntries(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                EntryTable.DBNAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);

        return new EntryCursorWrapper(cursor);
    }
}
