package edu.mctc.lisa.kindling;

/*
 * Created by lisa on 11/16/15.
 */

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import java.util.UUID;

public class ImageEntry extends Entry {

    protected Bitmap mImage;
    protected int mResourceId;
    protected ImageView mImageView;
    private static int COUNTER = 0;

    private static final String TAG = "GERM.imageentry";

    public ImageEntry () {
        super();

        Log.d(TAG, "new imageentry");

        Integer[] thumbIds = {
                R.drawable.sample_01, R.drawable.sample_02,
                R.drawable.sample_03, R.drawable.sample_04,
                R.drawable.sample_05, R.drawable.sample_06,
                R.drawable.sample_07
        };
        mResourceId = thumbIds[COUNTER];
        Log.d(TAG, "resource id: " + mResourceId);

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
//
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        ImageView imageView;
//
//        if (convertView == null) {
//            // if it's not recycled, initialize some attributes
//
// imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(180, 180));
//            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageView.setPadding(8, 8, 8, 8);
//
//        } else {
//            imageView = (ImageView) convertView;
//        }
//
//        imageView.setImageResource(mThumbIds[position]);
//        return imageView;
//    }
}
