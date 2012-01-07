package de.jackhammer.members;

import de.jackhammer.stats.Statistic;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 19.11.11
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */
public final class ClanMember {

    public int       ID = -1;
    public String    name = "";
    public String    skype = "";
    public String    email = "";
    public Statistic stats;
    public String    passwd = "";
    public String battlelog   = "null";


    public ClanMember(final String name, final String skypeID) {
        this.name = name;
        this.skype = skypeID;
    }

    public void setStats(final Statistic memberStats) {
        System.out.println("Update member stats from: " + name );
        this.stats = memberStats;
    }

    @Override
    public String toString() {
        final String format = String.format("Member %s id %d skype %s email: %s  battlelog: %s ",name, ID, skype, email, battlelog);
        return format;
    }
}
