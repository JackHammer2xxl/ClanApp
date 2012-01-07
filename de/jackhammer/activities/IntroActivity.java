package de.jackhammer.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.VideoView;
import de.jackhammer.ClanApplication;
import de.jackhammer.R;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 26.11.11
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
public class IntroActivity extends Activity implements MediaPlayer.OnCompletionListener {

    private VideoView videoViewIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        ClanApplication.init(getApplicationContext());

        videoViewIntro = (VideoView) this.findViewById(R.id.VideoViewIntro);
        Uri videoUri = Uri.parse("android.resource://de.jackhammer/" + + R.raw.intro );
        videoViewIntro.setVideoURI(videoUri);
        videoViewIntro.start();
        videoViewIntro.seekTo(500);

        videoViewIntro.setOnCompletionListener(this);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        final Intent homeScreenIntent = new Intent(getApplicationContext(), HomeScreenActivity.class );
        homeScreenIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
        startActivity(homeScreenIntent );
    }

}
