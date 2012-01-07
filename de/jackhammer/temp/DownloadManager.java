package de.jackhammer.temp;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class DownloadManager {


    private static String root = "";

    public static void downloadFile(String fileName) {
        try{
            URL u = new URL("http://www.path.to/a.mp4?video");
            HttpURLConnection c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setDoOutput(true);
            c.connect();
            FileOutputStream f = new FileOutputStream(new File(root,"Video.mp4"));


            InputStream in = c.getInputStream();

            byte[] buffer = new byte[1024];
            int len1 = 0;
            while ( (len1 = in.read(buffer)) > 0 ) {
                    f.write(buffer,0, len1);
            }

            f.close();
        }catch(Exception gay){
            Log.e("Error in download manager by file" + fileName, "Error in download manager by file " + fileName, gay );
        }
    }
}
