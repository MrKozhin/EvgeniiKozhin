package com.epam.tc.hw3.pagetests;

import static com.epam.tc.hw3.data.TestDataExpected.HEADER_BUTTONS_EXPECTED;
import static com.epam.tc.hw3.data.TestDataExpected.SIDEBAR_EXPECTED;
import static com.epam.tc.hw3.data.TestDataExpected.TEXTS_EXPECTED;

import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestHomePage extends HW3BaseTest {

    @DataProvider
    public Object[][] buttonsTextDataProvider() {
        return new Object[][] {
            {"Home Page", "ROMAN IOVLEV"}
        };
    }


    @Test(dataProvider = "buttonsTextDataProvider")
    public void testHomePage(String title, String username) {

        //        2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), title);

        //        4. Assert Username is logged in
        softAssert.assertEquals(logInPage.getLoggedInUsername().getText(), username);

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

        //        6. Assert that there are 4 images on the Index Page, and they are displayed
        for (int i = 0; i < 4; i++) {
            softAssert.assertTrue(homePage
                .imagesIsDisplayedList()
                .get(i)
                .isDisplayed()
            );
        }

        //        7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        for (WebElement text : homePage.mainPageTextsList()) {
            softAssert.assertTrue(text.isDisplayed());
        }

        softAssert.assertEquals(homePage
            .mainPageTextsList()
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList()), TEXTS_EXPECTED
        );

        //        8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.getFrame().isDisplayed());

        //       9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToFrame();
        softAssert.assertTrue(homePage.getFrameButton().isEnabled());

        //        10. Switch to original window back
        homePage.switchBack();

        //        11. Assert that there are 5 items in the Left Section are displayed, and they have proper texts
        for (WebElement button : homePage.getLeftSideSideMenuList()) {
            softAssert.assertTrue(button.isDisplayed());
        }

        softAssert.assertEquals(homePage
            .getLeftSideSideMenuList()
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList()), SIDEBAR_EXPECTED
        );

        softAssert.assertAll();
    }
}
