package com.kesteli.filip.sciencebrowser1.education;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kesteli.filip.sciencebrowser1.EurekaDialog;
import com.kesteli.filip.sciencebrowser1.FavoriteDialog;
import com.kesteli.filip.sciencebrowser1.HistoryDialog;
import com.kesteli.filip.sciencebrowser1.R;

public class EduFrag1 extends Fragment {
    private FloatingActionButton FABhistory;
    private FloatingActionButton FABfavorite;
    private FloatingActionButton FABeureka;

    public EduFrag1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edu_frag1, container, false);

        initWidgets(view);
        setupListeners();

        return view;
    }


    private void initWidgets(View view) {
        FABhistory = (FloatingActionButton) view.findViewById(R.id.FABhistoryEdu);
        FABfavorite = (FloatingActionButton) view.findViewById(R.id.FABfavoriteEdu);
        FABeureka = (FloatingActionButton) view.findViewById(R.id.FABeurekaEdu);
    }

    private void setupListeners() {
        FABhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HistoryDialog historyDialog = new HistoryDialog();
                historyDialog.show(getActivity().getFragmentManager(), null);
            }
        });
        FABfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoriteDialog favoriteDialog = new FavoriteDialog();
                favoriteDialog.show(getActivity().getFragmentManager(), null);
            }
        });
        FABeureka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EurekaDialog eurekaDialog = new EurekaDialog();
                eurekaDialog.show(getActivity().getFragmentManager(), null);
            }
        });
    }
}
