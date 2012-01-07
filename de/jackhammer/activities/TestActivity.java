package de.jackhammer.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import de.jackhammer.R;
import de.jackhammer.dao.DataBaseHelper;
import de.jackhammer.members.ClanMember;
import de.jackhammer.stats.FactoryStats;
import de.jackhammer.stats.Statistic;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 26.11.11
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public class TestActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        DataBaseHelper dbHelper = new DataBaseHelper(this );
        dbHelper.exportDatabaseInDevice();


    }


     /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        DataBaseHelper dbHelper = new DataBaseHelper(this );
        dbHelper.createDataBase();
        dbHelper.openDataBase();

        for(ClanMember member : dbHelper.loadMember() ){
            final Statistic memberStats = FactoryStats.createMemberStatsFrom(member);
            member.setStats(memberStats );
            dbHelper.writeMemberStatsInDatabase(member );
            System.out.println("----- next -----");
        }





    }

      */


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        DataBaseHelper dbHelper = new DataBaseHelper(this );
        dbHelper.createDataBase();
        dbHelper.openDataBase();


        ClanMember jack = dbHelper.loadMemberByName("JackHammer2xxl2");

        final Statistic memberStats = FactoryStats.createMemberStatsFrom(jack);
        jack.setStats(memberStats );

        dbHelper.writeMemberStatsInDatabase(jack );


    }

    */

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main );


        System.out.println("Start");
        DataBaseHelper dbHelper = new DataBaseHelper(this );


            dbHelper.createDataBase();
            dbHelper.openDataBase();

//            dbHelper.showMember();
//            dbHelper.deleteByID(18);

            // System.out.println("load by name Jack");
//            ClanMember jack = dbHelper.loadMemberByName("JackHammer"); // jackhammer.
            ClanMember jack = dbHelper.loadMemberByID(1 ); // jackhammer.

            //System.out.println("load member done ");
            if(jack != null)
                System.out.println(jack );
            else
                System.out.println("stmt returns null");
//            System.out.println("now load by id 10");
//            final ClanMember clanMember = dbHelper.loadMemberByID(10);
//            System.out.println(clanMember);



    }

    */




}
