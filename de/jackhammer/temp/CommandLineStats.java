package de.jackhammer.temp;

import de.jackhammer.comparator.MemberComparators;
import de.jackhammer.members.ClanMember;
import de.jackhammer.members.FactoryMember;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 26.11.11
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class CommandLineStats {

    private void start() {
         final List<ClanMember> clanMemberList = FactoryMember.loadAllMembersFromClan("HIV");



        Collections.sort(clanMemberList, MemberComparators.killComparator());
        showList("Most kills", clanMemberList );


        Collections.sort(clanMemberList, MemberComparators.deathsComparator() );
        showList("Most deaths", clanMemberList );

        Collections.sort(clanMemberList, MemberComparators.rankComparator() );
        showList("Best rank", clanMemberList );

        Collections.sort(clanMemberList, MemberComparators.roundsComparator() );
        showList("Most rounds", clanMemberList );


        Collections.sort(clanMemberList, MemberComparators.winsComparator() );
        showList("Most winns", clanMemberList );

        Collections.sort(clanMemberList, MemberComparators.lossesComparator() );
        showList("Most losses", clanMemberList );
    }

    private void showList(final String label, final List<ClanMember> memberList) {
        System.out.println(label + " : ");
        int index = 1;
        for(ClanMember m : memberList){
            System.out.println(String.format("Place %d.  is  %s  ", index++, m.name) );
        }

        System.out.println("---------------------");
    }

}
