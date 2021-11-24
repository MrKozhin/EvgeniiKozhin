package com.epam.tc.hw4.pagetests;

import com.epam.tc.hw3.config.DriverManager;
import com.epam.tc.hw4.steps.HomePageSteps;
import com.epam.tc.hw4.steps.ServicePageSteps;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class HW4BaseTest {

    protected WebDriver webDriver;
    protected HomePageSteps homePageSteps;
    protected ServicePageSteps servicePageSteps;


    @BeforeClass
    public void prepareToStart() {
        webDriver = new DriverManager().setUpDriver();
        webDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void setUp() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        homePageSteps = new HomePageSteps(webDriver);
        servicePageSteps = new ServicePageSteps(webDriver);
    }

    @AfterClass
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();      //        12. Close Browser
        }
    }

}
