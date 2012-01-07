package de.jackhammer.stats;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
public class Global {

      public int     kills                 = -1;
      public int     deaths                = -1;
      public int     wins                  = -1;
      public int     losses                = -1;
      public int     shots                 = -1;
      public int     hits                  = -1;
      public int     headshots             = -1;
      public double  longesths             = -1;
      public int     time                  = -1;
      public double  vehicletime           = -1;
      public int     vehiclekills          = -1;
      public int     revives               = -1;
      public int     killassists           = -1;
      public int     resupplies            = -1;
      public double  heals                 = -1;
      public double  repairs               = -1;
      public int     rounds                = -1;
      public double  elo                   = -1;
      public int     elo_games             = -1;
      public int     killstreakbonus       = -1;
      public double  vehicledestroyassist  = -1;
      public int     vehicledestroyed      = -1;
      public int     dogtags               = -1;
      public int     avengerkills          = -1;
      public int     saviorkills           = -1;
      public int     damagaassists         = -1;
      public int     suppression           = -1;



    protected static Global createGlobal(final JSONObject jsonGlobal) {
        final Global objGlobal = new Global();

        try {
            objGlobal.kills                = jsonGlobal.getInt("kills");
            objGlobal.deaths               = jsonGlobal.getInt("deaths");
            objGlobal.wins                 = jsonGlobal.getInt("wins");
            objGlobal.losses               = jsonGlobal.getInt("losses");
            objGlobal.shots                = jsonGlobal.getInt("shots");
            objGlobal.hits                 = jsonGlobal.getInt("hits");
            objGlobal.headshots            = jsonGlobal.getInt("headshots");
            objGlobal.longesths            = jsonGlobal.getDouble("longesths");
            objGlobal.time                 = jsonGlobal.getInt("time");
            objGlobal.vehicletime          = jsonGlobal.getDouble("vehicletime");
            objGlobal.vehiclekills         = jsonGlobal.getInt("vehiclekills");
            objGlobal.revives              = jsonGlobal.getInt("revives");
            objGlobal.killassists          = jsonGlobal.getInt("killassists");
            objGlobal.resupplies           = jsonGlobal.getInt("resupplies");
            objGlobal.heals                = jsonGlobal.getDouble("heals");
            objGlobal.repairs              = jsonGlobal.getDouble("repairs");
            objGlobal.rounds               = jsonGlobal.getInt("rounds");
            objGlobal.elo                  = jsonGlobal.getDouble("elo");
            objGlobal.elo_games            = jsonGlobal.getInt("elo_games");
            objGlobal.killstreakbonus      = jsonGlobal.getInt("killstreakbonus");
            objGlobal.vehicledestroyassist = jsonGlobal.getDouble("vehicledestroyassist");
            objGlobal.vehicledestroyed     = jsonGlobal.getInt("vehicledestroyed");
            objGlobal.dogtags              = jsonGlobal.getInt("dogtags");
            objGlobal.avengerkills         = jsonGlobal.getInt("avengerkills");
            objGlobal.saviorkills          = jsonGlobal.getInt("saviorkills");
            objGlobal.damagaassists        = jsonGlobal.getInt("damagaassists");
            objGlobal.suppression          = jsonGlobal.getInt("suppression");

        }catch(JSONException gay){
            final String error = "Parse global from json array crashed";
            Log.e(error, error, gay);
        }

        return objGlobal;
    }
}
