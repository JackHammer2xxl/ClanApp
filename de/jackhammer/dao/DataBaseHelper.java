package de.jackhammer.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Environment;
import android.util.Log;
import de.jackhammer.members.ClanMember;
import de.jackhammer.stats.Global;
import de.jackhammer.stats.Rank;
import de.jackhammer.stats.Scores;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 26.11.11
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/de.jackhammer/databases/";

    private static String DB_NAME = "history.sqlite";

    private SQLiteDatabase database;

    private final Context contextFroResources;


    /*delete embedded database be careful */
    private static final boolean DEBUG = false;


    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.contextFroResources = context;
    }

    /**
     * First call create for init project db.
     */
    public void createDataBase() {
        System.out.println("createDataBase()");

        if (DEBUG)
            deleteDbFileForTest();

        if (checkDatabaseExist()) {
            System.out.println("DB exists");
        } else {
            System.out.println("DB not exists");
            this.getReadableDatabase();
            copyDataBase();
        }
    }


    private boolean checkDatabaseExist() {
        System.out.println("checkDatabaseExist()");
        SQLiteDatabase initDatabase = null;
        try {
            String fullDatabasePath = DB_PATH + DB_NAME;
            initDatabase = SQLiteDatabase.openDatabase(fullDatabasePath, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
            // no existing db
        }
        if (initDatabase != null) {
            initDatabase.close();
        }
        final boolean exists = initDatabase != null;
        System.out.println("DB exists " + (exists ? "YES" : "NO"));
        return exists;
    }


    /**
     * Copy database from assets in android db target.
     * handle IOException transfer byte stream error.
     */
    private void copyDataBase() {
        System.out.println("copyDataBase()");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = contextFroResources.getAssets().open(DB_NAME);
            final String outFileName = DB_PATH + DB_NAME;
            outputStream = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.flush();

        } catch (IOException gay) {
            final String error = "copyDataBase transfer byte stream error.";
            Log.e(error, error, gay);
        } finally {
            try {
                if (outputStream != null)
                    outputStream.close();
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException gayMore) {
                final String error = "close streams error.";
                Log.e(error, error, gayMore);
            }
        }

    }


    /**
     * Call after create.
     *
     * @throws SQLException gay
     */
    public void openDataBase() throws SQLException {
        System.out.println("openDataBase()");
        //Open the database
        String databasePath = DB_PATH + DB_NAME;
        database = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);

    }

    @Override
    public synchronized void close() {

        if (database != null)
            database.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate() ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("onUpgrade");
    }

    public void showMember() {
        System.out.println("showMember()");                                                                   /*"title_raw like " + "'%Smith%'"*/
        final Cursor cursor = this.getReadableDatabase().query("member", new String[]{"id", "name", "skype", "email", "passwd"}, null, null, null, null, null);


        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            final int id = cursor.getInt(0);
            final String name = cursor.getString(1);
            final String skype = cursor.getString(2);
            final String email = cursor.getString(3);
            final String passwd = cursor.getString(4);

            final String format = String.format("id %d Member %s skype %s email: %s  ", id, name, skype, email);
            System.out.println(format);

            cursor.moveToNext();
        }

        cursor.close();

    }

    public List<ClanMember> loadMember() {
        System.out.println("showMember()");                                                                   /*"title_raw like " + "'%Smith%'"*/
        final Cursor cursor = this.getReadableDatabase().query("member", new String[]{"id", "name", "skype", "email", "passwd"}, null, null, null, null, null);

        List<ClanMember> memberList = new ArrayList<ClanMember>();

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            final int id = cursor.getInt(0);
            final String name = cursor.getString(1);
            final String skype = cursor.getString(2);
            final String email = cursor.getString(3);
            final String passwd = cursor.getString(4);

            final ClanMember clanMember = new ClanMember(name, skype);
            clanMember.ID = id;
            clanMember.email = email;
            clanMember.passwd = passwd;
            memberList.add(clanMember);

            cursor.moveToNext();
        }

        cursor.close();

        return memberList;
    }


    public void deleteMemberByID(final int id) {
        System.out.println("deleteByID " + id);

        final String table = "member";
        final String whereClause = "id=?";
        final String[] whereArgs = {String.valueOf(id)};
        final int delete = this.getWritableDatabase().delete(table, whereClause, whereArgs);
        System.out.println("delete result:  " + delete);
    }


    public void insertNewMember(ClanMember newMember) {
        System.out.println("insertNewMember()");
        final SQLiteStatement stmt = this.getWritableDatabase().compileStatement("INSERT INTO member (name, skype, email, passwd) VALUES(?,?,?,?)");
        stmt.bindString(1, newMember.name);
        stmt.bindString(2, newMember.skype);
        stmt.bindString(3, newMember.email);
        stmt.bindString(4, newMember.passwd);

        final long id = stmt.executeInsert();
        System.out.println("Insert done last id: " + id);

    }


    public ClanMember loadMemberByName(final String memberName) {
        System.out.println("loadMemberByName( " + memberName + " )");

        final Cursor cursor = this.getReadableDatabase().rawQuery("SELECT id, name, skype, email, passwd, battlelog FROM member WHERE name = (?)", new String[]{memberName});

        ClanMember member = new ClanMember("null", "null");

        if (cursor.moveToFirst()) {
            System.out.println("Cursor is on first row");
            final int id = cursor.getInt(0);
            final String name = cursor.getString(1);
            final String skype = cursor.getString(2);
            final String email = cursor.getString(3);
            final String passwd = cursor.getString(4);
            final String battlelog = cursor.getString(5);

            member.ID = id;
            member.name = name;
            member.skype = skype;
            member.email = email;
            member.passwd = passwd;
            member.battlelog = battlelog;

        } else {
            System.out.println("Cursor moveToFirst failed");
        }

        cursor.close();

        return member;
    }

    public ClanMember loadMemberByID(final int id) {
        System.out.println("loadMemberByID( " + id + " )");
        final Cursor cursor = this.getReadableDatabase().rawQuery("SELECT id, name, skype, email, passwd, battlelog FROM member WHERE id = (?)", new String[]{String.valueOf(id)});

        ClanMember member = new ClanMember("null", "null");

        if (cursor.moveToFirst()) {
            System.out.println("Cursor is on first row");
            final int _id = cursor.getInt(0);
            final String name = cursor.getString(1);
            final String skype = cursor.getString(2);
            final String email = cursor.getString(3);
            final String passwd = cursor.getString(4);
            final String battlelog = cursor.getString(5);

            member.ID = _id;
            member.name = name;
            member.skype = skype;
            member.email = email;
            member.passwd = passwd;
            member.battlelog = battlelog;

        } else {
            System.out.println("Cursor moveToFirst failed");
        }

        cursor.close();

        return member;
    }

    public void writeMemberStatsInDatabase(ClanMember member) {
        System.out.println("writeMemberStatsInDatabase");
        // check values are up to date.
        final long currentStatsTime = member.stats.getStatisticUpdateTimeInMillis();
        final boolean isStatsInDB = this.isStatisticByTimeInDatabase(member, currentStatsTime);
        // if new stats write them down.
        if (!isStatsInDB) {
            System.out.println("Write new stats in db from " + member.name);
            // write global
            final long global_id = this.writeGlobal(member.stats.global);
            // write rank
            final long rank_id = this.writeRank(member.stats.rank);
            // write score
            final long score_id = this.writeScore(member.stats.scores);
            // write stats

            System.out.println("all relationships are in database now write stats with referenced ids");
            final SQLiteStatement stmt = this.getWritableDatabase().compileStatement("INSERT INTO stats   (member_id , updatetime, rank_id,  global_id, score_id) VALUES ( ?, ?, ?, ?, ? )");
            stmt.bindLong(1, member.ID);
            stmt.bindLong(2, currentStatsTime);
            stmt.bindLong(3, rank_id);
            stmt.bindLong(4, global_id);
            stmt.bindLong(5, score_id);

            final long insertID = stmt.executeInsert();
            System.out.println("Insert job done last ID: " + insertID);


        } else {
            System.out.println("Stats are up to date no data written");
        }

    }

    private long writeScore(final Scores scores) {
        System.out.println("writeRank()");
        final SQLiteStatement stmt = this.getWritableDatabase().compileStatement("INSERT INTO score (score, award, assault, bonus, engineer, general, objective, recon, sqad, support, team, unlock) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        stmt.bindLong(1, scores.score);
        stmt.bindLong(2, scores.award);
        stmt.bindLong(3, scores.assault);
        stmt.bindLong(4, scores.bonus);
        stmt.bindLong(5, scores.engineer);
        stmt.bindLong(6, scores.general);
        stmt.bindLong(7, scores.objective);
        stmt.bindLong(8, scores.recon);
        stmt.bindLong(9, scores.squad);
        stmt.bindLong(10, scores.support);
        stmt.bindLong(11, scores.team);
        stmt.bindLong(12, scores.unlock);

        final long id = stmt.executeInsert();
        System.out.println("Insert scores done last id: " + id);

        return id;
    }

    private long writeRank(final Rank rank) {
        System.out.println("writeRank()");
        final SQLiteStatement stmt = this.getWritableDatabase().compileStatement("INSERT INTO rank (nr, name ) VALUES (?, ?)");
        stmt.bindLong(1, rank.nr);
        stmt.bindString(2, rank.name);

        final long id = stmt.executeInsert();
        System.out.println("Insert rank done last id: " + id);

        return id;
    }

    private long writeGlobal(final Global global) {
        System.out.println("writeGlobal()");
        final SQLiteStatement stmt = this.getWritableDatabase().compileStatement("INSERT INTO global (kills, deaths, wins, losses, shots, hits, headshots, time, vihicletime, vihiclekills, reviews, resupplies, heals, repairs, rounds, dogtags, vihicledestroy) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        stmt.bindLong(1, global.kills);
        stmt.bindLong(2, global.deaths);
        stmt.bindLong(3, global.wins);
        stmt.bindLong(4, global.losses);
        stmt.bindLong(5, global.shots);
        stmt.bindLong(6, global.hits);
        stmt.bindLong(7, global.headshots);
        stmt.bindLong(8, global.time);
        stmt.bindDouble(9, global.vehicletime);
        stmt.bindLong(10, global.avengerkills);
        stmt.bindLong(11, global.revives);
        stmt.bindLong(12, global.resupplies);
        stmt.bindDouble(13, global.heals);
        stmt.bindDouble(14, global.repairs);
        stmt.bindLong(15, global.rounds);
        stmt.bindLong(16, global.dogtags);
        stmt.bindLong(17, global.vehicledestroyed);


        final long id = stmt.executeInsert();
        System.out.println("Insert global done last id: " + id);

        return id;
    }

    private boolean isStatisticByTimeInDatabase(final ClanMember member, final long currentStatsTime) {
        System.out.println("check statistic is in database by time : " + currentStatsTime);

        final Cursor cursor = this.getReadableDatabase().rawQuery("SELECT id FROM stats WHERE member_id = (?) AND updatetime = (?)", new String[]{String.valueOf(member.ID), String.valueOf(currentStatsTime)});

        boolean exists;

        if (cursor.moveToFirst()) {
            System.out.println("cursor is move to first ");
            exists = true;
        } else {
            System.out.println("cursor not moved to first row, no result we have new stats data!");
            exists = false;
        }

        cursor.close();

        return exists;
    }


    /* Debug functions */

    private void deleteDbFileForTest() {
        System.out.println("deleteDbFileForTest() ");
        String fullDatabasePath = DB_PATH + DB_NAME;

        File db = new File(fullDatabasePath);
        if (db.exists()) {
            System.out.println("db file exists try to delete ");
            final boolean delete = db.delete();
            if (delete)
                System.out.println("delete succeeded");
            else
                System.out.println("delete failed");
        } else
            System.out.println("db file not found");
    }

                  // javascript:player.updatePlayer()
    public void exportDatabaseInDevice(){
        System.out.println("exportDatabaseInDevice ");
        final File dataDirectory = Environment.getExternalStorageDirectory();


        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            final String outFileName = DB_PATH + DB_NAME;
            inputStream = new FileInputStream(outFileName);
            outputStream = new FileOutputStream(dataDirectory + "/" + DB_NAME );

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.flush();

        } catch (IOException gay) {
            final String error = "copyDataBase transfer byte stream error.";
            Log.e(error, error, gay);
        } finally {
            try {
                if (outputStream != null)
                    outputStream.close();
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException gayMore) {
                final String error = "close streams error.";
                Log.e(error, error, gayMore);
            }
        }

    }
}