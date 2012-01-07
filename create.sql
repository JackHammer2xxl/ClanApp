/*
CREATE TABLE IF NOT EXISTS  DB_TABLE_GLOBAL (
  _id integer primary key autoincrement
  ,name varchar(100)
  ,model varchar(100),
  ,bemerkungen varchar(255)
  ,kraftstoffart integer(3)
  ,tankinhalt integer(3))
);
*/

-- table member
-- CREATE  TABLE IF NOT EXISTS 'main'.'member' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'name' VARCHAR NOT NULL  UNIQUE , 'skype' VARCHAR UNIQUE , 'email' VARCHAR UNIQUE , 'passwd' VARCHAR);
CREATE  TABLE IF NOT EXISTS 'main'.'member' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'name' VARCHAR NOT NULL  UNIQUE , 'skype' VARCHAR , 'email' VARCHAR  , 'passwd' VARCHAR , 'battlelog' VARCHAR );

-- table stats
-- CREATE  TABLE 'main'.'stats' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'member_id' INTEGER NOT NULL , 'updatetime' DATETIME NOT NULL  UNIQUE , 'rank_id' INTEGER NOT NULL , 'global_id' INTEGER NOT NULL , 'score_id' INTEGER NOT NULL );
-- CREATE  TABLE IF NOT EXISTS 'main'.'stats' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'member_id' INTEGER NOT NULL , 'updatetime' VARCHAR NOT NULL  UNIQUE , 'rank_id' INTEGER NOT NULL , 'global_id' INTEGER NOT NULL , 'score_id' INTEGER NOT NULL );
-- CREATE  TABLE IF NOT EXISTS 'main'.'stats' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'member_id' INTEGER NOT NULL , 'updatetime' INTEGER NOT NULL  UNIQUE , 'rank_id' INTEGER NOT NULL , 'global_id' INTEGER NOT NULL , 'score_id' INTEGER NOT NULL );
CREATE TABLE 'stats' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'member_id' INTEGER NOT NULL , 'updatetime' INTEGER NOT NULL   , 'rank_id' INTEGER NOT NULL , 'global_id' INTEGER NOT NULL , 'score_id' INTEGER NOT NULL );


-- table rank
CREATE  TABLE IF NOT EXISTS 'main'.'rank' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'nr' INTEGER NOT NULL , 'name' VARCHAR NOT NULL );


-- table score
CREATE  TABLE IF NOT EXISTS 'main'.'score' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'score' INTEGER, 'award' INTEGER, 'assault' INTEGER, 'bonus' INTEGER, 'engineer' INTEGER, 'general' INTEGER, 'objective' INTEGER, 'recon' INTEGER, 'sqad' INTEGER, 'support' INTEGER, 'team' INTEGER, 'unlock' INTEGER);


-- table global
CREATE  TABLE IF NOT EXISTS 'main'.'global' ('id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'kills' INTEGER, 'deaths' INTEGER, 'wins' INTEGER, 'losses' INTEGER, 'shots' INTEGER, 'hits' INTEGER, 'headshots' INTEGER, 'time' INTEGER, 'vihicletime' DOUBLE, 'vihiclekills' INTEGER, 'reviews' INTEGER, 'resupplies' INTEGER, 'heals' DOUBLE, 'repairs' DOUBLE, 'rounds' INTEGER, 'dogtags' INTEGER, 'vihicledestroy' INTEGER);



-- insert member
INSERT INTO member (name, skype, email, passwd) VALUES('JackHammer' , 'JackHammer', 'JackHammer@web.de' , 'jackisback');
INSERT INTO member (name, skype, email, passwd) VALUES('Jack' , 'Jack', 'Jack@web.de' , 'backisjack');



-- insert stats
INSERT INTO stats   (member_id , updatetime, rank_id,  global_id, score_id) VALUES ( ?, ?, ?, ?, ? );

-- insert global
INSERT INTO global (kills, deaths, wins, losses, shots, hits, headshots, time, vihicletime, vihiclekills, reviews, resupplies, heals, repairs, rounds, dogtags, vihicledestroy) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);

-- insert into rank
INSERT INTO rank (nr, name ) VALUES (?, ?);


-- insert into scores
INSERT INTO score (score, award, assault, bonus, engineer, general, objective, recon, sqad, support, team, unlock) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);