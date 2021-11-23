package com.epam.tc.hw4.pagetests;

import static com.epam.tc.hw3.data.TestDataExpected.SIDEBAR_EXPECTED;
import static com.epam.tc.hw3.data.TestDataExpected.TEXTS_EXPECTED;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestHomePage extends HW4BaseTest {

    @DataProvider
    public Object[][] pageTitleAndUsernameDataProvider() {
        return new Object[][] {
            {"Home Page", "ROMAN IOVLEV"}
        };
    }


    @Test(dataProvider = "pageTitleAndUsernameDataProvider")
    @Description("Testing Homepage")
    @Feature("Homepage login and proper web elements feature")
    @Story("Proper homepage appearance")
    public void testHomePage(String pageTitle, String username) {

        homePageSteps.openWebApp()
                     .checkPageTitle(pageTitle)
                     .checkLoggingIn()
                     .checkUsername(username)
                     .checkHeaderButtons()
                     .checkHomePageImages()
                     .checkImageTexts(TEXTS_EXPECTED)
                     .checkFrameButton()
                     .switchToFrameAndCheckButtonIsEnabled()
                     .switchBackToWindow()
                     .checkLeftSideMenuButtons(SIDEBAR_EXPECTED);











    }
}
