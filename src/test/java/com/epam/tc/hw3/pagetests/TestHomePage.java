package com.epam.tc.hw3.pagetests;

import static com.epam.tc.hw3.data.TestDataExpected.HEADER_BUTTONS_EXPECTED;
import static com.epam.tc.hw3.data.TestDataExpected.PAGE_TITLE_EXPECTED;
import static com.epam.tc.hw3.data.TestDataExpected.USERNAME_EXPECTED;

import org.testng.annotations.Test;

public class TestHomePage extends HW3BaseTest {


    @Test
    public void testHomePage() {

        //        2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), PAGE_TITLE_EXPECTED);

        //        4. Assert Username is logged in
        softAssert.assertEquals(logInPage.getLoggedInUsername().getText(), USERNAME_EXPECTED);

        //        5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        softAssert.assertTrue(homePage.getHomeButtonElement().isDisplayed()
        );

        softAssert.assertEquals(
            homePage.getHomeButtonElement()
                    .getText(),
            HEADER_BUTTONS_EXPECTED.get(0)
        );

        softAssert.assertTrue(homePage.getContactFormButtonElement().isDisplayed());

        softAssert.assertEquals(
            homePage.getContactFormButtonElement()
                    .getText(),
            HEADER_BUTTONS_EXPECTED.get(1)
        );

        softAssert.assertTrue(homePage.getServiceButtonElement().isDisplayed());

        softAssert.assertEquals(
            homePage.getServiceButtonElement()
                    .getText(),
            HEADER_BUTTONS_EXPECTED.get(2)
        );

        softAssert.assertTrue(homePage.getMetalsAndColorsButtonElement().isDisplayed());

        softAssert.assertEquals(
            homePage.getMetalsAndColorsButtonElement()
                    .getText(),
            HEADER_BUTTONS_EXPECTED.get(3)
        );





    }
}
