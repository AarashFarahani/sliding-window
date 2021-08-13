package com.mastercard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SlidingWindowPositiveCasesTest {
    private static final double DELTA = 1e-15;
    private Record[] records;
    private int windowLength;
    private double expectedResult;
    private SlidingWindow slidingWindow;

    public SlidingWindowPositiveCasesTest(Record[] records, int windowLength, double expectedResult) {
        this.records = records;
        this.windowLength = windowLength;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Record[]{new Record(10, Timestamp.valueOf("2021-08-12 10:00:01.0"))}, 10, 10},
                {new Record[]{
                        new Record(7, Timestamp.valueOf("2021-08-12 10:00:01.0")),
                        new Record(15, Timestamp.valueOf("2021-08-12 10:00:02.0")),
                        new Record(12, Timestamp.valueOf("2021-08-12 10:00:03.0")),
                        new Record(18, Timestamp.valueOf("2021-08-12 10:00:04.0")),
                        new Record(3, Timestamp.valueOf("2021-08-12 10:00:05.0")),
                }, 3, 11},
                {new Record[]{
                        new Record(7, Timestamp.valueOf("2021-08-12 10:00:01.0")),
                        new Record(15, Timestamp.valueOf("2021-08-12 10:00:02.0")),
                        new Record(12, Timestamp.valueOf("2021-08-12 10:00:03.0")),
                        new Record(18, Timestamp.valueOf("2021-08-12 10:00:04.0")),
                        new Record(3, Timestamp.valueOf("2021-08-12 10:00:09.0")),
                }, 3, 3},
        });
    }

    @Before
    public void initialize() {
        this.slidingWindow = new SlidingWindow();
    }

    @Test
    public void testParameterizedSlidingWindow() {
        Assert.assertEquals(this.slidingWindow.average(this.records, this.windowLength), expectedResult, DELTA);
    }
}
