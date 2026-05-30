package com.shirish.globalbookingsystem.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(
                    "yyyy-MM-dd HH:mm:ss z"
            );

    private DateTimeUtil() {
    }

    public static String convertUtcToTimezone(
            Instant utcTime,
            String timezone
    ) {

        ZonedDateTime zonedDateTime =
                utcTime.atZone(ZoneId.of(timezone));

        return zonedDateTime.format(FORMATTER);
    }

    public static Instant parseToInstant(
            String dateTime
    ) {

        return Instant.parse(dateTime);
    }
}