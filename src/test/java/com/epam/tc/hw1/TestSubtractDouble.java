package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestSubtractDouble extends CalculatorBaseTest {

    @DataProvider
    public Object[][] subDoubleDataProvider() {
        return new Object[][] {
            {-1.1, 8.9, -10.0},
            {-99.9, -99.9, 0.0},
            {101, 51, 50}
        };
    }

    @Test(dataProvider = "subDoubleDataProvider")
    public void testSubDouble(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
