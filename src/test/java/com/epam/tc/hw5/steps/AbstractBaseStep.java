package com.epam.tc.hw5.steps;

import com.epam.tc.hw3.pages.LogInPage;
import com.epam.tc.hw3.pages.ServicePage;
import com.epam.tc.hw5.hooks.CucumberHook;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseStep {

    protected WebDriver webDriver;
    protected LogInPage logInPage;
    protected ServicePage differentElementsPage;

    public AbstractBaseStep() {
        webDriver = CucumberHook.webDriver;
        logInPage = new LogInPage(webDriver);
        differentElementsPage = new ServicePage(webDriver);
    }
}
