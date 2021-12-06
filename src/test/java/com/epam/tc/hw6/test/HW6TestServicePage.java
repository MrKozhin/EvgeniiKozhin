package com.epam.tc.hw6.test;

import static com.epam.tc.hw3.data.TestDataExpected.LOG_ROWS_EXPECTED;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HW6TestServicePage extends HW6BaseTest {

    @DataProvider
    public Object[][] pageTitleAndUsernameDataProvider() {
        return new Object[][] {
            {"Home Page", "ROMAN IOVLEV"}
        };
    }

    @Test(dataProvider = "pageTitleAndUsernameDataProvider")
    @Description("Testing Service page")
    @Feature("Service page login and proper web elements feature")
    @Story("Service page proper working different elements buttons")
    public void testServicePage(String title, String username) {

        servicePageSteps.openWebApp()
                        .checkPageTitle(title)
                        .checkLoggingIn()
                        .checkUsername(username)
                        .openDifferentElementsPage()
                        .selectWaterAndWindCheckboxes()
                        .selectSelenCheckbox()
                        .selectDropdownYellow()
                        .checkLogRowForWaterAndWind(LOG_ROWS_EXPECTED.get(0), LOG_ROWS_EXPECTED.get(1))
                        .checkLogRowForRadioButton(LOG_ROWS_EXPECTED.get(2))
                        .checkLogRowForDropdown(LOG_ROWS_EXPECTED.get(3));


    }
}
