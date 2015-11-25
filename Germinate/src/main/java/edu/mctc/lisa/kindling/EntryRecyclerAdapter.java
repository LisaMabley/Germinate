package edu.mctc.lisa.kindling;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/*
 * Created by lisa on 11/19/15.
 * Adapted from and influenced by: http://blog.wislon.io/posts/2015/03/05/xamarin-android-staggered-grid-layout/
 */

public class EntryRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private EntryLoader mEntryLoader;
    public static final int ENTRYTYPE_TEXT = 0;
    public static final int ENTRYTYPE_IMAGE = 1;

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
            case ENTRYTYPE_TEXT:
                View textView = layoutInflater.inflate(R.layout.fragment_text_for_grid, parent, false);
                return new TextViewHolder(textView);

            case ENTRYTYPE_IMAGE:
                View imageView = layoutInflater.inflate(R.layout.fragment_image_for_grid, parent, false);
                return new ImageViewHolder(imageView);

            default:
                // May cause crash if there's a type in your list you forgot about...
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Entry gridItem = mEntryLoader.mEntries.get(position);

        if (gridItem.getClass() == TextEntry.class) {
            ((TextViewHolder) holder).setPreviewText(gridItem.mText);
        }
    }

    public void setEntries(List<Entry> entries) {
        // There will be some stuff in here
    }

    public int getItemViewType(int position) {
        //Implement your logic here
        Entry entry = mEntryLoader.mEntries.get(position);

        if (entry.getClass().getName().equals(edu.mctc.lisa.kindling.TextEntry.class.getName())) {
            return ENTRYTYPE_TEXT;

        } else if (entry.getClass().getName().equals(ImageEntry.class.getName())) {
            return ENTRYTYPE_IMAGE;

        } else {
            // This should not happen
            return 0;
        }
    }
}
