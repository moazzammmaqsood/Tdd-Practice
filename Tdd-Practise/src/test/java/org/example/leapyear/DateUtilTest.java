package org.example.leapyear;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {


    @Test
    public  void normalLeapYearIsLeap(){
        assertTrue(DateUtil.isLeapYear(1992));

    }

    @Test
    public  void normalLeapYearExample2Leap(){
        assertTrue(DateUtil.isLeapYear(1996));

    }
    @Test void nonLeapYearIsNotLeap(){
        assertFalse(DateUtil.isLeapYear(1991));
    }

    @Test
    public  void centuryYearAreNotLeap(){
        assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    public void year2000WasLeap(){
        assertTrue(DateUtil.isLeapYear(2000));
    }

}
