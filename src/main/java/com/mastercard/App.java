package com.mastercard;

import java.sql.Timestamp;
import java.util.Scanner;

/**
 * This class is entrypoint of Console application
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        SlidingWindow slidingWindow = new SlidingWindow();

        while (true) {
            System.out.print("How many records do you want to enter? ");
            int numberOfRecords = Integer.valueOf(sc.nextLine());
            Record[] records = new Record[numberOfRecords];

            for (int i = 0; i < numberOfRecords; i++) {
                System.out.print("Please enter the integer value? ");
                int value = Integer.valueOf(sc.nextLine());
                System.out.print("Please enter the timestamp (YYYY-MM-DD HH:mm:ss.SSS)? ");
                Timestamp timestamp = Timestamp.valueOf(sc.nextLine());
                records[i] = new Record(value, timestamp);
            }

            System.out.print("Please enter the integer for window length? ");
            int windowLength = Integer.valueOf(sc.nextLine());
            double result = slidingWindow.average(records, windowLength);
            System.out.println("The result is: " + result);
        }
    }
}
