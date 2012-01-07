package de.jackhammer.webclient;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 06.12.11
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
public class JSWebClient extends WebViewClient {


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        System.out.println("shouldOverrideUrlLoading ");
        System.out.println(url );

        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        System.out.println("onPageStarted");
        System.out.println(url );

        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        System.out.println("onPageFinished");
        System.out.println(url );

        super.onPageFinished(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        System.out.println("onLoadResource " );
        System.out.println(url );

        super.onLoadResource(view, url);
    }
}
