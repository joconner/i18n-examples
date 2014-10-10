package com.joconner.example;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by John O'Conner on 10/8/14.
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        ZoneId zoneDefault = ZoneId.systemDefault();
        LocalDate localDateDefault = LocalDate.now();

        ZoneId zoneDublin = ZoneId.of("Europe/Dublin");
        LocalDate localDateDublin = LocalDate.now(zoneDublin);

        System.out.printf("The date now in %s is %s.\n", zoneDefault.toString(), localDateDefault.toString());
        System.out.printf("The date now in %s is %s.\n", zoneDublin.toString(), localDateDublin.toString());

        LocalDate dateHalloween = LocalDate.of(2014, 10, 31);

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate((FormatStyle.FULL));

        System.out.printf("Halloween is %s.\n", dateHalloween.format(formatter));
    }
}
