package com.epam.tc.hw4.steps;

import static com.epam.tc.hw3.data.TestDataExpected.HEADER_BUTTONS_EXPECTED;
import static com.epam.tc.hw3.data.TestDataExpected.LOG_ROWS_EXPECTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw3.pages.LogInPage;
import com.epam.tc.hw3.pages.ServicePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ServicePageSteps {
    WebDriver webDriver;
    LogInPage logInPage;
    ServicePage servicePage;

    public ServicePageSteps(WebDriver driver) {
        this.webDriver = driver;
        this.logInPage = new LogInPage(webDriver);
        this.servicePage = new ServicePage(webDriver);
    }


    @Step("1. Open test site by URL")
    public ServicePageSteps openWebApp() {
        logInPage.open();
        return this;
    }

    @Step("2. Assert Browser title")
    public ServicePageSteps checkPageTitle(String title) {
        assertThat(webDriver.getTitle()).isEqualTo(title);
        return this;
    }

    @Step("3. Perform login")
    public ServicePageSteps checkLoggingIn() {
        logInPage.logIn();
        return this;
    }

    @Step("4. Assert User name in the left-top side of screen that user is logged in")
    public ServicePageSteps checkUsername(String username) {
        assertThat(logInPage.getLoggedInUsername().getText())
            .isEqualTo(username);

        assertThat(logInPage.getLoggedInUsername().isDisplayed())
            .isTrue();
        return this;
    }

    @Step("5. Open through the header menu Service -> Different Elements Page")
    public ServicePageSteps openDifferentElementsPage() {
        servicePage.clickHeaderMenuItem(HEADER_BUTTONS_EXPECTED.get(2))
                   .clickDifferentElementsButton();
        return this;
    }

    @Step("6. Select checkbox Water and Wind")
    public ServicePageSteps selectWaterAndWindCheckboxes() {
        servicePage.clickWaterCheckBox()
                   .clickWindCheckBox();
        return this;
    }

    @Step("7. Select radio Selen")
    public ServicePageSteps selectSelenCheckbox() {
        servicePage.clickSelenElement();
        return this;
    }

    @Step("8. Select in dropdown Yellow")
    public ServicePageSteps selectDropdownYellow() {
        servicePage.clickDropdownYellow();
        return this;
    }



    @Step("9.1. Assert that for each checkbox there is an individual log row "
        + "\nand value is corresponded to the status of checkbox")
    public ServicePageSteps checkLogRowForWaterAndWind(String water, String wind) {

        assertThat(servicePage
            .getLogRowWater()
            .getText())
            .contains(water);

        assertThat(servicePage
            .getLogRowWind()
            .getText())
            .contains(wind);
        return this;
    }

    @Step("9.2. Assert that for radio button there is a log row "
        + "\nand value is corresponded to the status of radio button")
    public ServicePageSteps checkLogRowForRadioButton(String radio) {
        assertThat(servicePage
            .getLogRowSelen()
            .getText())
            .contains(radio);
        return this;
    }

    @Step("9.3. Assert that for dropdown there is a log row and value is corresponded to the selected value.")
    public ServicePageSteps checkLogRowForDropdown(String yellow) {
        //

        assertThat(servicePage
            .getLogRowYellow()
            .getText())
            .contains(yellow
            );
        return this;
    }
}
