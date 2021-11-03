package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestSumLong extends CalculatorBaseTest {

    @DataProvider
    public Object[][] sumLongDataProvider() {
        return new Object[][] {
            {-1, 100, 99},
            {-2, -8, -10},
            {0, -11, -11}
        };
    }

    @Test(dataProvider = "sumLongDataProvider")
    public void testSumLong(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
