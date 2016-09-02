package com.kesteli.filip.sciencebrowser1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        initWidgets(view);
//        setupWebView();
        setupWebView();
        setupListeners();
        return view;
    }

    private void setupListeners() {

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
        webView.loadUrl(url);
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
            Toast.makeText(getContext(), mUrl, Toast.LENGTH_SHORT).show();
        }
    }
}
