package com.kesteli.filip.sciencebrowser1.aplikacije.history;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.kesteli.filip.sciencebrowser1.DatabaseHandler;
import com.kesteli.filip.sciencebrowser1.bazapodataka.Stranica;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 10.9.2016..
 */
public class HistoryDeleteAllDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIconAttribute(android.R.attr.alertDialogIcon);
        builder.setTitle("DELETE ALL HISTORY");
        builder.setMessage("Do you really want to ALL your HISTORY?");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DatabaseHandler databaseHandler = new DatabaseHandler(getActivity());
                List<Stranica> stranicaList = databaseHandler.getAllStranice();
                List<Stranica> stranicaListHistory = new ArrayList<Stranica>();
                for (int i = 0; i < stranicaList.size(); i++) {
                    if (stranicaList != null && stranicaList.get(i).get_history() == 1) {
                        stranicaListHistory.add(stranicaList.get(i));
                        databaseHandler.deleteStranica(stranicaList.get(i));
                    }
                }
                notifyToTarget(Activity.RESULT_OK);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                notifyToTarget(Activity.RESULT_CANCELED);
                dismiss();
            }
        });

        return builder.create();
    }

    private void notifyToTarget(int code) {
        onActivityResult(getActivity().hashCode(), code, null);
    }


}
