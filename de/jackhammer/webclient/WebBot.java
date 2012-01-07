package de.jackhammer.webclient;

import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 06.12.11
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public class WebBot {

    private final WebSettings settings;

    public WebBot(Activity activity) {
        WebView webView = new WebView(activity);
        settings = webView.getSettings();
        settings.setJavaScriptEnabled(true );


        final JSWebClient client = new JSWebClient();

        webView.addJavascriptInterface(client, "INTERFACE");
        webView.setWebViewClient(client);


    }
}
