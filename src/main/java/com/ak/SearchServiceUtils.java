package com.ak;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class SearchServiceUtils {
    public static Date getDate(String dateAsString)
    {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        try {
            return simpleDateFormat.parse(dateAsString);
        } catch (ParseException e) {
            log.warn("Unable to parse the date, unable to search on this ", e);
        }

        return null;
    }
}
