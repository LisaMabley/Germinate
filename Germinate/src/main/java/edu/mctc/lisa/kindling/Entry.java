package edu.mctc.lisa.kindling;

import java.util.Date;
import java.util.UUID;

/**
 * Created by lisa on 11/12/15.
 */

public abstract class Entry {

    protected UUID mId;
    protected Date mEntryDate;
    protected String mText;
//    protected Image mImage;
//    protected ArrayList<String> mTags;

    public static final int ENTRYTYPE_TEXT = 0;
    public static final int ENTRYTYPE_IMAGE = 1;

    // Constructors
    public Entry() {
        mId = UUID.randomUUID();
        mEntryDate = new Date();
    }

    public Entry(UUID id) {
        mId = id;
    }

    // Getters
    public String getText() {
        return mText;
    }

    public UUID getId() {
        return mId;
    }

    public Date getDate() {
        return mEntryDate;
    }

    // Setters
    public void setId(UUID id) {
        mId = id;
    }

    public void setDate(Date entryDate) {
        mEntryDate = entryDate;
    }

    public void setText(String text) {
        mText = text;
    }
}
