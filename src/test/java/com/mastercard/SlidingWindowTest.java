package com.mastercard;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

public class SlidingWindowTest {
    private SlidingWindow slidingWindow;

    @Before
    public void initialize() {
        this.slidingWindow = new SlidingWindow();
    }

    /**
     * This test case just check the thread safety of the method
     */
    @Test
    public void test_sliding_window_thread_safety() {
        Record[] records = new Record[] { new Record(2, Timestamp.valueOf("2021-08-12 10:00:01.0")) };

        for (int i = 0; i < 10; i++) {
            Thread thread = new SlidingWindowThread(this.slidingWindow, records, i);
            thread.start();
        }
    }

    public class SlidingWindowThread extends Thread {
        private SlidingWindow slidingWindow;
        private Record[] records;
        private int windowLength;

        public SlidingWindowThread(SlidingWindow slidingWindow, Record[] records, int windowLength) {
            this.slidingWindow = slidingWindow;
            this.records = records;
            this.windowLength = windowLength;
        }

        @Override
        public void run() {
            this.slidingWindow.average(this.records, this.windowLength);
        }
    }
}
