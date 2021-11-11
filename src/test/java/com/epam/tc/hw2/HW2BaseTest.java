package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class HW2BaseTest {

    protected WebDriver webDriver;
    protected WebElement webElement;
    protected WebDriverWait webDriverWait;
    protected SoftAssert softAssert;
    protected Properties properties;


    @BeforeMethod
    public void setUp() {

        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("src/main/resources/com/epam/tc/hw2/login.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println(e.getMessage() + "   \"Properties file not found\"");
        }

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 10);
        softAssert = new SoftAssert();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);


        //        1. Open test site by URL

        webDriver.navigate().to(properties.getProperty("url"));

        //        3. Perform login

        webElement = webDriver.findElement(By.className("profile-photo"));
        webElement.click();

        webElement = webDriver.findElement(By.id("name"));
        webElement.click();
        webElement.sendKeys(properties.getProperty("username"));

        webElement = webDriver.findElement(By.id("password"));
        webElement.click();
        webElement.sendKeys(properties.getProperty("password"));

        webElement = webDriver.findElement(By.id("login-button"));
        webElement.click();

    }

    @AfterMethod
    public void tearDown() {

        //        12. Close Browser

        webDriver.quit();
    }
}
