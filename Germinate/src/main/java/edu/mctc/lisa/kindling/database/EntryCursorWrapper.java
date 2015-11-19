package edu.mctc.lisa.kindling.database;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by lisa on 11/19/15.
 */

public class EntryCursorWrapper extends CursorWrapper {

    public EntryCursorWrapper(Cursor cursor) {
        super(cursor);
    }

//    public TextEntry getEntry() {
//        String uuidString = getString(getColumnIndex(EntryDbSchema.EntryTable.Columns.UUID));
//        long date = getLong(getColumnIndex(EntryDbSchema.EntryTable.Columns.DATE));
//        String text = getString(getColumnIndex(EntryDbSchema.EntryTable.Columns.TEXT));
//
//        TextEntry newTextEntry = new TextEntry(UUID.fromString(uuidString));
//        newTextEntry.setTitle(title);
//        newTextEntry.setDate(new Date(date));
//        newTextEntry.setText(isSolved != 0);
//
//        return newTextEntry;
//    }
}
