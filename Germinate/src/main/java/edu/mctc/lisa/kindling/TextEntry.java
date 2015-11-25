package edu.mctc.lisa.kindling;

import android.util.Log;

import java.util.UUID;

/*
 * Created by lisa on 11/16/15.
 */

public class TextEntry extends Entry {

    private static final String TAG = "GERM.textentryclass";

    public TextEntry (String text) {
        super();
        Log.d(TAG, "new textentry");
        mText = text;
//        EntryManager.sEntryManager.addEntry(this);
    }

    public TextEntry (UUID id) {
        super(id);
    }
}
