//package edu.mctc.lisa.kindling;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by lisa on 11/20/15.
// */
//
//public class EntryLoader {
//    public List<Entry> mEntries;
//    public boolean isBusy;
//    public int CurrentPageValue;
//    public boolean CanLoadMoreItems;
//
//    public EntryLoader()
//    {
//        mEntries = new List<Entry>();
//    }
//
//    public void LoadMoreItems(int itemsPerPage)
//    {
//        isBusy = true;
//        for (int i = CurrentPageValue; i < CurrentPageValue + itemsPerPage; i++)
//        {
//            mEntries.add(new TextEntry("test") {
//            });
//        }
//        // normally you'd check to see if the number of items returned is less than
//        // the number requested, i.e. you've run out, and then set this accordinly.
//        CanLoadMoreItems = true;
//        CurrentPageValue = mEntries.size();
//        isBusy = false;
//    }
//}
