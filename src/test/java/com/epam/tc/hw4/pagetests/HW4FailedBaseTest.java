package com.epam.tc.hw4.pagetests;

import com.epam.tc.hw3.config.DriverManager;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LogInPage;
import com.epam.tc.hw3.pages.ServicePage;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class HW4FailedBaseTest {

    protected WebDriver webDriver;
    protected SoftAssert softAssert;
    protected LogInPage logInPage;
    protected HomePage homePage;



    @BeforeClass
    public void prepareToStart(ITestContext context) {
        webDriver = new DriverManager().setUpDriver();
        webDriver.manage().window().maximize();
        context.setAttribute("driver", webDriver);
    }

    @BeforeMethod
    public void setUp() {

        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        logInPage = new LogInPage(webDriver);
        homePage = new HomePage(webDriver);

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
