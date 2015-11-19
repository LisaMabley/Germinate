package edu.mctc.lisa.kindling;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by lisa on 11/12/15.
 */

public class AddTextDialogFrag extends DialogFragment {

    private static final String TAG = "GERM.addentrydialogfrag";

    static AddTextDialogFrag newInstance() {
        AddTextDialogFrag f = new AddTextDialogFrag();
//        Bundle args = new Bundle();
//        args.putInt("num", num);
//        f.setArguments(args);
//
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_add_text, container, false);

        Dialog af = getDialog();
        af.setTitle(R.string.dialog_title_add_text);
        af.setCancelable(true);

        Button cancelButton = (Button) v.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Cancel clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button saveButton = (Button) v.findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity(), "save clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
