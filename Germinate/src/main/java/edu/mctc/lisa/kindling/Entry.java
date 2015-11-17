package edu.mctc.lisa.kindling;

import android.media.Image;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by lisa on 11/12/15.
 */

public abstract class Entry {

    protected UUID mId;
    protected Date mEntryDate;
    protected String mText;
    protected Image mImage;
    protected ArrayList<String> mTags;

}
