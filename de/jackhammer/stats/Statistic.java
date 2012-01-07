package de.jackhammer.stats;

import android.util.Log;
import de.jackhammer.members.ClanMember;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 22:14
 * To change this template use File | Settings | File Templates.
 */
public class Statistic {


    public String url         = "null";
    public String platform    = "null";


    public Rank   rank   = new Rank();
    public Scores scores = new Scores();
    public Teams  teamUS = new Teams();
    public Teams  teamRU = new Teams();
    public Map<GameModes, Games>  games  = new TreeMap<GameModes, Games>();
    public Global global = new Global();


    /*
    Compare elements time stamp for diagram layout from statistic.
    */

    // TODO create private member vars.
    public String init_date_insert = "null";
    public String init_date_update = "null";

    public String date_insert = "null";
    /**
     * the most important value for compare in history.
    * */
    public String date_update = "null";
    public String date_check  = "null";


    protected Statistic() {}

    protected final void initStatisticWith(final JSONObject objMember, final ClanMember member){

        try {
            this.platform         = objMember.getString("plat");
            this.url              = objMember.getString("plat");
            member.battlelog      = objMember.getString("battlelog");
            this.init_date_insert = objMember.getString("date_insert");
            this.init_date_update = objMember.getString("date_update");

        } catch (JSONException gay ) {
            final String error = String.format("json parse crashed by init statistic object");
            Log.e(error, error, gay );
        }
    }

    protected void loadUpdateDate(JSONObject objStats) {
        try {
            this.date_insert = objStats.getString("date_insert");
            this.date_update = objStats.getString("date_update");
            this.date_check  = objStats.getString("date_check");

        } catch (JSONException gay ) {
            final String error = String.format("json parse crashed by init statistic object");
            Log.e(error, error, gay );
        }
    }

    public long getStatisticUpdateTimeInMillis() {

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss.S");

        final String raw = date_update;//"2011-11-26T01:19:15.331Z";
        final String[] tailed = raw.replace("Z", "").split("T");


        final SimpleDateFormat stringParser = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss.S");
        Date parse = null;
        try {
            parse = stringParser.parse(String.format("%s %s", tailed[0], tailed[1]));
        } catch (ParseException e) {
            System.out.println("Cant read date string");
        }


        return (parse != null) ? parse.getTime() : -1;
    }
}
