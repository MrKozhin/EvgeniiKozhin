package com.epam.tc.hw4.pagetests;

import static com.epam.tc.hw3.data.TestDataExpected.HEADER_BUTTONS_EXPECTED;
import static com.epam.tc.hw3.data.TestDataExpected.LOG_ROWS_EXPECTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestServicePage extends HW4BaseTest {

    @DataProvider
    public Object[][] buttonsTextDataProvider() {
        return new Object[][] {
            {"Home Page", "ROMAN IOVLEV"}
        };
    }


    @Test(dataProvider = "buttonsTextDataProvider")
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
                        .checkLogRowForWaterAndWind()
                        .checkLogRowForRadioButton()
                        .checkLogRowForDropdown();


    }
}
