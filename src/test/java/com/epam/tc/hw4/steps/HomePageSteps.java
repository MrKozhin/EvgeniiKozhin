package com.epam.tc.hw4.steps;

import static com.epam.tc.hw3.data.TestDataExpected.HEADER_BUTTONS_EXPECTED;
import static com.epam.tc.hw3.data.TestDataExpected.SIDEBAR_EXPECTED;
import static com.epam.tc.hw3.data.TestDataExpected.TEXTS_EXPECTED;

import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LogInPage;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class HomePageSteps {

    WebDriver webDriver;
    LogInPage logInPage;
    HomePage homePage;
    SoftAssert softAssert;

    public HomePageSteps(WebDriver driver) {
        this.webDriver = driver;
        this.logInPage = new LogInPage(webDriver);
        this.homePage = new HomePage(webDriver);
        this.softAssert = new SoftAssert();
    }


    @Step("1. Open test site by URL")
    public HomePageSteps openWebApp() {
        logInPage.open();
        return this;
    }

    @Step("2. Assert Browser title")
    public HomePageSteps checkPageTitle(String title) {
        softAssert.assertEquals(webDriver.getTitle(), title);
        return this;
    }

    @Step("3. Perform login")
    public HomePageSteps checkLoggingIn() {
        logInPage.logIn();
        return this;
    }

    @Step("4. Assert Username is logged in")
    public HomePageSteps checkUsername(String username) {
        softAssert.assertEquals(logInPage.getLoggedInUsername().getText(), username);
        return this;
    }

    @Step("5. Assert that there are 4 items on the header section are displayed, and they have proper texts")
    public HomePageSteps checkHeaderButtons() {
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

        return this;
    }

    @Step("6. Assert that there are 4 images on the Index Page, and they are displayed")
    public HomePageSteps checkHomePageImages() {
        for (int i = 0; i < 4; i++) {
            softAssert.assertTrue(homePage
                .imagesIsDisplayedList()
                .get(i)
                .isDisplayed()
            );
        }

        return this;
    }

    @Step("7. Assert that there are 4 texts on the Index Page under icons, and they have proper texts")
    public HomePageSteps checkImageTexts(List textsExpected) {
        for (WebElement text : homePage.mainPageTextsList()) {
            softAssert.assertTrue(text.isDisplayed());
        }

        softAssert.assertEquals(homePage
            .mainPageTextsList()
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList()), textsExpected
        );

        return this;
    }

    @Step("8. Assert that there is the iframe with “Frame Button” exist")
    public HomePageSteps checkFrameButton() {
        softAssert.assertTrue(homePage.getFrame().isDisplayed());
        return this;
    }

    @Step("9. Switch to the iframe and check that there is “Frame Button” in the iframe")
    public HomePageSteps switchToFrameAndCheckButtonIsEnabled() {
        homePage.switchToFrame();
        softAssert.assertTrue(homePage.getFrameButton().isEnabled());
        return this;
    }

    @Step("10. Switch to original window back")
    public HomePageSteps switchBackToWindow() {
        homePage.switchBack();
        return this;
    }

    @Step("11. Assert that there are 5 items in the Left Section are displayed, and they have proper texts")
    public HomePageSteps checkLeftSideMenuButtons(List sideBarExpected) {
        for (WebElement button : homePage.getLeftSideSideMenuList()) {
            softAssert.assertTrue(button.isDisplayed());
        }

        softAssert.assertEquals(homePage
            .getLeftSideSideMenuList()
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList()), sideBarExpected
        );

        softAssert.assertAll();
        return this;
    }







}
