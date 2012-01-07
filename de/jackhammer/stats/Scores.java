package de.jackhammer.stats;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
public class Scores {


      public int score      = -1;
      public int award      = -1;
      public int assault    = -1;
      public int bonus      = -1;
      public int engineer   = -1;
      public int general    = -1;
      public int objective  = -1;
      public int recon      = -1;
      public int squad      = -1;
      public int support    = -1;
      public int team       = -1;
      public int unlock     = -1;
      public int vehicleaa  = -1;
      public int vehicleah  = -1;
      public int vehicleall = -1;
      public int vehicleifv = -1;
      public int vehiclejet = -1;
      public int vehiclembt = -1;
      public int vehiclesh  = -1;


    protected static Scores createScores(final JSONObject jsonScore) {
        final Scores objScore = new Scores();

        try {

            objScore.score       = jsonScore.getInt("score");
            objScore.award       = jsonScore.getInt("award");
            objScore.assault     = jsonScore.getInt("assault");
            objScore.bonus       = jsonScore.getInt("bonus");
            objScore.engineer    = jsonScore.getInt("engineer");
            objScore.general     = jsonScore.getInt("general");
            objScore.objective   = jsonScore.getInt("objective");
            objScore.recon       = jsonScore.getInt("recon");
            objScore.squad       = jsonScore.getInt("squad");
            objScore.support     = jsonScore.getInt("support");
            objScore.team        = jsonScore.getInt("team");
            objScore.unlock      = jsonScore.getInt("unlock");
            objScore.vehicleaa   = jsonScore.getInt("vehicleaa");
            objScore.vehicleah   = jsonScore.getInt("vehicleah");
            objScore.vehicleall  = jsonScore.getInt("vehicleall");
            objScore.vehicleifv  = jsonScore.getInt("vehicleifv");
            objScore.vehiclejet  = jsonScore.getInt("vehiclejet");
            objScore.vehiclembt  = jsonScore.getInt("vehiclembt");
            objScore.vehiclesh   = jsonScore.getInt("vehiclesh");


        } catch (JSONException gay) {
            final String error = "parse score crashed JSON error";
            Log.e(error, error, gay);
        }

        return objScore;

    }
}
