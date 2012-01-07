package de.jackhammer.dao;

import org.intellij.lang.annotations.Language;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 26.11.11
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public abstract class PreparedStatements {

    @Language("SQLite")
    protected static final String stmt_create_table_member =
            "CREATE  TABLE IF NOT EXISTS 'main'.'member' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'name' VARCHAR NOT NULL  UNIQUE , 'skype' VARCHAR UNIQUE , 'email' VARCHAR UNIQUE , 'passwd' VARCHAR);";

    @Language("SQLite")
    protected static final String stmt_create_table_stats  =
            "CREATE  TABLE IF NOT EXISTS 'main'.'stats' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'member_id' INTEGER NOT NULL , 'updatetime' VARCHAR NOT NULL  UNIQUE , 'rank_id' INTEGER NOT NULL , 'global_id' INTEGER NOT NULL , 'score_id' INTEGER NOT NULL );";

    @Language("SQLite")
    protected static final String stmt_create_table_rank   =
            "CREATE  TABLE IF NOT EXISTS 'main'.'rank' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'nr' INTEGER NOT NULL , 'name' VARCHAR NOT NULL );";

    @Language("SQLite")
    protected static final String stmt_create_table_score  =
            "CREATE  TABLE IF NOT EXISTS 'main'.'score' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'score' INTEGER, 'award' INTEGER, 'assault' INTEGER, 'bonus' INTEGER, 'engineer' INTEGER, 'general' INTEGER, 'objective' INTEGER, 'recon' INTEGER, 'sqad' INTEGER, 'support' INTEGER, 'team' INTEGER, 'unlock' INTEGER);";

    @Language("SQLite")
    protected static final String stmt_create_table_global =
            "CREATE  TABLE IF NOT EXISTS 'main'.'global' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'kills' INTEGER, 'deaths' INTEGER, 'wins' INTEGER, 'losses' INTEGER, 'shots' INTEGER, 'hits' INTEGER, 'headshots' INTEGER, 'time' INTEGER, 'vihicletime' DOUBLE, 'vihiclekills' INTEGER, 'reviews' INTEGER, 'resupplies' INTEGER, 'heals' DOUBLE, 'repairs' DOUBLE, 'rounds' INTEGER, 'dogtags' INTEGER, 'vihicledestroy' INTEGER);";

//    protected static final String stmt_create_ = "";
//    protected static final String stmt_create_ = "";

}
