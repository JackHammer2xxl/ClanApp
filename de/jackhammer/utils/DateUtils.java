package de.jackhammer.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 26.11.11
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class DateUtils {


    public static void main(String[] args) {
        final long ct = System.currentTimeMillis();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss.S");


        final Date date = new Date(ct);
        System.out.println(ct);
        final String dateString = String.format("%sT%sZ", df.format(date), tf.format(date));
        System.out.println(dateString);

        String raw = "2011-11-26T01:19:15.331Z";

//        final String[] tailed = dateString.replace("Z", "").split("T");
        final String[] tailed = raw.replace("Z", "").split("T");


        SimpleDateFormat stringParser = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss.S");
        Date parse = null;
        try {
            parse = stringParser.parse(String.format("%s %s", tailed[0], tailed[1]));
        } catch (ParseException e) {
            System.out.println("Cant read date string");
        }

        System.out.println(parse.getTime());
    }
}
