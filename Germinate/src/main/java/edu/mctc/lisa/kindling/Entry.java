package edu.mctc.lisa.kindling;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/*
 * Created by lisa on 11/12/15.
 */

public abstract class Entry {

    protected UUID mId;
    protected Date mEntryDate;
    protected String mText;
    protected ArrayList<String> mTags;

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
