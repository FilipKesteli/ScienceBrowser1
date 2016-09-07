package com.kesteli.filip.sciencebrowser1;

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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    private WebView webView;
    private FloatingActionButton FABhistory;
    private FloatingActionButton FABfavorite;
    private FloatingActionButton FABeureka;

    public Frag1() {
        // Required empty public constructor
    }


    private ClanciHelperPOJO clanciHelperPOJO = new ClanciHelperPOJO();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);

        initWidgets(view);
        setupWebView();
        setupListeners();

        return view;
    }


    private void initWidgets(View view) {
        webView = (WebView) view.findViewById(R.id.webView);
        FABhistory = (FloatingActionButton) view.findViewById(R.id.FABhistory);
        FABfavorite = (FloatingActionButton) view.findViewById(R.id.FABfavorite);
        FABeureka = (FloatingActionButton) view.findViewById(R.id.FABeureka);
    }

    private void setupWebView() {
        webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(ClanciHelperPOJO.getWebStranicePREFERENCES(), Context.MODE_PRIVATE);
        String restoredTextZnanost = sharedPreferences.getString(ClanciHelperPOJO.getWebStranicePREFERENCES(), null);
        if (restoredTextZnanost.equals(ClanciHelperPOJO.getFizika_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_fizika()[0]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getKemija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_kemija()[0]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getMatematika_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_matematika()[0]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getTehnika_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_tehnika()[0]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getMedicina_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_medicina()[0]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getBiologija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_biologija()[0]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getAstronomija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_astronomija()[0]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getGeologija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_geologija()[0]);
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

    private String mTitle = "";
    private String mUrl = "";

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
//            Toast.makeText(getContext(), mUrl, Toast.LENGTH_SHORT).show();
        }
    }
}




