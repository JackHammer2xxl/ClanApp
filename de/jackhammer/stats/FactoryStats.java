package de.jackhammer.stats;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import de.jackhammer.ClanApplication;
import de.jackhammer.dataloader.DataLoader;
import de.jackhammer.members.ClanMember;
import de.jackhammer.stats.Rank;
import de.jackhammer.stats.Statistic;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */
public abstract class FactoryStats {



    public static Statistic createMemberStatsFrom(final ClanMember member ){

        final String memberName = member.name;



        System.out.println("load stats from " + memberName );

        final Statistic memberStats = new Statistic();

        final JSONObject rawData = DataLoader.loadDataFromMember(memberName);
        try {


            final JSONObject memberData = rawData.getJSONObject(memberName);
            memberStats.initStatisticWith(memberData, member);


            final JSONObject stats = memberData.getJSONObject("stats");
            memberStats.loadUpdateDate(stats );

            final Rank rank      = Rank.createRank(stats);
            memberStats.rank = rank;

            final Scores scores    = Scores.createScores(stats.getJSONObject("scores"));
            memberStats.scores = scores;

            final Global global    = Global.createGlobal(stats.getJSONObject("global"));
            memberStats.global = global;

            final Teams teamUS     = Teams.createTeam(stats.getJSONObject("teams"), "US");
            memberStats.teamUS = teamUS;

            final Teams teamRU     = Teams.createTeam(stats.getJSONObject("teams"), "RU");
            memberStats.teamRU = teamRU;

            for(GameModes mode : GameModes.values() ){
                final Games games = Games.createGames(stats.getJSONObject("gamemodes"), mode);
                memberStats.games.put(mode, games );
            }

        } catch (JSONException gay) {
            final String tag = String.format("JSONException by parse raw data from member %s", memberName);
            Log.e(tag, tag , gay );
        }


        return memberStats;
    }

}
