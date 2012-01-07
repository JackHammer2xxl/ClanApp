package de.jackhammer.dao;

import android.app.Activity;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.io.IOException;

import static de.jackhammer.dao.PreparedStatements.*;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 26.11.11
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */
public class SqliteLayer {

    private final static String DB_NAME = "history";
    private final static String DB_EXT = "sqlite";
    private final static String DB_TABLE_GLOBAL = "global";
    private final static String DB_TABLE_RANK = "rank";
    private final static String DB_TABLE_SCORE = "score";
    private final static String DB_TABLE_STATS = "stats";

    private SQLiteDatabase database = null;
    private final Activity activity;


    public SqliteLayer(final Activity activity) {
        this.activity = activity;
    }

    private void onCreateDatabaseAndCreateTables(final Activity activity) {
        database = activity.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        database.execSQL(stmt_create_table_member);
//        database.execSQL(stmt_create_table_stats);
//        database.execSQL(stmt_create_table_score );
//        database.execSQL(stmt_create_table_rank );
//        database.execSQL(stmt_create_table_global );
    }


    private void loadMember(final String memberName) {
        // SQLiteDatabase db = activity.getWritableDatabase();
        SQLiteStatement stmt = database.compileStatement("SELECT * FROM member WHERE name = ?");
        stmt.bindString(1, memberName);
        final String result = stmt.simpleQueryForString();

        System.out.println("RESULT: " + result);
    }

    private void init() {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(activity);
            dataBaseHelper.createDataBase();
        try {
            dataBaseHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
    }

    public void insertMember() {

    }


}
