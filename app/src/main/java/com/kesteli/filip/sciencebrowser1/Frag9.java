package com.kesteli.filip.sciencebrowser1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
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
public class Frag9 extends Fragment {

    private WebView webView;

    public Frag9() {
        // Required empty public constructor
    }


    private ClanciHelperPOJO clanciHelperPOJO = new ClanciHelperPOJO();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag9, container, false);

        initWidgets(view);
        setupWebView();

        return view;
    }

    private void initWidgets(View view) {
        webView = (WebView) view.findViewById(R.id.webView);
    }

    private void setupWebView() {
        webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(ClanciHelperPOJO.getWebStranicePREFERENCES(), Context.MODE_PRIVATE);
        String restoredTextZnanost = sharedPreferences.getString(ClanciHelperPOJO.getWebStranicePREFERENCES(), null);
        if (restoredTextZnanost.equals(ClanciHelperPOJO.getFizika_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_fizika()[8]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getKemija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_kemija()[8]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getMatematika_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_matematika()[8]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getTehnika_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_tehnika()[8]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getMedicina_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_medicina()[8]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getBiologija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_biologija()[8]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getAstronomija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_astronomija()[8]);
        } else if (restoredTextZnanost.equals(ClanciHelperPOJO.getGeologija_clanci())) {
            webView.loadUrl(clanciHelperPOJO.getClanci_geologija()[8]);
        }
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




