package de.jackhammer.constants;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 25.11.11
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
public abstract class Const {

    private static final String JSON_URL = "http://bf3stats.com/stats_pc/%s/ov_details.js";

    public static String getJsonUrl(final String memberName) {
        return String.format(JSON_URL, memberName );
    }
}
