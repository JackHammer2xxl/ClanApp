package de.jackhammer.stats;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
public enum GameModes {

    CONQUEST("conquest"),
    RUSH("rush"),
    SQUAD_RUSH("squadrush"),
    TEAM_DM("teamdm"),
    SQAD_DM("squaddm");

    public final String value;

    private GameModes(final String value){
        this.value = value;
    }
}
