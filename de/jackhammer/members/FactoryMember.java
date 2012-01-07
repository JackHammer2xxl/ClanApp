package de.jackhammer.members;

import de.jackhammer.stats.FactoryStats;
import de.jackhammer.stats.Statistic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 19.11.11
 * Time: 16:27
 * To change this template use File | Settings | File Templates.
 */
public abstract class FactoryMember {


    public static List<ClanMember> loadAllMembersFromClan(final String clanTag){
        System.out.println(String.format("Load all memberList from %s", clanTag) );

        List<ClanMember> memberList = new ArrayList<ClanMember>();



        for(ClanMember member : memberList){
            final Statistic memberStats = FactoryStats.createMemberStatsFrom(member );
            member.setStats(memberStats );
        }

        return memberList;

    }



}
