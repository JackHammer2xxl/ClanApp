package de.jackhammer.comparator;

import de.jackhammer.members.ClanMember;
import de.jackhammer.stats.GameModes;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 26.11.11
 * Time: 02:27
 * To change this template use File | Settings | File Templates.
 */
public class MemberComparators {




    public static Comparator rankComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.rank.nr;
                final int val2 = m2.stats.rank.nr;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator killComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.kills;
                final int val2 = m2.stats.global.kills;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator winsComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.wins;
                final int val2 = m2.stats.global.wins;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator lossesComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.losses;
                final int val2 = m2.stats.global.losses;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator hitsComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.hits;
                final int val2 = m2.stats.global.hits;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator deathsComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.deaths;
                final int val2 = m2.stats.global.deaths;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator headShotsComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.headshots;
                final int val2 = m2.stats.global.headshots;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator shotsComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.shots;
                final int val2 = m2.stats.global.shots;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator playTimeComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.time;
                final int val2 = m2.stats.global.time;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator dogtagsComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.dogtags;
                final int val2 = m2.stats.global.dogtags;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator vehicleKillsComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.vehiclekills;
                final int val2 = m2.stats.global.vehiclekills;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator vehicletimeComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final double val1 = m1.stats.global.vehicletime;
                final double val2 = m2.stats.global.vehicletime;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator roundsComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.global.rounds;
                final int val2 = m2.stats.global.rounds;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator scoresAssaultComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.scores.assault;
                final int val2 = m2.stats.scores.assault;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator scoresEngineerComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.scores.engineer;
                final int val2 = m2.stats.scores.engineer;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator scoresReconComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.scores.recon;
                final int val2 = m2.stats.scores.recon;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }

    public static Comparator scoresSupportComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember m1, ClanMember m2) {
                final int val1 = m1.stats.scores.support;
                final int val2 = m2.stats.scores.support;
                return (val1 < val2 ? 1 : (val1 == val2 ? 0 : -1));
            }
        };
    }


    public static Comparator dateComparator() {
        return new Comparator<ClanMember>() {

            public int compare(ClanMember o1, ClanMember o2) {
//                long val1 = ((Date) o1).getTime();
//                long val2 = ((Date) o2).getTime();
//                return (val1 < val2 ? -1 : (val1 == val2 ? 0 : 1));
                return 0;
            }
        };
    }
}
