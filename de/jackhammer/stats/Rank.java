package de.jackhammer.stats;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public class Rank {

    public int nr = -1;
    public String name = "";
    public int score = -1;
    public String image = "";
    public String nextRankName = "";
    public String nextRankImage = "";
    public int left = -1;


    protected static Rank createRank(JSONObject jsonRank) {
        final Rank rank = new Rank();

        try{
            final JSONObject objRank = jsonRank.getJSONObject("rank");
            rank.nr         = objRank.getInt("nr");
            rank.score      = objRank.getInt("score");
            rank.name       = objRank.getString("name");
            rank.image      = objRank.getString("image");

            final JSONArray objArrayNextRank = jsonRank.getJSONArray("nextranks");
            if(objArrayNextRank.length() > 0){
                final JSONObject objNextRank = objArrayNextRank.getJSONObject(0);
                rank.nextRankName = objNextRank.getString("name");
                rank.nextRankImage = objNextRank.getString("image");
                rank.left         = objNextRank.getInt("left");
            }

        }catch(JSONException gay){
            final String error = "Read stats rank crashed";
            Log.e(error, error, gay );
        }


        return rank;
    }


}
