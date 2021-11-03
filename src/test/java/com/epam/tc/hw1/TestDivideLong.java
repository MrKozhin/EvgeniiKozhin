package com.epam.tc.hw1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestDivideLong extends CalculatorBaseTest {

    @DataProvider
    public Object[][] divLongDataProvider() {
        return new Object[][] {
                {6, 3, 2},
                {-10, -5, 2},
                {-999, 1, -999}
        };
    }

    @Test(dataProvider = "divLongDataProvider")
    public void testDivideLong(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }
}
