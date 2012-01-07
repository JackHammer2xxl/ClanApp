package de.jackhammer.dataloader;

import android.util.Log;
import de.jackhammer.constants.Const;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 22:01
 * To change this template use File | Settings | File Templates.
 */
public final class DataLoader {


    public static JSONObject loadDataFromMember(String memberName) {
        JSONObject json = null;
        try {

            final String memberUrl = Const.getJsonUrl(memberName );
            Log.i("Member json URL ",memberUrl );
            final URL url = new URL(memberUrl);
            final URLConnection connection = url.openConnection();

            String line;
            final StringBuilder builder = new StringBuilder();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            final String response   = builder.toString();
            final String replace = response.replace("var bf3CurrInfo=", String.format("{\"%s\":" ,memberName) );
            final String jsonString = replace.replace(';', '}' );

//            System.out.println("JSONSTRING: \r\n\r\n "+jsonString +" \r\n\r\n");

//            Log.i("Json string: ", jsonString );

            json = new JSONObject(jsonString);

        } catch (Exception gay) {
            Log.e("JSON error","JSON error", gay);
        }

        return json;
    }

}
