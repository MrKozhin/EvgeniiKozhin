package com.epam.tc.hw6.test;

import com.epam.tc.hw4.steps.HomePageSteps;
import com.epam.tc.hw4.steps.ServicePageSteps;
import com.epam.tc.hw6.service.WebDriverProvider;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class HW6BaseTest {
    public WebDriver webDriver;
    protected HomePageSteps homePageSteps;
    protected ServicePageSteps servicePageSteps;

    @BeforeMethod
    public void setUp() {
        webDriver = WebDriverProvider.getWebDriver();

        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        homePageSteps = new HomePageSteps(webDriver);
        servicePageSteps = new ServicePageSteps(webDriver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverProvider.closeDriver();     //        12. Close Browser

    }

}
