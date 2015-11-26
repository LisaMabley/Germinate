package edu.mctc.lisa.kindling;

/*
 * Created by lisa on 11/16/15.
 */

import android.graphics.Bitmap;
import android.util.Log;

import java.util.UUID;

public class ImageEntry extends Entry {

    protected Bitmap mImage;
    public int mResourceId;
    private static int COUNTER = 0;

    private static final String TAG = "GERM.imageentry";

    public ImageEntry () {
        super();

        Integer[] thumbIds = {
                R.drawable.sample_01, R.drawable.sample_02,
                R.drawable.sample_03, R.drawable.sample_04,
                R.drawable.sample_05, R.drawable.sample_06,
                R.drawable.sample_07
        };
        mResourceId = thumbIds[COUNTER];

        if (COUNTER == 6) {
            COUNTER = 0;
        } else {
            COUNTER ++;
        }
        Log.d(TAG, "counter: " + COUNTER);

//        EntryManager.sEntryManager.addEntry(this);
    }

    public ImageEntry (UUID id) {
        super(id);
    }
}
