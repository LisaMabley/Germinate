package edu.mctc.lisa.kindling;

import android.util.Log;

import java.util.ArrayList;

/*
 * Created by lisa on 11/20/15.
 */

public class EntryLoader {
    public static ArrayList<Entry> mEntries;
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

                ImageEntry newImageEntry = new ImageEntry();
//                EntryManager.sEntryManager.addEntry(newImageEntry);
                mEntries.add(newImageEntry);

            } else if (i%3 == 0) {
                TextEntry newTextEntry = new TextEntry("’Twas brillig, and the slithy toves " +
                        "Did gyre and gimble in the wabe:");
                EntryManager.sEntryManager.addEntry(newTextEntry);
                mEntries.add(newTextEntry);
                Log.d(TAG, newTextEntry.toString());

            } else {
                TextEntry newTextEntry = new TextEntry("Never gonna give you up, never gonna let you down");
                EntryManager.sEntryManager.addEntry(newTextEntry);
                mEntries.add(newTextEntry);
                Log.d(TAG, newTextEntry.toString());
            }
        }

        // normally you'd check to see if the number of items returned is less than
        // the number requested, i.e. you've run out, and then set this accordingly.
        CanLoadMoreItems = true;
        CurrentPageValue = 14;
//        CurrentPageValue = mEntries.size();
        isBusy = false;
    }
}
