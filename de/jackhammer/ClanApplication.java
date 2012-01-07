package de.jackhammer;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public abstract class ClanApplication {

    public static Context appContext;
    public static boolean isDeviceOnline = false;

    public static void init(Context applicationContext){
        ClanApplication.appContext = applicationContext;

        ConnectivityManager connectivityManager = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        isDeviceOnline = connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();

    }



}
