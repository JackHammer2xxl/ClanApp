package de.jackhammer.stats;

import android.os.Handler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import de.jackhammer.members.ClanMember;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 27.11.11
 * Time: 22:29
 * To change this template use File | Settings | File Templates.
 */
public class IJavaScriptClient {

    private Handler handler;
    private WebView webView;
    private ClanMember member;

    public IJavaScriptClient(Handler handler, WebView webView, ClanMember member) {
        this.handler = handler;
        this.webView = webView;
        this.member = member;
    }

    public void clickOnAndroid() {
        handler.post(new Runnable() {
            public void run() {
                webView.loadUrl("javascript:player.updatePlayer()");
            }
        });

    }
}



