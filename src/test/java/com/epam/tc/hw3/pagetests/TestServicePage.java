package com.epam.tc.hw3.pagetests;

import static com.epam.tc.hw3.data.TestDataExpected.HEADER_BUTTONS_EXPECTED;
import static com.epam.tc.hw3.data.TestDataExpected.LOG_ROWS_EXPECTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestServicePage extends HW3BaseTest {

    @DataProvider
    public Object[][] buttonsTextDataProvider() {
        return new Object[][] {
            {"Home Page", "ROMAN IOVLEV"}
        };
    }


    @Test(dataProvider = "buttonsTextDataProvider")
    public void testServicePage(String title, String username) {

        //        2. Assert Browser title
        assertThat(webDriver.getTitle()).isEqualTo(title);

        //        4. Assert User name in the left-top side of screen that user is logged in
        assertThat(logInPage.getLoggedInUsername().getText())
            .isEqualTo(username);

        assertThat(logInPage.getLoggedInUsername().isDisplayed())
            .isTrue();

        //        5. Open through the header menu Service -> Different Elements Page
        servicePage.clickHeaderMenuItem(HEADER_BUTTONS_EXPECTED.get(2))
                   .clickDifferentElementsButton();

        //        6. Select checkbox Water
        //           Select checkbox Wind
        //        7. Select radio Selen
        //        8. Select in dropdown Yellow
        servicePage.clickWaterCheckBox()
                   .clickWindCheckBox()
                   .clickSelenElement()
                   .clickDropdownYellow();

        //        9. Assert that
        //        for each checkbox there is an individual log row and value is corresponded to the status of checkbox

        assertThat(servicePage
            .getLogRowWater()
            .getText())
            .contains(LOG_ROWS_EXPECTED.get(0)
            );


        assertThat(servicePage
            .getLogRowWind()
            .getText())
            .contains(LOG_ROWS_EXPECTED.get(1)
            );

        //        for radio button there is a log row and value is corresponded to the status of radio button

        assertThat(servicePage
            .getLogRowSelen()
            .getText())
            .contains(LOG_ROWS_EXPECTED.get(2)
            );

        //        for dropdown there is a log row and value is corresponded to the selected value.

        assertThat(servicePage
            .getLogRowYellow()
            .getText())
            .contains(LOG_ROWS_EXPECTED.get(3)
            );

    }
}
