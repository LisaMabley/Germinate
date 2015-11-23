package edu.mctc.lisa.kindling.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

import edu.mctc.lisa.kindling.TextEntry;

/**
 * Created by lisa on 11/19/15.
 * Adapted from Big Nerd Ranch Guide to Android Programming, 2nd Edition
 */

public class EntryCursorWrapper extends CursorWrapper {

    public EntryCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public TextEntry getEntry() {
        String uuidString = getString(getColumnIndex(EntryDbSchema.EntryTable.Columns.UUID));
        long date = getLong(getColumnIndex(EntryDbSchema.EntryTable.Columns.DATE));
        String text = getString(getColumnIndex(EntryDbSchema.EntryTable.Columns.TEXT));

        TextEntry newTextEntry = new TextEntry(UUID.fromString(uuidString));
        newTextEntry.setDate(new Date(date));
        newTextEntry.setText(text);

        return newTextEntry;
    }

//    public ImageEntry getImageEntry() {
//        String uuidString = getString(getColumnIndex(EntryDbSchema.EntryTable.Columns.UUID));
//        long date = getLong(getColumnIndex(EntryDbSchema.EntryTable.Columns.DATE));
//        String text = getString(getColumnIndex(EntryDbSchema.EntryTable.Columns.TEXT));
//
//        TextEntry newImageEntry = new ImageEntry(UUID.fromString(uuidString));
//        newImageEntry.setDate(new Date(date));
//
//        return newImageEntry;
//    }
}
