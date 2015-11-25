package edu.mctc.lisa.kindling;

import android.view.View;
import android.widget.TextView;

import static android.support.v7.widget.RecyclerView.ViewHolder;

/*
 * Created by lisa on 11/23/15.
 */

public class TextViewHolder extends ViewHolder {

    private TextView mPreviewText;

    public TextViewHolder(View itemView) {
        super(itemView);
        mPreviewText = (TextView) itemView.findViewById(R.id.grid_preview_text);
    }

    public void setPreviewText(String previewText) {
        mPreviewText.setText(previewText);
    }
}
