package com.shirish.globalbookingsystem.util;

import java.time.ZoneId;
import java.util.Set;

public class TimeZoneUtil {

    private TimeZoneUtil() {
    }

    public static boolean isValidTimezone(
            String timezone
    ) {

        Set<String> availableZones =
                ZoneId.getAvailableZoneIds();

        return availableZones.contains(timezone);
    }

    public static ZoneId getZoneId(
            String timezone
    ) {

        return ZoneId.of(timezone);
    }
}