package fi.hamk.riksu.hamkopendata;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by tlaitinen on 9.12.2016.
 * @desc Custom helper functions and constants
 */

public class OpendataHelper {
    private static String URL_BASE = "https://opendata.hamk.fi:8443/r1/";
    public static String RESERVATIONS_ALL_URL = URL_BASE+"reservation/building";
    public static String RESERVATIONS_URL = URL_BASE+"reservation/search";
    public static String REALIZATIONS_URL = URL_BASE+"realization/search";
    public static String CURRICULUMS_URL = URL_BASE+"curriculum/search";
    /**
     * Get current date as string
     * @param days days to add to current
     * @return date as json compatible string format
     */
    public static String getCurrentDateString(int days) {
        //    Calendar calendar = new GregorianCalendar();
        //    calendar.setTime(now);

        DateTime now = new DateTime().plusDays(days); // joda-time -kirjastosta
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
        return fmt.print(now);
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        //    sdf.setCalendar(calendar);
        return sdf.format(now);
*/
        /*
        StringBuilder s = new StringBuilder();
        s.append(calendar.get(Calendar.YEAR));
        s.append("-");
        s.append(String.format("%02d",(1+calendar.get(Calendar.MONTH))));
        s.append("-");
        s.append(String.format("%02d",calendar.get(Calendar.DAY_OF_MONTH)));
        s.append("T00:00");
        return s.toString();*/
    }
}
