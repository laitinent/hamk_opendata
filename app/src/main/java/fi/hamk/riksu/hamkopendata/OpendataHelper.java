package fi.hamk.riksu.hamkopendata;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.UnsupportedEncodingException;

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
    public static String COURSEUNIT_URL = URL_BASE+"courseunit/";
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

    /**
     * format date from yyyy-MM-dd'T'HH:mm to dd.MM.yy
     * @param preformatted date string in input format
     * @return date string in output format
     */
    public static String formatDate(String preformatted)
    {
        // Populate the data into the template view using the data object
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");// :ss lisätty
        DateTimeFormatter outfmt = DateTimeFormat.forPattern("dd.MM.yy");
        DateTime startDate = fmt.parseDateTime(preformatted);//user.getStartDate());

        return startDate.toString(outfmt);//tvHome.setText(startDate.toString(outfmt));
    }

    /**
     * Print message in as toast and console
     * @param me Context e.g. activity
     * @param msg Message to print
     */
    public static void printToastErr(Context me,String msg)
    {
        System.err.println(msg);
        Toast.makeText(me, "Virhe: " + msg, Toast.LENGTH_LONG).show();
    }
    /**
     *
     * @param message Message
     * @param title Title
     * @param ctx Context
     * @param strUseNegativeButton (Optional)Set button text to use negative button
     */
    public static void ShowAlertDialog(String message, String title, Context ctx, String... strUseNegativeButton) {
        String subject="", caption="";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctx);
        // set title

        // set dialog message
        try {
            caption = new String(title.getBytes("ISO-8859-1"), "UTF-8");
            subject = new String(message.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        alertDialogBuilder.setTitle(caption);
        alertDialogBuilder
                .setMessage(subject)
                .setCancelable(false)
                .setPositiveButton("OK", (dialog, id) -> {
                    // if this button is clicked, close current activity
                    dialog.dismiss();
                    //MainActivity.this.finish();
                });

        if(strUseNegativeButton.length > 0) {
            alertDialogBuilder.setNegativeButton(strUseNegativeButton[0], (dialog, id) -> {
                // if this button is clicked, just close the dialog box and do nothing
                dialog.cancel();
            });
        }
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }

    /**
     *
     * @param context   Activity/Context
     * @param view      View that had foxus
     */
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
