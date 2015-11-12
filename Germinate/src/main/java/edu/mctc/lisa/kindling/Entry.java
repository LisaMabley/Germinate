package edu.mctc.lisa.kindling;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by lisa on 11/12/15.
 */

public class Entry {

    protected UUID mId;
    protected Date mEntryDate;
    protected String mText;
    protected ArrayList<String> mTags;

    // Constructor
    public Entry(String text) {
        mId = UUID.randomUUID();
        mEntryDate = new Date();
        mText = text;
    }
}
