package com.epam.tc.hw5.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw3.pages.LogInPage;
import com.epam.tc.hw5.pages.UserTablePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class UserTablePageSteps {

    protected LogInPage logInPage;
    protected WebDriver webDriver;
    protected UserTablePage userTablePage;

    public UserTablePageSteps(WebDriver driver) {
        this.webDriver = driver;
        this.logInPage = new LogInPage(driver);
        this.userTablePage = new UserTablePage(driver);
    }


}
