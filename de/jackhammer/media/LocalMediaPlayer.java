package de.jackhammer.media;

import android.media.MediaPlayer;
import de.jackhammer.ClanApplication;
import de.jackhammer.R;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 26.11.11
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */
public final class LocalMediaPlayer {

    private static MediaPlayer player;
    private LocalMediaPlayer() {}


    public static void playDarkTheme(){
        player = MediaPlayer.create(ClanApplication.appContext, R.raw.darktheme );
        player.start();
    }

    public static void playMainTheme(){
        player = MediaPlayer.create(ClanApplication.appContext, R.raw.maintheme );
        player.start();

    }

}
