package edu.mctc.lisa.kindling;

import android.util.Log;

import java.util.ArrayList;

/*
 * Created by lisa on 11/20/15.
 */

public class EntryLoader {
    public ArrayList<Entry> mEntries;
    public boolean isBusy;
    public int CurrentPageValue;
    public boolean CanLoadMoreItems;

    private static final String TAG = "GERM.entryloader";

    public EntryLoader()
    {
        mEntries = new ArrayList<Entry>();
    }

    public void loadMoreItems(int itemsPerPage) {

        isBusy = true;
        for (int i = CurrentPageValue; i < CurrentPageValue + itemsPerPage; i++) {

            if (i%2 == 0) {
                Log.d(TAG, "divisible by two");
                mEntries.add(new TextEntry("’Twas brillig, and the slithy toves" +
                        "Did gyre and gimble in the wabe:"));

            } else if (i%3 == 0) {
                Log.d(TAG, "divisible by three");
                mEntries.add(new ImageEntry());

            } else {
                mEntries.add(new TextEntry("Never gonna give you up, never gonna let you down"));
            }

        }

        // normally you'd check to see if the number of items returned is less than
        // the number requested, i.e. you've run out, and then set this accordingly.
        CanLoadMoreItems = true;
        CurrentPageValue = mEntries.size();
        isBusy = false;
    }
}
