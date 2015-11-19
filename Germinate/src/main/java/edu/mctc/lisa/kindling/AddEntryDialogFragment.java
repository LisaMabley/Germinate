package edu.mctc.lisa.kindling;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lisa on 11/12/15.
 */

public class AddEntryDialogFragment extends DialogFragment {

    private static final String TAG = "GERM.addentrydialogfrag";

    static AddEntryDialogFragment newInstance() {
        AddEntryDialogFragment f = new AddEntryDialogFragment();
//        Bundle args = new Bundle();
//        args.putInt("num", num);
//        f.setArguments(args);
//
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Dialog af = getDialog();
        af.setTitle(R.string.dialog_title_add_text);
        af.setCancelable(true);
        return inflater.inflate(R.layout.fragment_add_text, container, false);
    }
}
