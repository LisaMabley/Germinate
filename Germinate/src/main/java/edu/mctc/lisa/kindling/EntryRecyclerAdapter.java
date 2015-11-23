//package edu.mctc.lisa.kindling;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.view.ViewGroup;
//
///**
// * Created by lisa on 11/19/15.
// * Adapted from and influenced by: http://blog.wislon.io/posts/2015/03/05/xamarin-android-staggered-grid-layout/
// */
//
//public class EntryRecyclerAdapter extends RecyclerView.Adapter {
//
//    private EntryLoader mEntryLoader;
//
//        public EntryRecyclerAdapter(EntryLoader eLoader) {
//            mEntryLoader = eLoader;
//        }
//
//    @Override
//    public int ItemCount() {
//        return this.mEntryLoader.mEntries.size();
//    }
//
//    @Override
//    public RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void OnBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int GetItemViewType(int position) {
//        if (mEntryLoader.mEntries[position].getType() == typeof(Entry.ENTRYTYPE_TEXT)) {
//            return Entry.ENTRYTYPE_TEXT;
//
//        } else if ()
//        return Entry.ENTRYTYPE_IMAGE;
//    }
//
//}
//
//public class EntryViewHolder extends RecyclerView.ViewHolder {
////    TextView label;
////    TextView dateTime;
//
//    public EntryViewHolder(View itemView) {
//        super(itemView);
////        label = (TextView) itemView.findViewById(R.id.txt_label_item);
////        dateTime = (TextView) itemView.findViewById(R.id.txt_date_time);
//    }
//}
