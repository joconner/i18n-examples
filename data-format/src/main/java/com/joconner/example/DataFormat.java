package com.joconner.example;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 *
 * @author joconner
 */
public class DataFormat {

    // preset a date and number to format
    private final Date aDate = new Date();
    private final int aNumber = 123456789;

    // Formatting numbers and dates requires a locale
    @Option(name = "-l", usage = "locale to use for formatting")
    private String strLocale = "en-US";

    @Option(name = "-c", usage = "currency to use during formatting")
    private String strCurrency = "USD";

    // Date formats need to consider time zone if you are
    // using a java Date instance and are formatting for a 
    // specific area. Otherwise, the default zone of the server
    // will be used, and that's not typically correct.
    @Option(name = "-t", usage = "timezone to use while formatting date")
    private String strTz = "America/Los_Angeles";

    private Locale locale;
    private Currency currency;
    private TimeZone tz;

    private DateFormat df;
    private NumberFormat nf;
    private NumberFormat cf;

    private CmdLineParser parser;

    public DataFormat(String[] args) {
        parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException ex) {
            System.err.println("java DataFormat [options...]");
            parser.printUsage(System.err);
            System.err.println();
            System.exit(-1);
        }
        locale = Locale.forLanguageTag(strLocale);
        currency = Currency.getInstance(strCurrency);
        tz = TimeZone.getTimeZone(strTz);

        df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        df.setTimeZone(tz);

        nf = NumberFormat.getIntegerInstance(locale);
        cf = NumberFormat.getCurrencyInstance(locale);

        // here I'm just setting the currency as provided on
        // command line, or the default 
        cf.setCurrency(currency);
    }

    public void run() {
        System.out.printf("Date: %s\n", df.format(aDate));
        System.out.printf("Number: %s\n", nf.format(aNumber));
        System.out.printf("Currency: %s\n", cf.format(aNumber));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DataFormat app = new DataFormat(args);
        app.run();
    }

}
