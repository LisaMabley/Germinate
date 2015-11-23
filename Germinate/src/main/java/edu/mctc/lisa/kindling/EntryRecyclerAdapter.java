package edu.mctc.lisa.kindling;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lisa on 11/19/15.
 * Adapted from and influenced by: http://blog.wislon.io/posts/2015/03/05/xamarin-android-staggered-grid-layout/
 */

public class EntryRecyclerAdapter extends RecyclerView.Adapter {

    private EntryLoader mEntryLoader;

    public EntryRecyclerAdapter(EntryLoader eLoader) {
        mEntryLoader = eLoader;
    }

    public int getItemCount() {
        return this.mEntryLoader.mEntries.size();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType)
        {
            // 0 corresponds to the value we chose to use in `GetItemViewType`
            case 0:
                View view = layoutInflater.inflate(R.layout.fragment_text_for_grid, parent, false);
                RecyclerView.ViewHolder viewHolder = new EntryViewHolder(view);
                return viewHolder;

            default:
                // May cause crash if there's a type in your list you forgot about...
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Entry gridItem = mEntryLoader.mEntries.get(position);

        switch (gridItem.getType()) {
            case Entry.ENTRYTYPE_TEXT:
                ((EntryViewHolder) holder).setPreviewText(gridItem.mText);
                break;

            case Entry.ENTRYTYPE_IMAGE:
                // Something will happen here
                break;
        }
    }

    public int getItemViewType(int position) {
//        if (mEntryLoader.mEntries[position].getType() == typeof(Entry.ENTRYTYPE_TEXT)) {
            return Entry.ENTRYTYPE_TEXT;

//        } else if ()
//        return Entry.ENTRYTYPE_IMAGE;
    }

    public void setEntries(List<Entry> entries) {
        // There will be some stuff in here

    }
}
