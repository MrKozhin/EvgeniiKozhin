package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestSubtractLong extends CalculatorBaseTest {

    @DataProvider
    public Object[][] subLongDataProvider() {
        return new Object[][] {
                {-1, 0, -1},
                {999, -1, 1000},
                {-5, -5, 0},
                {1000, 1, 999},
                {13, 0, 13}
        };
    }

    @Test(dataProvider = "subLongDataProvider")
    public void testSubLong(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
