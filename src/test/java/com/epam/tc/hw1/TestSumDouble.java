package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestSumDouble extends CalculatorBaseTest {

    @DataProvider
    public Object[][] sumDoubleDataProvider() {
        return new Object[][] {
            {2.5, -2.0, 0.5},
            {1.1, 9.9, 11.0},
            {-5.5, -5.5, -11.0}
        };
    }

    @Test(dataProvider = "sumDoubleDataProvider")
    public void testSumDouble(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
