package de.jackhammer.stats;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 22:39
 * To change this template use File | Settings | File Templates.
 */
public class Teams {

    public String  name      = "";
    public double  time      = -1;
    public int     kills     = -1;
    public int     headshots = -1;
    public int     shots     = -1;
    public int     hits      = -1;

    protected static Teams createTeam(final JSONObject jsonObject, final String identifier ) {
        final Teams objTeam = new Teams();

        try {
            final JSONObject jsonTeam = jsonObject.getJSONObject(identifier);

            objTeam.name      = jsonTeam.getString("name");
            objTeam.time      = jsonTeam.getDouble("time");
            objTeam.kills     = jsonTeam.getInt("kills");
            objTeam.headshots = jsonTeam.getInt("headshots");
            objTeam.shots     = jsonTeam.getInt("shots");
            objTeam.hits      = jsonTeam.getInt("hits");

        }catch(JSONException gay){
            final String error = "Parse json object teams crashed.";
            Log.e(error, error, gay);
        }

         return objTeam;
    }
}
