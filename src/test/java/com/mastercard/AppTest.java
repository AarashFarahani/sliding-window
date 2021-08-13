package com.mastercard;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * To run all test cases
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ SlidingWindowTest.class, SlidingWindowPositiveCasesTest.class })
public class AppTest {
}
