package com.epam.tc.hw5.steps;

import static com.epam.tc.hw3.data.TestDataExpected.HEADER_BUTTONS_EXPECTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw3.pages.LogInPage;
import com.epam.tc.hw3.pages.ServicePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;

public class DifferentElementsPageSteps extends AbstractBaseStep {

    @Given("I open JDI GitHub site")
    public DifferentElementsPageSteps openWebApp() {
        logInPage.open();
        return this;
    }

    @And("I login as user 'Roman Iovlev'")
    public DifferentElementsPageSteps logIn() {
        logInPage.logIn();
        return this;
    }

    @When("I click on {string} button in Header")
    public DifferentElementsPageSteps clickServiceButton(String button) {
        differentElementsPage.clickHeaderMenuItem(button);
        return this;
    }

    @And("I click on {string} button in Service dropdown")
    public DifferentElementsPageSteps clickDifferentElementsButtonInServiceDropdown(String serviceDropdownItemText) {
        differentElementsPage.clickServiceDropdownMenuItem(serviceDropdownItemText);
        return this;
    }

    @Then("{string} page should be opened")
    public DifferentElementsPageSteps assertDifferentElementsPageTitle(String pageTitleName) {
        assertThat(webDriver.getTitle()).isEqualTo(pageTitleName);
        return this;
    }

    @When("I select 'Water' and 'Wind' checkboxes")
    public DifferentElementsPageSteps selectWaterAndWindCheckboxes() {
        differentElementsPage.clickWaterCheckBox()
                             .clickWindCheckBox();
        return this;
    }

    @Then("{string} and {string} checkboxes should be selected")
    public DifferentElementsPageSteps checkLogRowForWaterAndWind(String water, String wind) {

        assertThat(differentElementsPage
            .getLogRowWater()
            .getText())
            .contains(water);

        assertThat(differentElementsPage
            .getLogRowWind()
            .getText())
            .contains(wind);
        return this;
    }

    @When("I select radio 'Selen'")
    public DifferentElementsPageSteps selectSelenRadio() {
        differentElementsPage.clickSelenElement();
        return this;
    }

    @Then("Radio {string} should be selected")
    public DifferentElementsPageSteps checkLogRowForRadioButton(String radio) {
        assertThat(differentElementsPage
            .getLogRowSelen()
            .getText())
            .contains(radio);
        return this;
    }

    @When("I select 'Yellow' in dropdown")
    public DifferentElementsPageSteps selectDropdownYellow() {
        differentElementsPage.clickDropdownYellow();
        return this;
    }

    @Then("{string} should be selected in dropdown")
    public DifferentElementsPageSteps checkLogRowForDropdown(String yellow) {

        assertThat(differentElementsPage
            .getLogRowYellow()
            .getText())
            .contains(yellow);
        return this;
    }
}
