package com.kesteli.filip.sciencebrowser1;

/**
 * Created by Filip on 7.9.2016..
 */
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.kesteli.filip.sciencebrowser1.bazapodataka.Stranica;

/**
 * Created by programer on 16.5.2016..
 */
public class FavoriteDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIconAttribute(android.R.attr.alertDialogIcon);
        builder.setTitle("FAVORITES");
        builder.setMessage("Do you really want to put this page at your FAVORITES?");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                getActivity().finish();

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(ClanciHelperPOJO.getSitePREFERENCES(), Context.MODE_PRIVATE);
                String site = sharedPreferences.getString(ClanciHelperPOJO.getSitePREFERENCES(), null);

                DatabaseHandler databaseHandler = new DatabaseHandler(getActivity());
                Log.d("Insert: ", "Inserting ..");
                databaseHandler.addStranica(new Stranica(site, 0, 1, 0));
                Stranica str = databaseHandler.getStranicaPremaSite(site);
                String log3 = "Id: " + str.get_id()
                        + " ,Site: " + str.get_site()
                        + " ,History: "
                        + str.get_history()
                        + " ,Favorite: " + str.get_favorite()
                        + " ,Eureka: " + str.get_eureka();
                // Writing Contacts to log
                Log.d("LALI: ", log3);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return builder.create();
    }
}
