package com.mastercard;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class SlidingWindow {
    public double average(Record[] records, int windowLength) {
        if(records == null || records.length == 0)
            return 0;

        Timestamp lastTimestamp = records[records.length - 1].getTimestamp();
        Timestamp windowBeginning = Timestamp
                .from(lastTimestamp.toInstant().minus(windowLength, ChronoUnit.SECONDS));

        return Arrays.stream(records)
                .filter(a-> a.getTimestamp().after(windowBeginning))
                .mapToInt(Record::getValue)
                .average()
                .orElse(0);
    }
}
