package org.example.leapyear;

public class DateUtil {

    /**
     * Is Leap year
     * @param year 4 digit year
     * @return true if leap
     */
    public static boolean isLeapYear(int year) {
        return  isDivisibleBy(year,4) && !isDivisibleBy(year,100) || isDivisibleBy(year,400);
    }

    public static  boolean isDivisibleBy(int year, int divisor){
        return year%divisor==0;
    }
}
