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
public class WebFragment extends Fragment {

    private WebView webView;

    public WebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //TODO: Staviti log-ove na onCreateView od fragmenta i activityja da vidim kad se pozivaju
        Log.e("WebFragment", "debagiranje");

        setupSharedPreferences();

        View view = inflater.inflate(R.layout.fragment_web, container, false);
        initWidgets(view);
        setupWebView();

        return view;
    }

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static final String MyPREFERENCES = "MyPrefs";
    private StringBuilder webStranica;
    private ClanciHelperPOJO clanciHelperPOJO;
    private String[] clanci = {"jedan", "dva", "tri", "cetiri", "pet", "sest", "sedam", "osam", "devet", "deset"};

    private StringBuilder url = null;

    public StringBuilder getUrl() {
        return url;
    }

    public void setUrl(StringBuilder url) {
        this.url = url;
    }

    private String restoredTextZnanost;
    private String urlClanak;

    private void setupSharedPreferences() {
        sharedPreferences = getActivity().getSharedPreferences(ClanciHelperPOJO.getMyPREFERENCES(), Context.MODE_PRIVATE);
        restoredTextZnanost = sharedPreferences.getString(ClanciHelperPOJO.getMyPREFERENCES(), null);
        urlClanak = sharedPreferences.getString(ClanciHelperPOJO.getMyClanakPREFERENCE(), null);
        if (urlClanak != null) {
            if (restoredTextZnanost.equals(ClanciHelperPOJO.getFizika_clanci())) {
//                clanci = clanciHelperPOJO.getClanci_fizika();
//                url.append("http://www.google.com");
                Toast.makeText(getContext(), urlClanak, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "asfasčfa", Toast.LENGTH_SHORT).show();
        }
    }

    private void initWidgets(View view) {
        webView = (WebView) view.findViewById(R.id.webView);
    }

    private void setupWebView() {
        webView.setWebViewClient(new MyBrowser());

        String url = "http://www.google.com";

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(urlClanak.toString());
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




