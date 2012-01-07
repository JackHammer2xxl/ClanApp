package de.jackhammer.stats;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 22:34
 * To change this template use File | Settings | File Templates.
 */
public class Games {

    public GameModes gameMode;
    public String name = "";
    public int losses  = -1;
    public int wins    = -1;

    protected static Games createGames(final JSONObject jsonGames, final GameModes mode) {
        final Games objGames = new Games();

        try{

            final JSONObject game = jsonGames.getJSONObject(mode.value);

            objGames.gameMode = mode;
            objGames.name   =  game.getString("name");
            objGames.losses =  game.getInt("losses");
            objGames.wins   =  game.getInt("wins");


        }catch(JSONException gay ){
            final String error = "parse game stats crashed.";
            Log.e(error, error, gay );
        }


        return objGames;
    }
}
