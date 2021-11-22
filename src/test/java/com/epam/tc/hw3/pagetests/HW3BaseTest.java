package com.epam.tc.hw3.pagetests;

import com.epam.tc.hw3.config.DriverManager;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LogInPage;
import com.epam.tc.hw3.pages.ServicePage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class HW3BaseTest {

    protected WebDriver webDriver;
    protected SoftAssert softAssert;
    protected LogInPage logInPage;
    protected HomePage homePage;
    protected ServicePage servicePage;


    @BeforeClass
    public void prepareToStart() {
        webDriver = new DriverManager().setUpDriver();
        webDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void setUp() {

        webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        logInPage = new LogInPage(webDriver);
        homePage = new HomePage(webDriver);
        servicePage = new ServicePage(webDriver);
        softAssert = new SoftAssert();

        logInPage.open()       //        1. Open test site by URL
                 .logIn();     //        3. Perform login
    }

    @AfterClass
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();      //        12. Close Browser
        }
    }

}
