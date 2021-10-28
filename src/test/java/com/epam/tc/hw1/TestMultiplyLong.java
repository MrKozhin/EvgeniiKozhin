package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestMultiplyLong extends CalculatorBaseTest {

    @DataProvider
    public Object[][] multLongDataProvider() {
        return new Object[][] {
                {9, 8, 72},
                {-1000, -10000, 10000000},
                {-111, 111, -12321}
        };
    }

    @Test(dataProvider = "multLongDataProvider")
    public void testMultiplyLong(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
