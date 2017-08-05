package com.kesteli.filip.sciencebrowser1.web.fragmenti;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kesteli.filip.sciencebrowser1.ClanciHelperPOJO;
import com.kesteli.filip.sciencebrowser1.EurekaDialog;
import com.kesteli.filip.sciencebrowser1.FavoriteDialog;
import com.kesteli.filip.sciencebrowser1.HistoryDialog;
import com.kesteli.filip.sciencebrowser1.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag5 extends Fragment {

    private WebView webView;
    private FloatingActionButton FABhistory;
    private FloatingActionButton FABfavorite;
    private FloatingActionButton FABeureka;

    public Frag5() {
        // Required empty public constructor
    }


    private ClanciHelperPOJO clanciHelperPOJO = new ClanciHelperPOJO();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag5, container, false);

        initWidgets(view);
        setupWebView();
        setupListeners();

        return view;
    }


    private void initWidgets(View view) {
        webView = (WebView) view.findViewById(R.id.webView);
        FABhistory = (FloatingActionButton) view.findViewById(R.id.FABhistoryEdu);
        FABfavorite = (FloatingActionButton) view.findViewById(R.id.FABfavoriteEdu);
        FABeureka = (FloatingActionButton) view.findViewById(R.id.FABeurekaEdu);
    }

    private void setupWebView() {
        webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(ClanciHelperPOJO.getWebStranicePREFERENCES(), Context.MODE_PRIVATE);
        String restoredTextZnanost = sharedPreferences.getString(ClanciHelperPOJO.getWebStranicePREFERENCES(), null);
        if (restoredTextZnanost.equals(ClanciHelperPOJO.getFizika_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_fizika()[4]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getKemija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_kemija()[4]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getMatematika_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_matematika()[4]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getTehnika_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_tehnika()[4]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getMedicina_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_medicina()[4]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getBiologija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_biologija()[4]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getAstronomija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_astronomija()[4]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getGeologija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_geologija()[4]);
        }
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

    private String mTitle = null;
    private String mUrl;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            mUrl = view.getUrl();
            mTitle = view.getTitle();
            //TODO: Povezati bazu ovdje -> Znaci uzmem current url mUrl i ako klikne na history i ok -> add stranicu u bazu
//            Toast.makeText(getContext(), mUrl, Toast.LENGTH_SHORT).show();
            Log.d("filip:", mUrl);

            //Ovo je po pretpostavci ujedno i zadnji editani sharedPreferences
            sharedPreferences = getActivity().getSharedPreferences(ClanciHelperPOJO.getSitePREFERENCES(), Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            if (mUrl != null) {
                Log.d("kkk", mUrl);
            }
            editor.putString(ClanciHelperPOJO.getSitePREFERENCES(), mUrl);
            editor.commit();
        }
    }
}


